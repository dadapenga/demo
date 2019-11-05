package com.example.demo.testjava.threadTest;

public class MainRun {
    public  static  void main (String[] args){
        Thread one = new TicketTest("one");
        Thread two = new TicketTest("two");
        Thread three = new TicketTest("three");

        one.start();
        two.start();
        three.start();
    }
}
