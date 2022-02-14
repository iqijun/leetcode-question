//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。 
//
// 请你找出并返回只出现一次的那个数。 
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 373 👎 0


package com.fullstacker.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author 骐骏
 * 2022-02-14 10:56:40  
 */
public class SingleElementInASortedArray{
  public static void main(String[] args) {
       Solution solution = new SingleElementInASortedArray().new Solution();
       int[] nums = new int[]{1,2,2,3,3};
      int result = solution.singleNonDuplicate(nums);
      System.out.println(result);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int singleNonDuplicate(int[] nums) {
          int length = nums.length;
          if(length == 1){
              return nums[0];
          }
          int index = length/2;
          if(nums[index] != nums[index + 1] && nums[index -1] != nums[index]) {
              return nums[index];
          }
          if(index % 2 == 0){
//              index是偶数并且和他后面的一个数相等，说明唯一元素在index的前面
              int[] newArray;
              if(nums[index] == nums[index + 1]){
                  // 说明唯一元素在inde的后面
                  newArray = Arrays.copyOfRange(nums, index + 2, nums.length);
              }else{
                  newArray = Arrays.copyOfRange(nums, 0, index - 1);
              }
              return singleNonDuplicate(newArray);
          }else{
              // index为奇数的时候，如果和后面的数相等，说明唯一元素在index的后面
              int[] newArray;
              if(nums[index] == nums[index + 1]){
                  // 说明唯一元素在inde的后面
                  newArray = Arrays.copyOfRange(nums, 0, index);
              }else{
                  newArray = Arrays.copyOfRange(nums, index + 1, nums.length);
              }
              return singleNonDuplicate(newArray);

          }





      }

      // 世间复杂度是O(n)
//    public int singleNonDuplicate(int[] nums) {
//
//        int result = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            result = nums[i]^result;
//        }
//        return  result;
//
//    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
