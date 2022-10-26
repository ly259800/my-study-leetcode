package leetcode.editor.cn.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。
 * 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 *
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 *
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 *
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 *[[-2147483646,-2147483645],[2147483646,2147483647]]
 */
public class Balloons {
    public static void main(String[] args) {
        int [][] arr = new int[4][2];
        arr[0] = new int[]{10,16};
        arr[1] = new int[]{2,8};
        arr[2] = new int[]{1,6};
        arr[3] = new int[]{7,12};
        //将区间按照开始的大小进行增序排序
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int [][] sortArrList = arr;
        int end = sortArrList[0][1];
        int num = 1;//第一个气球
        for (int i = 1; i < sortArrList.length; i++) {
            //若2个区间不相交，则射箭数+1
            if(sortArrList[i-1][0] != sortArrList[i][0] && end < sortArrList[i][0]){
                 num ++;
                 end = sortArrList[i][1];
            }
            //若相交，则取最小的区间为最后的大小
            if(sortArrList[i][1] < end ){
                end = sortArrList[i][1];
            }
        }
        System.out.println("射出的最小弓箭数为："+num);

    }
}
