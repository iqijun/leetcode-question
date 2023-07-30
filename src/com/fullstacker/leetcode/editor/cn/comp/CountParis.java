package com.fullstacker.leetcode.editor.cn.comp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode-question
 * @description:
 * @author: xgs
 * @create: 2022-02-19 22:39
 */
public class CountParis {

    public static int countPairs(int[] nums, int k) {
        long[] longs = {};
        HashMap<Integer, List<Integer>> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> integers = numsMap.get(nums[i]);
            if (integers == null) {
                integers = new ArrayList<>();
                numsMap.put(nums[i],integers);
            }
            integers.add(i);
        }
        int result = 0;
        Set<Integer> keySet = numsMap.keySet();
        for (Integer key : keySet) {
            List<Integer> integers = numsMap.get(key);
            if(integers.size() == 2){
                if(integers.get(0)*integers.get(1) % k == 0){
                    result++;
                    continue;
                }
            }
            if(integers.size()>2){
                for (int i = 0; i < integers.size(); i++) {
                    for (int j = i+1; j < integers.size(); j++) {
                        if(integers.get(i) * integers.get(j) % k == 0 ){
                            result ++;
                        }
                    }
                }
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,2,2,1,3};
                int k = 2;
        int count = countPairs(nums, 2);
        System.out.println(count);
    }
}
