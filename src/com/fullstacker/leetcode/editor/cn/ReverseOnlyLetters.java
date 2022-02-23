//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 👍 131 👎 0


package com.fullstacker.leetcode.editor.cn;


import java.util.Arrays;

/**
 * @author 骐骏
 * 2022-02-23 11:16:43  
 */
public class ReverseOnlyLetters{
  public static void main(String[] args) {
       Solution solution = new ReverseOnlyLetters().new Solution();

       String abc = "$1:V<&NyJ";
      abc= solution.reverseOnlyLetters(abc);

      System.out.printf(abc);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String s) {

        int length = s.length() ;
        char[] chars = s.toCharArray();


        int fix = s.length() - 1;
        for (int i = 0; i < length; i++) {

            if( i > length){
                return String.valueOf(chars);
            }
            if(!Character.isLetter(chars[i])){
                continue;
            }
            while (fix >= i) {

                if( fix < i){
                    return String.valueOf(chars);
                }
                if(!Character.isLetter(chars[fix])){
                    fix--;
                    continue;
                }
                char tmp = chars[i];
                chars[i] = chars[fix];
                chars[fix] = tmp;
                fix--;
                break;
            }
        }

        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
