# �ƽ������װ���� 

 * ���������ֵ�һ���ƽ⣬��ӭ�����²ۡ��������ƽ����ĳ֪�������һ�¾���A����������ˣ���Ȼ���ĳЩ���û�в����Լ���ͨ��Э�飬�������ÿ����ģ���mac������ֱ��ʹ��ҵ��ץ�����charlesץ�����ɡ�
�����ƽ�apkϵ�а�װ�����Լ�Ŀǰ���������裺����֪���Ƿ�������·����ӭָ����
1����װ�������������
2��������apk��ȡԴ��
3����λbutton����Ӧ��Դ��
4����button����Ӧ���¼��ҳ�������ע�빳�Ӻ�������ץȡ�Լ���ץȡ��������

���Ĺ���ƪ��
 1��apltools
 2��dex2jar
 3��jadxGUI
 4��jdGUI�����ƽ�A����Ĺ����У�Դ�뷴���벻ȫ��A������ҳ��Թ��ͷ����ˣ�

����

���1��apktools ��װ���裺
 �Ƽ�һ��������Ҳ��֪���Ƿ���ԭ�������þ͹��£� [��װ�̳�](https://www.jianshu.com/p/ad56d26767d4)
 
 ��װ�ɹ�����ҾͲ������ˣ������в�ͨ�ͽ���chmod +x ��Ȩ���԰�

���2��dex2jar
[�������ص�ַ](https://sourceforge.net/projects/dex2jar/)
��ѹ֮����и�Ȩ
```bash
chmod +x d2j-dex2jar.sh

chmod +x d2j_invoke.sh
```
dex2jar��װ���

���3�� jadxGUI

  ```bash
    git clone https://github.com/skylot/jadx.git  
    cd jadx  
    ./gradlew.sh dist  

```
����������zip��[���ص�ַ](https://github.com/skylot/jadx/releases/tag/v0.9.0)

```bash
  cd jadx-0.9.0
  cd lib
  java -jar jadx-gui-0.9.0.jar
```
���м���

���4��
```bash
ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)" < /dev/null 2> /dev/null ; brew install caskroom/cask/brew-cask 2> /dev/null
brew cask install jd-gui
```
˳���¼һ��ruby�����
ruby

���������ʹ���ҾͲ�˵��


����ʹ��apktool������apk  `apktool d  A.apk` �õ��Ľ������ͼ��ʾ��ͼһ��


    