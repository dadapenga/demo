package com.example.demo.testjava.threadTest;


public class MainRun {
    public  static  void main (String[] args){
        /*ticketclass去继承thread类重新run方法进行多线程跑售票的例子
        Thread one = new TicketTest("one");
        Thread two = new TicketTest("two");
        Thread three = new TicketTest("three");
        one.start();
        two.start();
        three.start();*/


        //RunnableClass类实现Runnable接口，覆盖Runnable的run方法，Runnable的子类对象作为参数传给Thread类的构造函数，Thread类的start方法执行的是runnable子类的run方法
        //让线程Thread执行指定对象的run方法，就必须在Thread构造函数中明确该run方法的Runnable的子类对象
        //这种实现方式避免了java单继承的局限性，Thread其实也集成了Runnable接口，

        RunnableClass r1 = new RunnableClass();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);

        t1.start();
        t2.start();
        t3.start();

    }
}
