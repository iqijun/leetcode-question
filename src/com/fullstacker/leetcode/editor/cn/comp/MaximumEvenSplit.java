package com.fullstacker.leetcode.editor.cn.comp;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-question
 * @description:
 * @author: xgs
 * @create: 2022-02-19 23:14
 */
public class MaximumEvenSplit {

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> reslut = new ArrayList<>();
        if(finalSum % 2 != 0 || finalSum == 2 || finalSum == 4){
            return  reslut;
        }
        if(finalSum == 6){
            return reslut;
        }
        return reslut;
    }
}
