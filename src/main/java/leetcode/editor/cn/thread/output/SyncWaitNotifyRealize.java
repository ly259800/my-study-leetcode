package leetcode.editor.cn.thread.output;

/**
 * 用2个线程，1个输出字母，1个输出数字，交替输出1A2B3C4D...26Z
 */

public class SyncWaitNotifyRealize extends Thread{
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
        int[] intArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Object o = new Object();
        t1 = new Thread(()->{

                synchronized (o) {
                    for (int i = 0; i < intArr.length; i++) {
                        System.out.print(intArr[i]);
                        try {
                            o.notify();
                            o.wait();//让出锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify();//必须，否则程序不结束
                }


        });

        t2 = new Thread(()->{

                synchronized (o){
                    for (int i = 0; i < str.length(); i++) {
                        System.out.print(str.charAt(i));
                        try {
                            o.notify();
                            o.wait();//让出锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify();
                }

        });

        t1.start();
        t2.start();

    }
}
