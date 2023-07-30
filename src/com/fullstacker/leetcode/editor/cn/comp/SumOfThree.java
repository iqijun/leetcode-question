package com.fullstacker.leetcode.editor.cn.comp;

/**
 * @program: leetcode-question
 * @description:
 * @author: xgs
 * @create: 2022-02-19 23:01
 */
public class SumOfThree {

    public static long[] sumOfThree(long num) {
        long[] result = {};
        long l = num / 3l;

        if(num % 3 == 0){
            long mid = num / 3l;
            result = new long[]{mid - 1l, mid, mid + 1};
            return result;
        }
        return result;
    }

    public static void main(String[] args) {
        long[] longs = sumOfThree(33l);
        System.out.println(longs);
    }
}
