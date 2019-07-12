#
```bash
awk  '{printf("insert into taobao_account_mail(account, password, mail_status) values( '"\'%s\'"', '"\'%s\'"',0);\n",$1,$2)}'  163account300s.txt >3.txt
```

查看日志文件的技巧，也可以用less命令，
也可以用grep命令。
标准unix/linux下的grep通过以下参数控制上下文
grep -C 5 foo file 显示file文件中匹配foo字串那行以及上下5行
grep -B 5 foo file 显示foo及前5行
grep -A 5 foo file 显示foo及后5行
查看grep版本的方法是
grep -V