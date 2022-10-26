package leetcode.editor.cn.greedy;

import java.util.Arrays;

/**
 * 题目描述
 * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃
 * 最多一个饼干，且只有饼干的大小大于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩
 * 子可以吃饱。
 *
 * 输入输出样例
 * 输入两个数组，分别代表孩子的饥饿度和饼干的大小。输出最多有多少孩子可以吃饱的数
 * 量
 *
 * Input: [1,2], [1,2,3]
 * Output: 2
 *
 *
 * 题解
 * 因为饥饿度最小的孩子最容易吃饱，所以我们先考虑这个孩子。为了尽量使得剩下的饼干可
 * 以满足饥饿度更大的孩子，所以我们应该把大于等于这个孩子饥饿度的、且大小最小的饼干给这
 * 个孩子。满足了这个孩子之后，我们采取同样的策略，考虑剩下孩子里饥饿度最小的孩子，直到
 * 没有满足条件的饼干存在。
 *
 */

public class AssignCookies {

    public static void main(String[] args) {
        int[] children = new int[]{2, 2, 1, 3, 4};
        int[] cookies = new int[]{1, 3, 2, 2, 2};
        Arrays.sort(children);
        Arrays.sort(cookies);
        int child = 0;
        int cookie = 0;
        while (child < children.length && cookie < cookies.length) {
            if (children[child] <= cookies[cookie]) ++child;
            ++cookie;
        }
        System.out.println("可以吃饱的孩子数量：" + child);
    }

}
