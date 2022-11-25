package leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 下标为0和1的数据进行比较，若arr[0]>arr[1],进行交换,然后1和2进行比较，重复
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[]{5,2,5,2,6,4,7,3};
        bubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public void swap(int[] arr,int i,int minIndex){
        int t = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = t;
    }

}
