package leetcode.editor.cn.greedy;

import java.util.Arrays;
import java.util.List;

/**
 * 题目描述
 * 一群孩子站成一排，每一个孩子有自己的评分。现在需要给这些孩子发糖果，规则是如果一
 * 个孩子的评分比自己身旁的一个孩子要高，那么这个孩子就必须得到比身旁孩子更多的糖果；所
 * 有孩子至少要有一个糖果。求解最少需要多少个糖果。
 *
 * 输入输出样例
 * 输入是一个数组，表示孩子的评分。输出是最少糖果的数量
 *
 * Input: [1,0,2]
 * Output: 5
 *
 *
 * 题解
 * 做完了题目 455，你会不会认为存在比较关系的贪心策略一定需要排序或是选择？虽然这一
 * 道题也是运用贪心策略，但我们只需要简单的两次遍历即可：把所有孩子的糖果数初始化为 1；
 * 先从左往右遍历一遍，如果右边孩子的评分比左边的高，则右边孩子的糖果数更新为左边孩子的
 * 糖果数加 1；再从右往左遍历一遍，如果左边孩子的评分比右边的高，且左边孩子当前的糖果数
 * 不大于右边孩子的糖果数，则左边孩子的糖果数更新为右边孩子的糖果数加 1。通过这两次遍历，
 * 分配的糖果就可以满足题目要求了。这里的贪心策略即为，在每次遍历中，只考虑并更新相邻一
 * 侧的大小关系。
 * 在样例中，我们初始化糖果分配为 [1,1,1]，第一次遍历更新后的结果为 [1,1,2]，第二次遍历
 * 更新后的结果为 [2,1,2]。
 */
public class Candy {

    public static void main(String[] args) {
        int []children = new int[]{1,2,0,5,7};

        int []numArr = new int[children.length];

        for (int i = 0; i < children.length; i++) {
            numArr[i] = 1;
        }

        for (int i = 0; i < children.length-1; i++) {
            if(children[i+1]>children[i]){
                numArr[i+1] = numArr[i] + 1;
            }
        }

        for (int i = children.length-1; i > 0; i--) {
            //左边的评分大于右边孩子的评分，且左边的孩子糖果数量不大于右边的孩子数量，则左边的孩子糖果数量为右边孩子的糖果数量+1
            if(children[i-1]>children[i] && numArr[i-1] <= numArr[i]){
                numArr[i-1] = numArr[i] + 1;
            }
        }

        System.out.println(Arrays.toString(numArr));
        System.out.println("最少糖果的数量:"+Arrays.stream(numArr).sum());
    }

}
