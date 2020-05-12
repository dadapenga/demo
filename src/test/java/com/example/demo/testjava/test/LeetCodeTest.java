package com.example.demo.testjava.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCodeTest {
    public static void main(String[] args) {

    }

}


//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。你可以假设除了整数 0 之外，这个整数不会以零开头。

class PlusOne{
    public int[] plusOne(int[] digits){
        for(int i = digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i] = digits[i]%10;
            if(digits[i]!=0) return digits;
        }
        digits = new int[digits.length+1];
        digits[0]=1;
        return  digits;
    }
}





//   假设你正在爬楼梯。需要 n 阶你才能到达楼顶。  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？   斐波那锲数列
//   到达第五层只能从第四层或第三层走 f(5)=f(4)+f(3)，n=1有一种方法，n=2有两种 用map数据缓存
//    Solution solution =  new Solution() ;
//    int t = solution.climbStairs(5);
//        System.out.println("最后结果"+Integer.toString(t));
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int climbStairs(int n){
        return  climb_Stairs( n);
    }

    public int climb_Stairs( int n) {
        System.out.println(n);
        if (n==1) {
            map.put(1,1);
            return 1;
        }
        if (n==2) {
            map.put(2,2);
            return 2;
        }
        if(map.get(n)!=null){
            return map.get(n);
        }else {
            int result = climb_Stairs( n-1) + climb_Stairs( n-2);
            map.put(n,result);
            return result;
        }
    }

}
