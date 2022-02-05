# whm-dubbo
dubbo3.0.5有个问题没解决,先用2.7.15

配置hosts:=======
127.0.0.1 mylocal.whm.space

安装zookeeper:===
https://archive.apache.org/dist/zookeeper/zookeeper-3.4.13/

启动类:==========
两个Provider
DubboMybatisPlusProvider
DubboMybatisTkProvider
一个Consumer
DubboConsumer
启动后访问地址:====
http://localhost:9440/test
http://localhost:9440/testth


maven 如何解决pom.xml 父子版本号变动的问题===========
JAVA子父工程版本控制_Maven更新父子模块的版本号
https://blog.csdn.net/weixin_35098081/article/details/114773552
mvn versions:set -DnewVersion=1.0.1-SNAPSHOT
会发现在父模块和子模块下面都生成maven的版本控制文件(姑且这么叫吧,虽然看起来就是一个文件备份)pom.xml.versionsBackup.
??? mvn versions:update-child-modules
