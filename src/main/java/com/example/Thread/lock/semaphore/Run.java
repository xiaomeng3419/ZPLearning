package com.example.Thread.lock.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by zhangpan on 2019/1/4.
 */
public class Run {
    public static void main(String[] args) {

        Demoq demoq = new Demoq();


        ThreadP threadP = new ThreadP(demoq);
        ThreadC threadC = new ThreadC(demoq);

        threadP.start();
        threadC.start();



    }
}
