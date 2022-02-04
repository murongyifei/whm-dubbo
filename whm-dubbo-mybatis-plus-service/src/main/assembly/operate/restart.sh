#!/bin/bash
#如果有时候启动不正常,可能是JDK版本太多的原因下面是解决办法
JAVA_HOME=/usr/java/default
PATH=$JAVA_HOME/bin:$PATH

#MAIN_CLASS="space.whm.demo.dal.provider.SpringBootDubboDalService"
MAIN_CLASS="space.whm.demo.dal.provider.DubboRegistryZooKeeperProviderBootstrap"
DEBUG_PORT=80185
JMX_PORT=80187

cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf
CLASSES_DIR=$DEPLOY_DIR/classes

SPRING_SERVER_PORT=`sed '/server.port/!d;s/.*=//' classes/application.properties | tr -d '\r'`
SERVER_NAME=`sed '/dubbo.application.name/!d;s/.*=//' classes/dubbo.properties | tr -d '\r'`
SERVER_PROTOCOL=`sed '/dubbo.protocol.name/!d;s/.*=//' classes/dubbo.properties | tr -d '\r'`
SERVER_PORT=`sed '/dubbo.protocol.port/!d;s/.*=//' classes/dubbo.properties | tr -d '\r'`
LOGS_FILE=`sed '/dubbo.log4j.file/!d;s/.*=//' classes/dubbo.properties | tr -d '\r'`

PIDFILE=$DEPLOY_DIR/pidfile_$SPRING_SERVER_PORT
if [ -f $PIDFILE ];then
   PID=`cat $PIDFILE`
   tr=`jps -v | grep $PID | grep $DEPLOY_DIR`
   echo "tr:"$tr
   if [ "$tr" != "" ] ; then
      echo "kill $PID"
      kill -9 $PID
   fi
fi
sleep 5

if [ -z "$SERVER_NAME" ]; then
    SERVER_NAME=`hostname`
fi

PIDS=`ps -f | grep java | grep "$CONF_DIR" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $SERVER_NAME already started!"
    echo "PID: $PIDS"
    exit 1
fi

if [ -n "$SERVER_PORT" ]; then
#    SERVER_PORT_COUNT=`netstat -tln | grep $SERVER_PORT | wc -l`
    SERVER_PORT_COUNT=`lsof -i:$SERVER_PORT | grep java| wc -l`
    if [ $SERVER_PORT_COUNT -gt 0 ]; then
        echo "ERROR: The $SERVER_NAME port $SERVER_PORT already used!"
        exit 1
    fi
fi

if [ -n "$SPRING_SERVER_PORT" ]; then
#    SERVER_PORT_COUNT=`netstat -tln | grep $SPRING_SERVER_PORT | wc -l`
    SERVER_PORT_COUNT=`lsof -i:$SPRING_SERVER_PORT | grep java| wc -l`
    if [ $SERVER_PORT_COUNT -gt 0 ]; then
        echo "ERROR: The $SERVER_NAME spring port $SPRING_SERVER_PORT already used!"
        exit 1
    fi
fi

LOGS_DIR=""
if [ -n "$LOGS_FILE" ]; then
    LOGS_DIR=`dirname $LOGS_FILE`
else
    LOGS_DIR=$DEPLOY_DIR/logs
fi
if [ ! -d $LOGS_DIR ]; then
    mkdir $LOGS_DIR
fi
STDOUT_FILE=/root/logfiles/logs/whm-dubbo/$SERVER_NAME.$SPRING_SERVER_PORT.stdout.log

LIB_DIR=$DEPLOY_DIR/lib
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`

JAVA_OPTS=" -Dlogdir=$LOGS_DIR -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "
JAVA_DEBUG_OPTS=""
if [ "$1" = "debug" ]; then
    JAVA_DEBUG_OPTS=" -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=$DEBUG_PORT,server=y,suspend=n "
fi
JAVA_JMX_OPTS=""
if [ "$1" = "jmx" ]; then
    JAVA_JMX_OPTS=" -Dcom.sun.management.jmxremote.port=$JMX_PORT -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false "
fi
JAVA_MEM_OPTS=""
BITS=`java -version 2>&1 | grep -i 64-bit`
if [ -n "$BITS" ]; then
    JAVA_MEM_OPTS=" -server -Xmx2g -Xms2g -Xmn256m -XX:PermSize=128m -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "
else
    JAVA_MEM_OPTS=" -server -Xms1g -Xmx1g -XX:PermSize=128m -XX:SurvivorRatio=2 -XX:+UseParallelGC "
fi

CLASSPATH=$CLASSPATH:$CLASSES_DIR:$CONF_DIR
files=`ls -1 ${LIB_DIR}`
for file in ${files} ;do
        CLASSPATH=$CLASSPATH:${LIB_DIR}/${file}
done
export CLASSPATH
#echo $CLASSPATH
echo -e "Starting the $SERVER_NAME ...\c"
#nohup java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS $MAIN_CLASS > $STDOUT_FILE 2>&1 &
java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS $MAIN_CLASS > $STDOUT_FILE 2>&1 &
PID=$!
echo $PID > $PIDFILE

##############
#COUNT=0
#while [ $COUNT -lt 1 ]; do    
#    echo -e ".\c"
#    sleep 1 
#    if [ -n "$SERVER_PORT" ]; then
#        if [ "$SERVER_PROTOCOL" == "dubbo" ]; then
#           COUNT=`echo status | nc -i 1 127.0.0.1 $SERVER_PORT | grep -c OK`
#        else
#            COUNT=`netstat -an | grep $SERVER_PORT | wc -l`
#        fi
#    else
#       COUNT=`ps -f | grep java | grep "$DEPLOY_DIR" | awk '{print $2}' | wc -l`
#    fi
#    if [ $COUNT -gt 0 ]; then
#        break
#    fi
#done   
##############

COUNT=0
while [ $COUNT -lt 1 ]; do    
    echo -e ".\c"
    sleep 2 
    COUNT=`ps -f | grep java | grep "$DEPLOY_DIR" | awk '{print $2}' | wc -l`
    if [ $COUNT -gt 0 ]; then
        break
    fi
done

echo "OK!"
#PIDS=`ps auxf | grep ${MAIN_CLASS} | grep -v "grep"| awk '{print $2}'`
echo "PID: $PID"
echo "STDOUT: $STDOUT_FILE"
