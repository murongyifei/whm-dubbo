# whm-dubbo
dubbo3.0.5有个问题没解决,先用2.7.15

数据库脚本:=======
doc/test.sql 
doc/user_info.sql

配置hosts:=======
127.0.0.1 mylocal.whm.space

安装zookeeper:===
https://archive.apache.org/dist/zookeeper/zookeeper-3.4.13/

启动类:==========
三个Provider
DubboMybatisProvider
DubboMybatisPlusProvider
DubboMybatisTkProvider
一个Consumer
DubboConsumer
启动后访问地址:====
http://localhost:9440/test
http://localhost:9440/testth
http://localhost:9440/user/getUserInfoById?id=2

maven 如何解决pom.xml 父子版本号变动的问题===========
JAVA子父工程版本控制_Maven更新父子模块的版本号
https://blog.csdn.net/weixin_35098081/article/details/114773552
mvn versions:set -DnewVersion=1.0.1-SNAPSHOT
会发现在父模块和子模块下面都生成maven的版本控制文件(姑且这么叫吧,虽然看起来就是一个文件备份)pom.xml.versionsBackup.
??? mvn versions:update-child-modules

IDEA Build Project 编译时不替换占位符解决办法=======
File -> Settings -> Build,Execution,Deployment -> Build Tools -> Maven -> Runner
勾上，将编译托管给maven来解决。
![image](https://user-images.githubusercontent.com/9797304/152683330-5d9e0f3f-2352-41f1-b2b7-5c42562c1133.png)

![image](https://user-images.githubusercontent.com/9797304/152683459-a46d9b75-109b-42d6-935b-6e3de8b3064a.png)

