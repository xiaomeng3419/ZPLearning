�鿴ϵͳ�������� ps -ef  ps aux     ����û��ʲô������Ҫ������������ߵ���ʾ���

jps �鿴�����е�java����
jps�����������ʾ��
31382 jar
31418 jar
31867 Jps

�鿴����id����ʱ�Ĺ���Ŀ¼
pwdx 31382 ����
31382: /home/local/xyz/TaskManager

�������
jps | xargs pwdx


�������ȡ��һ�еĽ����Ϊ��һ�����������
jps | grep jar  |awk '{print $1}' | xargs pwdx
31382: /home/local/xyz/TaskManager
31418: /home/local/xyz/TimerServer
    





��ѯ�ı���ip����ǰ3��ip
sort ip.txt | uniq -c | sort -rn | head 3

��ʾĳһ���ļ���ǰʮ�е�����
sed -n "1,10" a.txt
