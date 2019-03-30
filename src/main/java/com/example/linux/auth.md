链接：https://www.nowcoder.com/questionTerminal/2276e48a891f4ddfaee6bbacec1d5860?orderByHotValue=1&page=1&onlyReference=false
来源：牛客网

文件目录data当前权限为rwx --- ---，只需要增加用户组可读权限，但不允许写操作，具体方法为：


使用chomd命令改变文件权限。Linux文件基本权限有9个，owner,group,others三种身份对应各自read,write,execute三种权限。文件权限字符：“-rwxrwxrwx”三个一组。数字化r:4 w:2 x:1  增加用户组可读，但不可写，第一组和第三组默认为0，只在第二组中添加r-x即可 chomd +050

文件默认666，没有x权限，目录默认777，有x权限，题中是目录。

bash脚本文件一般第一行开头是
#! (查找解释器)


#### 如何获取上一条命令执行的返回码
$0
Shell本身的文件名
$!
Shell最后运行的后台Process的PID(后台运行的最后一个进程的进程ID号)
$?
最后运行的命令的结束代码（返回值）即执行上一个指令的返回值 (显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误)
$#
添加到Shell的参数个数


u 代表用户. 
g 代表用户组. 
o 代表其他. 
a 代表所有.

这意味着chmod u+x somefile 只授予这个文件的所属者执行的权限 
而 chmod +x somefile 和 chmod a+x somefile 是一样的 
Just doing +x will apply it to all flags: [u]ser, [g]roup, [o]thers.

greater than 大于 gt greater than or equal 大于等于 ge

$ ./test.sh
 
$ . ./test.sh
点斜杠，点空格斜杠，两者都可以执行脚本，但是：
第一种方式是在子进程中运行脚本，第二种方式是在当前进程中执行脚本。
非当前进程是看不到aa变量的

