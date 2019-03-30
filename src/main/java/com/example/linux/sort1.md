查看系统进程命令 ps -ef  ps aux     两者没有什么区别，主要的区别就是两者的显示风格

jps 查看所运行的java程序
jps（结果如下所示）
31382 jar
31418 jar
31867 Jps

查看进程id运行时的工作目录
pwdx 31382 即可
31382: /home/local/xyz/TaskManager

组合命令
jps | xargs pwdx


组合命令取第一列的结果作为下一个命令的输入
jps | grep jar  |awk '{print $1}' | xargs pwdx
31382: /home/local/xyz/TaskManager
31418: /home/local/xyz/TimerServer
    





查询文本中ip排序前3的ip
sort ip.txt | uniq -c | sort -rn | head 3

显示某一个文件的前十行的内容
sed -n "1,10" a.txt
