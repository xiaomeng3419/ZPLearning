���ӣ�https://www.nowcoder.com/questionTerminal/2276e48a891f4ddfaee6bbacec1d5860?orderByHotValue=1&page=1&onlyReference=false
��Դ��ţ����

�ļ�Ŀ¼data��ǰȨ��Ϊrwx --- ---��ֻ��Ҫ�����û���ɶ�Ȩ�ޣ���������д���������巽��Ϊ��


ʹ��chomd����ı��ļ�Ȩ�ޡ�Linux�ļ�����Ȩ����9����owner,group,others������ݶ�Ӧ����read,write,execute����Ȩ�ޡ��ļ�Ȩ���ַ�����-rwxrwxrwx������һ�顣���ֻ�r:4 w:2 x:1  �����û���ɶ���������д����һ��͵�����Ĭ��Ϊ0��ֻ�ڵڶ��������r-x���� chomd +050

�ļ�Ĭ��666��û��xȨ�ޣ�Ŀ¼Ĭ��777����xȨ�ޣ�������Ŀ¼��

bash�ű��ļ�һ���һ�п�ͷ��
#! (���ҽ�����)


#### ��λ�ȡ��һ������ִ�еķ�����
$0
Shell������ļ���
$!
Shell������еĺ�̨Process��PID(��̨���е����һ�����̵Ľ���ID��)
$?
������е�����Ľ������루����ֵ����ִ����һ��ָ��ķ���ֵ (��ʾ���������˳�״̬��0��ʾû�д��������κ�ֵ�����д���)
$#
��ӵ�Shell�Ĳ�������


u �����û�. 
g �����û���. 
o ��������. 
a ��������.

����ζ��chmod u+x somefile ֻ��������ļ���������ִ�е�Ȩ�� 
�� chmod +x somefile �� chmod a+x somefile ��һ���� 
Just doing +x will apply it to all flags: [u]ser, [g]roup, [o]thers.

greater than ���� gt greater than or equal ���ڵ��� ge

$ ./test.sh
 
$ . ./test.sh
��б�ܣ���ո�б�ܣ����߶�����ִ�нű������ǣ�
��һ�ַ�ʽ�����ӽ��������нű����ڶ��ַ�ʽ���ڵ�ǰ������ִ�нű���
�ǵ�ǰ�����ǿ�����aa������

