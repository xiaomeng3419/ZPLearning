package com.example.innerClazz;

/**
 * Created by zhangpan on 2019/3/17.
 */
public class StaticTest {
    private static String name = "woobo";
    private String num = "X001";
    static class Person{ // ��̬�ڲ��������public,protected,private����

        // ��̬�ڲ����п��Զ��徲̬���߷Ǿ�̬�ĳ�Ա
        private String address = "China";

        private static String x="as";
        public String mail = "kongbowoo@yahoo.com.cn";//�ڲ��๫�г�Ա
        public void display(){
            //System.out.println(num);//����ֱ�ӷ����ⲿ��ķǾ�̬��Ա

// ��̬�ڲ��಻�ܷ����ⲿ��ķǾ�̬��Ա(�����Ǿ�̬�����ͷǾ�̬����)
            System.out.println(name);//ֻ��ֱ�ӷ����ⲿ��ľ�̬��Ա

//��̬�ڲ���ֻ�ܷ����ⲿ��ľ�̬��Ա(������̬�����;�̬����)
            System.out.println("Inner " + address);//���ʱ��ڲ����Ա��
        }
    }
    public void printInfo(){
        Person person = new Person();
        DyClass dyClass = new DyClass();

        dyClass.display();
// �ⲿ������ڲ���ķǾ�̬��Ա:ʵ�����ڲ��༴��

        person.display();

        //System.out.println(mail);//���ɷ���
        //System.out.println(address);//���ɷ���
        System.out.println(person.address);//���Է����ڲ����˽�г�Ա

        System.out.println(Person.x);// �ⲿ������ڲ���ľ�̬��Ա���ڲ���.��̬��Ա
        System.out.println(person.mail);//���Է����ڲ���Ĺ��г�Ա
    }
    class DyClass{
        private String dname;
        private  int dnum=0;
        private void display(){
            System.out.println("---------------------------------");
            System.out.println(dname);
            System.out.println(dnum);
            System.out.println(name);
            System.out.println(num);
            System.out.println("---------------------------------");
        }
    }
    public static void main(String[] args){
        StaticTest staticTest = new StaticTest();
        staticTest.printInfo();
        Person p = new StaticTest.Person();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        });
        thread.start();
    }

}
