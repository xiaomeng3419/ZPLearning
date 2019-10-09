package com.example.interview.tencent;

/**
 * Created by zhangpan on 2019/3/18.
 * ��һ������������ 0 �� 1������Ϊ p �� 1-p������ʵ��һ��������ʹ�÷��� 01 ����һ����
 * ���ε��ø�RANDOM��������������ΪP(x)������2��

 P(1) = p       P(0) = 1-p

 P'(1) =p      P'(0) = 1-p

 �������£�

 11  p*p        10  p*(1-p)

 01 (1-p)*p   00 (1-p)*(1-p)
 */
public class TC01 {
    int random_0_1()
    {
//        int i = RANDOM();
//        int j = RANDOM();
        int result,i=0,j=0;

        while (true)
        {
            if (i == 0 && j == 1)
            {
                result = 0;
                break;
            }
            else if (i == 1 && j == 0)
            {
                result = 1;
                break;
            }
            else
                continue;
        }

        return result;
    }
}
