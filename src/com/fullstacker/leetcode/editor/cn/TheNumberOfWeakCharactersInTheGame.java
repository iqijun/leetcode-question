//你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [
//attacki, defensei] 表示游戏中第 i 个角色的属性。 
//
// 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j
// ，那么 attackj > attacki 且 defensej > defensei 。 
//
// 返回 弱角色 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：properties = [[5,5],[6,3],[3,6]]
//输出：0
//解释：不存在攻击和防御都严格高于其他角色的角色。
// 
//
// 示例 2： 
//
// 
//输入：properties = [[2,2],[3,3]]
//输出：1
//解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
// 
//
// 示例 3： 
//
// 
//输入：properties = [[1,5],[10,4],[4,3]]
//输出：1
//解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= properties.length <= 105 
// properties[i].length == 2 
// 1 <= attacki, defensei <= 105 
// 
// Related Topics 栈 贪心 数组 排序 单调栈 
// 👍 86 👎 0


package com.fullstacker.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author 骐骏
 * 2022-01-28 14:37:15  
 */
public class TheNumberOfWeakCharactersInTheGame{
  public static void main(String[] args) {
       Solution solution = new TheNumberOfWeakCharactersInTheGame().new Solution();
       int[][] prop = new int[][]{{5,5},{6,3},{3,6},{4,2},{6,4}};
      solution.numberOfWeakCharacters(prop);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int numberOfWeakCharacters(int[][] properties) {

          Arrays.sort(properties,(a,b)->{return  a[0]-b[0] == 0 ?  b[1] - a[1]  : b[0] - a[0];});
          int defenseiMax = properties[0][1];
          int count = 0;
          for (int[] role : properties){
              if(defenseiMax > role[1]){
                  count++;
              }else{
                  defenseiMax = role[1];
              }
          }

          return count;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}
