package com.fullstacker.leetcode.editor.cn.match;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: leetcode-question
 * @description:
 * @author: xingguishuai
 * @create: 2023-08-20 10:37
 */
public class Acronym {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("an");
        words.add("bas");
        boolean ab = isAcronym(words, "ab");
        System.out.println(ab);

    }

    public static boolean isAcronym(List<String> words,String s){
        String collect = words.stream().map(word -> word.substring(0, 1)).collect(Collectors.joining());
        return s.equals(collect);
    }
}
