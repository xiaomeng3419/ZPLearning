package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/22.
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
 * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友, * 可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class niuke46 {
    public int LastRemaining_Solution(int n, int m) {
       int step = 1;
       int count = 0 ;
       int index = 0;
       int[] flag = new int[n];
       int[] people = new int[n];
       int[] var = new int[n];
       while (count!=n-1){
           if(step == m){
               step = 0;
               people[index] = 1;
               flag[index] = 1;
               var[count++] =index;
               System.out.println(index);
           }
           index=(++index)%n;
           if(people[index]== 0){
               step++;
           }
       }
       return index;
    }
    public int LastRemaining_Solution1(int n, int m) {

        if(n<=0 ||m<=0)
            return -1;
        int last = 0;  //N=1时剩余小孩的新序号一定是0
        //反推回去
        for(int i=2;i<=n;i++){
            last = (last+m)%i;
            System.out.println(last);
        }


        return last;
    }
    public static void main(String[] args) {
        System.out.println(new niuke46().LastRemaining_Solution1(5,2));
    }
}
