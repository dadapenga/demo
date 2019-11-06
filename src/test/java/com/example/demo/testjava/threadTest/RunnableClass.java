package com.example.demo.testjava.threadTest;

import com.example.demo.testjava.genericsMethodTest.GenericMethodTest;

public class RunnableClass implements Runnable{
    //共享tickerNum
    private  int  ticketNum=100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //线程同步，只有有同步的内容完成了后续的线程才能进入进行执行  线程进入同步状态变成0，执行完状态变成1
            //同步的前提，两个一级两个以上的线程才要进行同步，多线程使用同一个锁，有些代码不需要同步
            //解决多线程的安全问题，弊端：线程每次都要判断锁  多消耗资源
            synchronized (obj) {
                if (ticketNum > 0) {
                    //加入sleep会出现多线程的共享数据的同步问题，前一个线程没有执行完代码，下一个线程就进入了
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "-----ticket sold :" + ticketNum--);
                }
                if (ticketNum <= 0) {
                    break;
                }
            }
        }

    }
}
