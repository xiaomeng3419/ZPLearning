#
```bash
awk  '{printf("insert into taobao_account_mail(account, password, mail_status) values( '"\'%s\'"', '"\'%s\'"',0);\n",$1,$2)}'  163account300s.txt >3.txt
```

�鿴��־�ļ��ļ��ɣ�Ҳ������less���
Ҳ������grep���
��׼unix/linux�µ�grepͨ�����²�������������
grep -C 5 foo file ��ʾfile�ļ���ƥ��foo�ִ������Լ�����5��
grep -B 5 foo file ��ʾfoo��ǰ5��
grep -A 5 foo file ��ʾfoo����5��
�鿴grep�汾�ķ�����
grep -V