package leetcode.editor.cn.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 题目描述
 * 给定多个区间，计算让这些区间互不重叠所需要移除区间的最少个数。起止相连不算重叠。
 *
 * 输入输出样例
 * 输入是一个数组，数组由多个长度固定为 2 的数组组成，表示区间的开始和结尾。输出一个
 * 整数，表示需要移除的区间数量。
 *
 * Input: [[1,2], [2,4], [1,3]]
 * Output: 1
 * 在这个样例中，我们可以移除区间 [1,3]，使得剩余的区间 [[1,2], [2,4]] 互不重叠
 *
 *
 * 题解
 * 在选择要保留区间时，区间的结尾十分重要：选择的区间结尾越小，余留给其它区间的空间
 * 就越大，就越能保留更多的区间。因此，我们采取的贪心策略为，优先保留结尾小且不相交的区
 * 间。
 * 具体实现方法为，先把区间按照结尾的大小进行增序排序，每次选择结尾最小且和前一个选
 * 择的区间不重叠的区间。我们这里使用 C++ 的 Lambda，结合 std::sort() 函数进行自定义排
 * 序。
 * 在样例中，排序后的数组为 [[1,2], [1,3], [2,4]]。按照我们的贪心策略，首先初始化为区间
 * [1,2]；由于 [1,3] 与 [1,2] 相交，我们跳过该区间；由于 [2,4] 与 [1,2] 不相交，我们将其保留。因
 * 此最终保留的区间为 [[1,2], [2,4]]。
 */
public class Interval {
    public static void main(String[] args) {
        int[][] arrList = new int[3][2];
        int[] arr1 = new int[]{1, 2};
        int[] arr2 = new int[]{2, 4};
        int[] arr3 = new int[]{1, 3};
        arrList[0] = arr1;
        arrList[1] = arr2;
        arrList[2] = arr3;
        //System.out.println(Arrays.deepToString(arrList));
        //将区间按照结尾的大小进行增序排序
        int[][] sortArrList = Arrays.stream(arrList).sorted(Comparator.comparing(s -> s[1])).toArray(int[][]::new);
        System.out.println(Arrays.deepToString(sortArrList));

        /*int removeNum = interval(sortArrList);
        System.out.println("需要移除的区间数量:"+removeNum);*/

        List<int[]> finaArrList = new ArrayList<>();
        finaArrList.add(sortArrList[0]);
        //需要越过的区间下标进行比较
        int removeIndex = 0;
        int pre = sortArrList[0][1];
        for (int i = 1; i < sortArrList.length; i++) {
            //若2个区间相交，则跳过该区间
            if (sortArrList[i][0] < pre) {
                removeIndex++;
            } else {
                finaArrList.add(sortArrList[i]);
                pre = sortArrList[i][1];
            }
        }
        int[][] lastArr = finaArrList.stream().toArray(int[][]::new);
        System.out.println(Arrays.deepToString(lastArr));
        System.out.println("需要移除的区间数量:" + removeIndex);
    }

    /**
     * 计算出排序后的区间需要移除的区间数量
     * @param intervals
     * @return
     */
    public static int interval(int [][] intervals) {
        int n = intervals.length;
        int total = 0, prev = intervals[0][1];
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] < prev) {
                ++total;
            } else {
                prev = intervals[i][1];
            }
        }
        return total;
    }

}
