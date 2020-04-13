# java代码生成器

#### 项目介绍
1.本项目采用SPringBoot+JPA+Mybaties架构
----------------------------------------------------------------------------------
2.主要功能简介
可连接数据库MYSQL，ORACLE（暂未开发）,SQLServer(暂未开发)
生成SpringMVC传统开发模式下的bean，mapper，service，controller代码
-----------------------------------------------------------------------------------
3.项目支持部署服务器和本地运行两种方式



#### 软件架构
springBoot项目使用IDEA进行导入


#### 安装教程

1. 创建mysql数据库 项目中sql文件夹内有执行脚本 数据库名称：automation
2. 修改appliaction.yml中数据库连接信息，端口号，生成日志历史文件夹路径file.url
3. 在IEDA中使用mvn命令进行打包 mvn clean package
4.打包成功界面
![输入图片说明](https://gitee.com/uploads/images/2018/0604/091444_e22a15bd_424304.png "1.png")

5.jar包在项目中的位置

![输入图片说明](https://gitee.com/uploads/images/2018/0604/091539_b5066fb2_424304.png "屏幕截图.png")

6.拷贝项目至服务器或者其他电脑安装（环境必须是JDK1.8）
7.使用命令启动项目 java -jar amation.jar
![输入图片说明](https://gitee.com/uploads/images/2018/0604/091816_88d3becd_424304.png "屏幕截图.png")
备注说明：进入放jar包的上级目录处按住Shift+鼠标右击--》点击在此处打开命令 输入启动命令  java -jar amation.jar 出现下面页面表示启动成功

![输入图片说明](https://gitee.com/uploads/images/2018/0604/092022_146c2dc3_424304.png "屏幕截图.png")

8.在浏览器中输入IP地址:端口进行访问
 **_必须是你的IP地址 本机使用127.0.0.1或者IP不要使用localhost_** 

#### 使用说明

a.代码下载

1. 打开页面如下
![输入图片说明](https://gitee.com/uploads/images/2018/0604/092306_5dc77fc0_424304.png "屏幕截图.png")
2. 输入包名，链接数据库
![输入图片说明](https://gitee.com/uploads/images/2018/0604/092606_71d87a43_424304.png "屏幕截图.png")
3. 选择表名勾选需要生成bean,mapper,service,controller的映射字段
![输入图片说明](https://images.gitee.com/uploads/images/2019/0211/093031_aab2f72f_424304.png "屏幕截图.png")
4.点击提交生成下载代码
![输入图片说明](https://images.gitee.com/uploads/images/2019/0211/093524_11d879b5_424304.png "屏幕截图.png")


b.数据库设计文档导出

1.打开界面，输入数据库连接信息，读取数据库，选中所有表或者个别表点击导出
![输入图片说明](https://images.gitee.com/uploads/images/2019/0211/093805_3aa9fe94_424304.png "屏幕截图.png")


#### 参与贡献

1. 小康


#### 码云特技

1. 使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2. 码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3. 你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4. [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5. 码云官方提供的使用手册 [http://git.mydoc.io/](http://git.mydoc.io/)
6. 码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)