//给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法： 
//
// 
// 添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。 
// 给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。 
// 
//
// 轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。 
//
// 实现 DetectSquares 类： 
//
// 
// DetectSquares() 使用空数据结构初始化对象 
// void add(int[] point) 向数据结构添加一个新的点 point = [x, y] 
// int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
//[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 1
//0]]]
//输出：
//[null, null, null, null, 1, 0, null, 2]
//
//解释：
//DetectSquares detectSquares = new DetectSquares();
//detectSquares.add([3, 10]);
//detectSquares.add([11, 2]);
//detectSquares.add([3, 2]);
//detectSquares.count([11, 10]); // 返回 1 。你可以选择：
//                               //   - 第一个，第二个，和第三个点
//detectSquares.count([14, 8]);  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
//detectSquares.add([11, 2]);    // 允许添加重复的点。
//detectSquares.count([11, 10]); // 返回 2 。你可以选择：
//                               //   - 第一个，第二个，和第三个点
//                               //   - 第一个，第三个，和第四个点
// 
//
// 
//
// 提示： 
//
// 
// point.length == 2 
// 0 <= x, y <= 1000 
// 调用 add 和 count 的 总次数 最多为 5000 
// 
// Related Topics 设计 数组 哈希表 计数 
// 👍 35 👎 0


package com.fullstacker.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 骐骏
 * 2022-01-26 10:39:21  
 */
public class DetectSquaresPublic{
  public static void main(String[] args) {

//      ["DetectSquares","add","add","add","count","count","add","count"]
//      [[],[[3,10]],[[11,2]],[[3,2]],[[11,10]],[[14,8]],[[11,2]],[[11,10]]]
      DetectSquares detectSquares = new DetectSquares();

      detectSquares.add(new int[]{3,10});
      detectSquares.add(new int[]{11,2});
      detectSquares.add(new int[]{3,2});
      int count = detectSquares.count(new int[]{11, 10});
      System.out.println(count);

  }
  //leetcode submit region begin(Prohibit modification and deletion)
static class DetectSquares {

    private Map<Integer, List<int[]>> xPonitsMap;

    private Map<Integer, List<int[]>> yPonitsMap;

    public DetectSquares() {
        xPonitsMap = new HashMap<>();
        yPonitsMap = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        List<int[]> xPoints = xPonitsMap.get(x);
        if(null == xPoints){
            xPoints = new ArrayList<>();
        }
        xPoints.add(point);
        xPonitsMap.put(x, xPoints);

        List<int[]> yPoints = yPonitsMap.get(y);
        if(null == yPoints){
            yPoints = new ArrayList<>();
        }
        yPoints.add(point);
        yPonitsMap.put(y, yPoints);
    }
    
    public int count(int[] point) {
        int result = 0;
        int x = point[0];
        int y = point[1];
        List<int[]> xEqualPoints = xPonitsMap.get(x);
        List<int[]> yEqualPonits = yPonitsMap.get(y);
        if( xEqualPoints == null || yEqualPonits == null){
            return  result;
        }

        for (int[] xEqualPonit : xEqualPoints) {
            int targetY = xEqualPonit[1];
            for (int[] yEqualPonit : yEqualPonits) {
                int targetX = yEqualPonit[0];// 去判断（targetX,targetY）存不存在
                // 如果 targetX-x = targetY-Y 说明是正方形
                if(Math.abs(targetX - x )!= Math.abs(targetY - y)){
                    continue;
                }
                List<int[]> needXPoints = xPonitsMap.get(targetX);
                if(null != needXPoints && needXPoints.size() > 0){
                    for (int[] needXPoint : needXPoints) {
                        if(needXPoint[1] == targetY ){ //
                            result++;
                        }
                    }
                }
            }

        }
        return result;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
