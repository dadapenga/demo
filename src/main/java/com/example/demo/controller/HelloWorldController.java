package com.example.demo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController注解能够使项目支持Rest
@RestController
@SpringBootApplication
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/testlp")
public class HelloWorldController {
    int  i=0;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(@RequestParam(value = "userName") String userName) {
        System.out.println("2");
//        i++;
        return "hello" +userName ;
    }

    @RequestMapping("/tell")
    public  int[] index1(){
        int[] a = new int[10];
        for(;i<10;i++){a[i]=i;}
        return  a;
    }
}
