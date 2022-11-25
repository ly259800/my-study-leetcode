package leetcode.editor.cn.thread.output;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用2个线程，1个输出字母，1个输出数字，交替输出1A2B3C4D...26Z
 */

public class LockConditionRealize extends Thread{
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
        int[] intArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        t1 = new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < intArr.length; i++) {
                    System.out.print(intArr[i]);
                    condition.signal();
                    condition.await();//让出锁
                }
                condition.signal();//必须，否则程序不结束
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });

        t2 = new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < str.length(); i++) {
                    System.out.print(str.charAt(i));
                    condition.signal();
                    condition.await();//让出锁
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();

    }
}
