package com.example.demo.testjava.listnode;

import org.mockito.internal.matchers.Null;

import java.sql.SQLOutput;

public  class Node {
    private  String data;
    private  Node next;

    public Node(String data){
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    //在最后一个节点增加新节点，递归调用  递归到最后一个节点
    public void addNode(Node oldNode, Node newNode) {
        System.out.println("now"+oldNode);
        if(this.next==null) {
            this.next = newNode;
        }else {
            this.next.addNode(this.next,newNode);
        }
        System.out.println(oldNode+"=>"+this.next);

//        while (oldNode!=null){
//            oldNode = oldNode.next;
//        }
//        oldNode.next = newNode;
    }

    //添加节点  在当前节点添加节点  更新next节点
    public  void  addNodeThis(String data) {
        Node newNode = new Node(data);
        newNode.next = this.next;
        this.next = newNode;
    }





}
