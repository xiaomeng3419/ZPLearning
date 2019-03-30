package com.example.tencent;

/**
 * Created by zhangpan on 2019/3/18.
 * 给一个函数，返回 0 和 1，概率为 p 和 1-p，请你实现一个函数，使得返回 01 概率一样。
 * 两次调用该RANDOM函数，如果其概率为P(x)，调用2次

 P(1) = p       P(0) = 1-p

 P'(1) =p      P'(0) = 1-p

 概率如下：

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
