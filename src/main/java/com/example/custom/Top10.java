package com.example.custom;

import java.util.*;

/**
 * Created by zhangpan on 2019/4/1.
 */
public class Top10 {

    public static void main(String[] args) {
        fin_10_max();
    }

    private static void fin_10_max() {
        //��100000�����Ž�ArrayList���͵�����
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        //�������ʮ�������
        for(int i = 0;i < 100000;i++) {
            int val = random.nextInt(10000)+1;
            arrayList.add(val);
        }

        //��д�Ƚ�����Ŀ����Ϊ�˱Ƚϵ�hashmap�е�value
        Comparator<Map.Entry<Integer,Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        };

        //����һ�����ȼ����еĶ����Զ��幹�캯������Ƚ�����Ҫ��д����С��Ϊ10
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(20,comparator);

        //����һ��hashmap���󣬣���Ҫ��¼���Լ����ĳ��ִ�����
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        //����������arraylist����¼ÿ��ֵ���ֵĴ���
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            if(hashMap.containsKey(next)) {
                //��¼����
                hashMap.put(next,hashMap.get(next)+1);
            }else {
                //���ֵ��һ�γ���
                hashMap.put(next,1);
            }
        }

        //����������hashmap
        Iterator<Map.Entry<Integer,Integer>> iterator1 = hashMap.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer,Integer> next = iterator1.next();
            int value = next.getValue();  //�õ�ÿһ�α���ʱ��valueֵ
            //������ȼ�����������ݳ���С��10�����������
            if(priorityQueue.size() < 20) {
                priorityQueue.add(next);
            }else {
                //������ݳ���10���Ƚ϶Ӷ���Ԫ�غ�Ҫ�����Ԫ��
                if(priorityQueue.peek().getValue() < value) {
                    //���Ҫ�����Ԫ�ش��ڶӶ���Ԫ�أ����Ƴ��Ӷ�������Ԫ�أ������µ�Ԫ��
                    priorityQueue.remove();
                    priorityQueue.add(next);
                }
            }
        }

        //�������������ȼ����У��ó����
        Iterator<Map.Entry<Integer,Integer>> iterator2 = priorityQueue.iterator();
        System.out.println("���� ���ִ���");
        while(iterator2.hasNext()) {
            Map.Entry<Integer,Integer> next = iterator2.next();
            int key = next.getKey();
            int value = next.getValue();
            System.out.println(key+"   "+value);
        }
    }//����ظ��Ӵ�
    //������ά����
    //�������Ĳ�α���
}