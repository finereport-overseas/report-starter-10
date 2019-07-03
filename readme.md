# 工程配置指南

## 安装maven
用于构建开发工程，文档参考：http://wiki.jikexueyuan.com/project/maven/environment-setup.html

## 安装ant
用于构建插件安装包，文档参考：http://wiki.jikexueyuan.com/project/ant/environment-setup.html

## 配置开发工程
直接使用IntelliJ IDEA打开这个目录即可。

如果需要复制jar包到webroot/WEB-INF/lib下，可以执行命令：```mvn install```

## 启动设计器
如果希望正常的进行插件开发，使用```com.fr.learn.Leaner```启动设计器。

如果希望进行设计器调试，则使用```com.fr.learn.Leaner4Debug```启动设计器。

## 修改依赖的jar版本
只需要更改pom.xml中的common-version属性即可。

|common-version|含义|
|--------------|----|
|10.0-RELEASE-SNAPSHOT|10.0的测试版本快照|
|10.0-SNAPSHOT|10.0的正式版本快照|
|10.0|10.0的正式版本|