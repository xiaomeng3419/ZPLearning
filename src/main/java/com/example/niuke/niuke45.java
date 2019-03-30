package com.example.niuke;
import java.util.Random;
/**
 * Created by zhangpan on 2019/3/22.
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,
 * “Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0
 */
public class niuke45 {
   private  static int[]  ks = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13};
    public boolean isContinuous(int [] numbers) {
        if(numbers.length == 0){
            return false;
        }
        int flag = 0;
        int j=0;
        int[] temp = new int[numbers.length];
        for (int i = 0;i<numbers.length;i++){
            if(numbers[i] == 0 ){
                flag++;
            }else {
             temp[j] = numbers[i];
             j++;
            }
        }
        if(flag==4){
            return true;
        }

        for (int i = 0;i<numbers.length-flag;i++){
            for (int x = i+1;x<numbers.length-flag;x++){
                if(temp[i]>temp[x]){
                    int va = temp[i];
                    temp[i] = temp[x];
                    temp[x] = va;
                }
            }
        }
        int key  = temp[0];
        int kex = key;
        for (int i = 1 ; i< numbers.length-flag;i++){
            if(temp[i] -key == 0){
                return false;
            }
            if(temp[i]-key==1){
                key = temp[i];
                continue;
            }else {
                int t  = temp[i] - key-1;
                if(t>flag){
                    return false;
                }else {
                    flag = flag-t;
                    key = temp[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ower = new int[5];
        for (int i = 0 ;i<5 ;i++){
            ower[i] = ks[new Random().nextInt(14)];
//            System.out.println(ower[i]);
        }
//        System.out.println(new niuke45().isContinuous(ower));
        System.out.println(new niuke45().isContinuous(new int[]{1,3,0,5,0}));
    }
}
