package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    int  i=0;
    @RequestMapping("/hello")
    public String index() {
        System.out.println(i);
        i++;
        return "兰总+i" ;
    }

    @RequestMapping("/tell")
    public  int[] index1(){
        int[] a = new int[10];
        for(;i<10;i++){a[i]=i;}
        return  a;
    }
}
