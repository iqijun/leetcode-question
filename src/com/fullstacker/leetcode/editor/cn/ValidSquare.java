//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。 
//
// 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。 
//
// 一个 有效的正方形 有四条等边和四个等角(90度角)。 
//
// 
//
// 示例 1: 
//
// 
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
// 
//
// 示例 2: 
//
// 
//输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//输出：false
// 
//
// 示例 3: 
//
// 
//输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//输出：true
// 
//
// 
//
// 提示: 
//
// 
// p1.length == p2.length == p3.length == p4.length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 
// Related Topics 几何 数学 👍 145 👎 0


package com.fullstacker.leetcode.editor.cn;
/**
 * @author 骐骏
 * 2022-07-29 18:01:03  
 */
public class ValidSquare{
  public static void main(String[] args) {
       Solution solution = new ValidSquare().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
      long len = -1;
      public boolean validSquare(int[] a, int[] b, int[] c, int[] d) {
          return calc(a, b, c) && calc(a, b, d) && calc(a, c, d) && calc(b, c, d);
      }
      boolean calc(int[] a, int[] b, int[] c) {
          long l1 = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
          long l2 = (a[0] - c[0]) * (a[0] - c[0]) + (a[1] - c[1]) * (a[1] - c[1]);
          long l3 = (b[0] - c[0]) * (b[0] - c[0]) + (b[1] - c[1]) * (b[1] - c[1]);
          boolean ok = (l1 == l2 && l1 + l2 == l3) || (l1 == l3 && l1 + l3 == l2) || (l2 == l3 && l2 + l3 == l1);
          if (!ok) return false;
          if (len == -1) len = Math.min(l1, l2);
          else if (len == 0 || len != Math.min(l1, l2)) return false;
          return true;
      }
  }


}
