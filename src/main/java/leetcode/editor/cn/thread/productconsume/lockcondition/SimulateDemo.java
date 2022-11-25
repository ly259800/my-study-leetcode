package leetcode.editor.cn.thread.productconsume.lockcondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimulateDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        //生产者队列
        Condition productCondition = lock.newCondition();
        //消费者队列
        Condition consumeCondition = lock.newCondition();
        new Thread(()->{
            try {
                lock.lock();
                while (true){
                    for (int i = 0; i < 5; i++) {
                        System.out.println("生产者生产了1个包子!");
                        Thread.sleep(500);//等待3s
                    }
                    consumeCondition.signal();//唤醒消费者
                    productCondition.await();//生产者等待
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            try {
                lock.lock();
                while (true){
                    for (int i = 0; i < 5; i++) {
                        System.out.println("消费者购买了1个包子!");
                        Thread.sleep(100);//等待1s
                    }
                    productCondition.signal();//唤醒生产者
                    consumeCondition.await();//消费者等待
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }
}
