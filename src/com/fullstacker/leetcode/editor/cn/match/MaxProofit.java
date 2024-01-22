package com.fullstacker.leetcode.editor.cn.match;

import java.util.Arrays;

/**
 * @program: leetcode-question
 * @description:
 * @author: xingguishuai
 * @create: 2023-08-20 11:05
 */
public class MaxProofit {


        public static int maxCoins(int n, int[][] offers) {
            // 按照 offers 的 endi 进行升序排序
            Arrays.sort(offers, (a, b) -> a[1] - b[1]);

            int[] dp = new int[n];
            int[] overlap = new int[n];
            Arrays.fill(overlap, -1);
            dp[0] = offers[0][2];

            for (int i = 1; i < offers.length; i++) {
                // 不选择 offers[i] 的房屋进行出售
                dp[i] = dp[i-1];

                // 选择 offers[i] 的房屋进行出售
                int start = offers[i][0];
                int gold = offers[i][2];

                // 查找与 offers[i] 重叠的之前的 offers
                for (int j = i-1; j >= 0; j--) {
                    if (offers[j][1] >= start) {
                        overlap[i] = j;
                        break;
                    }
                }

                if (overlap[i] != -1) {
                    dp[i] = Math.max(dp[i], dp[overlap[i]] + gold);
                } else if (start == 0) {
                    dp[i] = Math.max(dp[i], gold);
                }
            }

            return dp[n-1];
        }

        public static void main(String[] args) {
            int n1 = 5;
            int[][] offers1 = {{0, 0, 1}, {0, 2, 2}, {1, 3, 2}};
            System.out.println(maxCoins(n1, offers1));  // 输出 3

            int n2 = 5;
            int[][] offers2 = {{0, 0, 1}, {0, 2, 10}, {1, 3, 2}};
            System.out.println(maxCoins(n2, offers2));  // 输出 10
        }

    public static int maxProfit(int n, int[][] offers) {
        // 按照结束位置对购买要约进行排序
        Arrays.sort(offers, (a, b) -> a[1] - b[1]);
        int max_profit = 0;
        for (int i = 0; i < n; i++) {
            // 如果当前购买要约的开始位置大于等于上一个购买要约的结束位置
            if (offers[i][0] >= max_profit) {
                // 那么就更新最大金币收入
                max_profit = offers[i][2];
            }
        }
        return max_profit;
    }

}
