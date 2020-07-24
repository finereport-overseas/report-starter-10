# Instruction

## Install Maven
To build the project.

## 安装ant
To build the plugin. For reference: http://doc.fanruan.com/display/VHD/1.+Installation+and+Configuration+of+Essential+Tools

## 配置开发工程
Use IntelliJ IDEA to open this folder.

If you want to copy Jars into webroot/WEB-INF/lib, please run: ```mvn install```

**Caution：**该工程依赖的jar为私有maven服务器，注意不要删除pom.xml中的repositories。
**Caution：**该工程依赖的jar为私有maven服务器，注意不要删除pom.xml中的repositories。

## 启动应用程序

### 复制插件配置

* 将plugin.xml文件复制到webroot/WEB-INF/plugins/plugin-xyz-1.0目录下，其中xyz一般用插件id表示。
* 在开发工具内部，手动编译插件class文件到插件目录，注意可能需要修改插件的pom.xml的文件
![compile](screenshots/compile.png)

### 启动设计器
如果希望正常的进行插件开发，使用```com.fr.learn.Leaner```启动设计器。

如果希望进行设计器调试，则使用```com.fr.learn.Leaner4Debug```启动设计器。

### 选择报表运行环境
一般情况启动设计器的时候，会自动使用上一次使用的报表运行环境，我们这里需要新建一个本地报表运行环境，并指向这个开发目录下的webroot/WEB-INF目录。


## 修改依赖的jar版本
只需要更改pom.xml中的common-version属性即可。

|common-version|含义|
|--------------|----|
|10.0-RELEASE-SNAPSHOT|10.0的测试版本快照|
|10.0-SNAPSHOT|10.0的正式版本快照|
|10.0|10.0的正式版本|