package com.example.demo.testjava.threadTest;

public class TicketTest extends Thread {
    TicketTest(String name){
        super((name));
    }
    //可以设置成静态
    private static int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            if(ticketNum>0) {
                System.out.println(currentThread().getName() + "-----ticket sold :" + ticketNum--);
            }
            if (ticketNum<=0){break;}
        }
    }
}

