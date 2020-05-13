package com.example.demo.testjava.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class LeetCodeTest {
    public static void main(String[] args) {
        Solution solution  = new Solution();
        int times = solution.uniquePaths(7,3);
        System.out.println(times);

    }

}


//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。你可以假设除了整数 0 之外，这个整数不会以零开头。

/**一般情况直接进行最后一位加一，特殊情况需要考虑到9+1需要进位，所以从最后一位开始循环整个数组进行加一，当前数等于对10取余，取余不为0的直接该返回数组，
 *对于取余为0的进行数组循环加一，对一直未返回的数据判断为 999类型  返回一个长度为length+1，开头为1的新数组
 */
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


class Solution {

//   假设你正在爬楼梯。需要 n 阶你才能到达楼顶。  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？   斐波那锲数列
//   到达第五层只能从第四层或第三层走 f(5)=f(4)+f(3)，n=1有一种方法，n=2有两种 用map数据缓存,已经计算过的数据不用重复计算
//    Solution solution =  new Solution() ;
//    int t = solution.climbStairs(5);
//        System.out.println("最后结果"+Integer.toString(t));
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


//    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//    现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//    输入:
//            [
//            [0,0,0],
//            [0,1,0],
//            [0,0,0]
//            ]
//    输出: 2
//  -------------------------------

/** 思路：第一个点如果是1，则没有路，否则进行动态规划，只能往右和往下，表格中的节点到达的路线条数等于左边和上面的两个数之和   [i][j]=[i-1][j]+[i][j-1]
 *不为0 的情况下先进行第一列和第一行的遍历，[0][0]=1且设置出第一行和第一列的初始数字，存在阻碍的以及阻碍之后的是0，不存在阻碍的及之前也不存在阻碍的为0
 *然后从[1][1]开始进行遍历二维数组，[i][j]=[i-1][j]+[i][j-1]，最后的[i-1][j-1]就是最后的路线条数
 * **/


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int hight = obstacleGrid.length;
        int weight = obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1) return 0;
        obstacleGrid[0][0]=1;
        //第一行
        for (int i = 1;i<weight;i++){
            obstacleGrid[0][i] =(obstacleGrid[0][i]==0&&obstacleGrid[0][i-1]==1)?1:0;
        }
        //第一列
        for (int i = 1;i<hight ;i++){
            obstacleGrid[i][0]= (obstacleGrid[i][0]==0&&obstacleGrid[i-1][0]==1)?1:0;
        }

        for (int i =1;i<weight;i++){
            for (int j =1;j<hight;j++){
                if (obstacleGrid[i][j]==0){
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
                else {
                    obstacleGrid[i][j]=0;
                }
            }
        }
        return obstacleGrid[weight-1][hight-1];
    }
//没有设置障碍物的机路线条数
    public int uniquePaths(int m, int n) {
        int[][] solu = new int[m][n];
        if (m==1||n==1) return 1;
        for (int i=0;i<n;i++) solu[0][i]=1;
        for (int i=0;i<m;i++) solu[i][0]=1;
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                solu[i][j] = solu[i-1][j]+solu[i][j-1];
            }
        }
        //二维数组打印deepToString
        System.out.println(Arrays.deepToString(solu) );
        return solu[m-1][n-1];
    }




}
