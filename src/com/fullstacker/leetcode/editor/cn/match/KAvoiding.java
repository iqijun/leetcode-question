package com.fullstacker.leetcode.editor.cn.match;

/**
 * @program: leetcode-question
 * @description:
 * @author: xingguishuai
 * @create: 2023-08-20 10:53
 */
public class KAvoiding {


    public static void main(String[] args) {
        int n1 = 5, k1 = 4;
        System.out.println(miniSum(n1, k1));  // 输出 18

        int n2 = 2, k2 = 6;
        System.out.println(miniSum(n2, k2));  // 输出 3
    }
    public static  int miniSum(int n,int k){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = k - i;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        return sum;
    }
}
