package com.example.demo.testjava.genericsMethodTest;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodTest {

    public static  <E> void print (E[] inputArray){

    }

    public static  void main(String args[]){
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("aaa");
//        arrayList.add(100);
        for(int i=0;i<arrayList.size();i++){
            String item = (String)arrayList.get(i);
            System.out.println("fanxingceshi,item="+item);
        }
    }
}
