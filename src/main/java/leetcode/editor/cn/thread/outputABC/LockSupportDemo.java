package leetcode.editor.cn.thread.outputABC;

import java.util.concurrent.locks.LockSupport;

/**
 * 3个线程交替输出ABC
 */
public class LockSupportDemo {

    static Thread A = null;
    static Thread B = null;
    static Thread C = null;
    public static void main(String[] args) {
        A = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.print("A");
                LockSupport.unpark(B);//唤醒B线程
                LockSupport.park();//阻塞当前线程
            }
        });
        B = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LockSupport.park();//阻塞当前线程
                System.out.print("B");
                LockSupport.unpark(C);//唤醒C线程
            }

        });
        C = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LockSupport.park();//阻塞当前线程
                System.out.print("C");
                LockSupport.unpark(A);//唤醒A线程
            }
        });
        A.start();
        B.start();
        C.start();
    }
}
