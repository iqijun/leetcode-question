//给你两个下标从 0 开始的数组 nums1 和 nums2 ，和一个二维数组 queries 表示一些操作。总共有 3 种类型的操作： 
//
// 
// 操作类型 1 为 queries[i] = [1, l, r] 。你需要将 nums1 从下标 l 到下标 r 的所有 0 反转成 1 或将 1 反转成 
//0 。l 和 r 下标都从 0 开始。 
// 操作类型 2 为 queries[i] = [2, p, 0] 。对于 0 <= i < n 中的所有下标，令 nums2[i] = nums2[i] +
// nums1[i] * p 。 
// 操作类型 3 为 queries[i] = [3, 0, 0] 。求 nums2 中所有元素的和。 
// 
//
// 请你返回一个数组，包含所有第三种操作类型的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,0,1], nums2 = [0,0,0], queries = [[1,1,1],[2,1,0],[3,0,0]]
//输出：[3]
//解释：第一个操作后 nums1 变为 [1,1,1] 。第二个操作后，nums2 变成 [1,1,1] ，所以第三个操作的答案为 3 。所以返回 [3] 。
//
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], nums2 = [5], queries = [[2,0,0],[3,0,0]]
//输出：[5]
//解释：第一个操作后，nums2 保持不变为 [5] ，所以第二个操作的答案是 5 。所以返回 [5] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length,nums2.length <= 10⁵ 
// nums1.length = nums2.length 
// 1 <= queries.length <= 10⁵ 
// queries[i].length = 3 
// 0 <= l <= r <= nums1.length - 1 
// 0 <= p <= 10⁶ 
// 0 <= nums1[i] <= 1 
// 0 <= nums2[i] <= 10⁹ 
// 
//
// Related Topics 线段树 数组 👍 59 👎 0


package com.fullstacker.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * @author 骐骏 2023-07-26 16:34:23
 */
public class HandlingSumQueriesAfterUpdate {
    
    public static void main(String[] args) {
               Solution solution = new HandlingSumQueriesAfterUpdate().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
            public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
                int n = nums1.length;
                long sum = 0;
                BitSet bitSet = new BitSet(n);
                for (int i = 0; i < n; ++i) {
                    sum += nums2[i];
                    if (nums1[i] == 1) bitSet.set(i);
                }
                List<Long> ans = new ArrayList<>();
                for (int[] q : queries) {
                    if (q[0] == 1) {
                        // 反转 [l, r]
                        bitSet.flip(q[1], q[2] + 1);
                    } else if (q[0] == 2) {
                        // 1的总个数 * p
                        sum += (long) bitSet.cardinality() * q[1];
                    } else {
                        ans.add(sum);
                    }
                }
                return ans.stream().mapToLong(Long::longValue).toArray();
            }
        
        public long[] handleQueryBack(int[] nums1, int[] nums2, int[][] queries) {
            long[] result = new long[queries.length];
            int resultIndex = 0;
            boolean longNums2Flag = false;
            long[] longNums2 = new long[nums2.length];
            for (int[] query : queries) {
                if (query[0] == 1) {
                    nums1 = handleType1(nums1, query);
                } else if (query[0] == 2) {
                    if (longNums2Flag) {
                        longNums2 = handleType2ForLong(nums1, longNums2, query);
                    } else {
                        longNums2 = handleType2(nums1, nums2, query);
                        longNums2Flag = true;
                    }
                }
                if (query[0] == 3) {
                    if (longNums2Flag) {
                        result[resultIndex++] = handleType3ForLong(longNums2);
                    } else {
                        result[resultIndex++] = handleType3(nums2);
                    }
                }
            }
            return Arrays.copyOf(result, resultIndex);
            
        }
        
        private int[] handleType1(int[] nums1, int[] queries1) {
            for (int i = queries1[1]; i <= queries1[2]; i++) {
                if (nums1[i] == 0) {
                    nums1[i] = 1;
                } else if (nums1[i] == 1) {
                    nums1[i] = 0;
                }
            }
            return nums1;
        }
        
        private long[] handleType2(int[] nums1, int[] nums2, int[] queries2) {
            long[] result = new long[nums2.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = nums2[i] + nums1[i] * (long) queries2[1];
            }
            return result;
        }
        
        private long[] handleType2ForLong(int[] nums1, long[] nums2, int[] queries2) {
            long[] result = new long[nums2.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = nums2[i] + (long) nums1[i] * queries2[1];
            }
            return result;
        }
        
        private Long handleType3(int[] nums2) {
            long result = 0L;
            for (int i = 0; i < nums2.length; i++) {
                result = result + nums2[i];
            }
            return result;
        }
        private Long handleType3ForLong(long[] nums2) {
            long result = 0L;
            for (int i = 0; i < nums2.length; i++) {
                result = result + nums2[i];
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    
}
