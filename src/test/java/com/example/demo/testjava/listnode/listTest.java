package com.example.demo.testjava.listnode;

public class listTest {

    public  static  void  main(String[] args){
        Node root = new Node("1");
        Node test2 = new Node("2");
        Node test3= new Node("3");

        Node cur= root;
        root.setNext(test2);
        test2.setNext(test3);

        root.addNodeThis("1.5");
        while(cur!=null){
            System.out.println(cur.getData());
            cur=cur.getNext();
        }

    }
}
