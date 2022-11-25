package leetcode.editor.cn.thread.output;

import java.util.concurrent.locks.LockSupport;

/**
 * 用2个线程，1个输出字母，1个输出数字，交替输出1A2B3C4D...26Z
 */

public class LockSupportRealize{
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
        int[] intArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < intArr.length; i++) {
                    System.out.print(intArr[i]);
                    LockSupport.unpark(t2);//唤醒线程2
                    LockSupport.park();//阻塞当前线程
                }
            }
        });
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < str.length(); i++) {
                    LockSupport.park();//阻塞当前线程
                    System.out.print(str.charAt(i));
                    LockSupport.unpark(t1);//唤醒线程1
                }
            }
        });
        t1.start();
        t2.start();
    }



}
