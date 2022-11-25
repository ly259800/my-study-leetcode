package leetcode.editor.cn.thread.outputABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程交替输出ABC
 */

public class LockConditionDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        //存放A的队列
        Condition conditionA = lock.newCondition();
        //存放B的队列
        Condition conditionB = lock.newCondition();
        //存放C的队列
        Condition conditionC = lock.newCondition();
        new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print("A");
                    conditionB.signal();//唤醒B
                    conditionA.await();//A线程等待
                }
                conditionB.signal();//唤醒B
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print("B");
                    conditionC.signal();//唤醒C
                    conditionB.await();//B线程等待
                }
                conditionC.signal();//唤醒C
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print("C");
                    conditionA.signal();//唤醒A
                    conditionC.await();//C线程等待
                }
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }

}
