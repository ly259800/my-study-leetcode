package leetcode.editor.cn.greedy;

/**
 * 题目描述
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，能否在不打破种植规则的情况下种入朵花？能则返回 true ，不能则返回 false。
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *
 * 题解
 * 计算出能够种出最多花的数量
 * 统计1和1之间0的个数，若个数为奇数，则能够种花的数量为(n-1)/2,若0的个数为偶数，则能够种花的数量为(n-2)/2
 *
 */
public class Flowers {

    public static void main(String[] args) {
        int[] arr = new int[]{0,0};
        int max = 0;
        if(arr[0]==0 && arr[1] == 0){
            arr[0] = 1;
            max ++;
        }
        if(arr[arr.length-1]==0 && arr[arr.length-2] == 0){
            arr[arr.length-1] = 1;
            max ++;
        }
        int zeroNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                if(zeroNum > 0){
                    if(zeroNum/2 == 0){
                        max+=(zeroNum-2)/2;
                    } else {
                        max+=(zeroNum-1)/2;
                    }
                }
                zeroNum = 0;//重置
            } else {
                //计算0出现的次数
                zeroNum ++;
            }
        }
        System.out.println("剩余能够种最多花的数量为："+max);

    }



}
