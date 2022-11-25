package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * 选择排序：
 * 0~N-1之间选择最小的，将最小值和下标为0的数据交换
 * 1~N-1之间选择最小的，将最小值和下标为1的数据交换
 * .....
 * N-2~N-1之间选择最小的，将最小值和下标为N-2的数据交换
 * 时间复杂度为O(n的平方)
 */
public class SelectSort {

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = new int[]{5,2,5,2,6,4,7,3};
        int[] sort = selectSort.sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    public int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //将最小值和下标为i的数据交换
            swap(arr,i,minIndex);
        }
        return arr;
    }

    public void swap(int[] arr,int i,int minIndex){
        int t = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = t;
    }


}
