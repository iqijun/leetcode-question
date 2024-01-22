package com.fullstacker.leetcode.editor.cn.match;

import java.util.*;

/**
 * @program: leetcode-question
 * @description:
 * @author: xingguishuai
 * @create: 2023-08-20 11:16
 */
public class LongestEqualSubarray {

    public static int longestEqualSubarray(List<Integer> nums,int k){
        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < nums.size(); right++) {
            freq.put(nums.get(right), freq.getOrDefault(nums.get(right), 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(nums.get(right)));

            if (right - left -maxFreq  > k) {
                freq.put(nums.get(left), freq.get(nums.get(left)) - 1);
                left++;
            }
            if(right == left){
                maxLen = 1;
            }else{

            maxLen = Math.max(maxLen, right - left + 1 -k);
            }
        }

        return maxLen;

    }


        public static int longestEqualSubarray(int[] nums, int k) {
            int n = nums.length;
            int[][] dp = new int[n][n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int j = i;
                while (j < n && nums[j] == nums[i]) {
                    dp[i][j] = dp[i][j-1] + 1;
                    if (j - i + 1 - dp[i][j] > k) {
                        break;
                    }
                    j++;
                }
                ans = Math.max(ans, j-i);
            }
            return ans;
        }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1);
        int i = longestEqualSubarray(nums, 1);
        System.out.println(i);

//        int i1 = longestEqualSubarray(new int[]{1, 1, 2, 2, 1, 1}, 2);
//
//        System.out.println(i1);

    }
}
