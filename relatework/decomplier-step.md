# 破解软件安装步骤 

 * 本人是新手第一次破解，欢迎大神吐槽。由于我破解的是某知名软件，一下就以A软件来代替了，当然如果某些软件没有采用自己的通信协议，根本不用看本文，在mac环境下直接使用业界抓包软件charles抓包即可。
个人破解apk系列安装包，自己目前分三个步骤：（不知道是否走了弯路，欢迎指正）
1、安装反编译所需软件
2、反编译apk获取源码
3、定位button所对应的源码
4、在button所响应的事件找出函数，注入钩子函数即可抓取自己想抓取的内容了

本文工具篇：
 1、apltools
 2、dex2jar
 3、jadxGUI
 4、jdGUI（在破解A软件的过程中，源码反编译不全在A软件中我尝试过就放弃了）

本文

软件1、apktools 安装步骤：
 推荐一波（本人也不知道是否是原创，好用就管事） [安装教程](https://www.jianshu.com/p/ad56d26767d4)
 
 安装成功与否我就不概述了，如若行不通就进行chmod +x 赋权试试吧

软件2、dex2jar
[官网下载地址](https://sourceforge.net/projects/dex2jar/)
解压之后进行赋权
```bash
chmod +x d2j-dex2jar.sh

chmod +x d2j_invoke.sh
```
dex2jar安装完毕

软件3、 jadxGUI

  ```bash
    git clone https://github.com/skylot/jadx.git  
    cd jadx  
    ./gradlew.sh dist  

```
或者是下载zip包[下载地址](https://github.com/skylot/jadx/releases/tag/v0.9.0)

```bash
  cd jadx-0.9.0
  cd lib
  java -jar jadx-gui-0.9.0.jar
```
运行即可

软件4、
```bash
ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)" < /dev/null 2> /dev/null ; brew install caskroom/cask/brew-cask 2> /dev/null
brew cask install jd-gui
```
顺便记录一下ruby命令含义
ruby

关于软件的使用我就不说了


首先使用apktool反编译apk  `apktool d  A.apk` 得到的结果如下图所示（图一）


    