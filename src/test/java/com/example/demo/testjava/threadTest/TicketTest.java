package com.example.demo.testjava.threadTest;

public class TicketTest extends Thread {
    TicketTest(String name){
        super((name));
    }
    private static int ticketNum = 100;
    public void run() {
        while (true) {
            if(ticketNum>0) {
                System.out.println(currentThread().getName() + "-----ticket sold :" + ticketNum--);
            }
            if (ticketNum<=0){break;}
        }
    }
}

