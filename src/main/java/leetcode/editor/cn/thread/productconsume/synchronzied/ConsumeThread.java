package leetcode.editor.cn.thread.productconsume.synchronzied;

import java.util.List;

/**
 * 消费者线程
 */

public class ConsumeThread implements Runnable{

    //当前存在的食物
    private List<Food> list;
    //食物总数
    private int sum;

    public ConsumeThread(List<Food> list, int sum) {
        this.list = list;
        this.sum = sum;
    }

    @Override
    public void run() {
        synchronized (list){
            while (true){
                list.remove(0);//购买1个包子
                System.out.println("消费者【"+Thread.currentThread().getName()+"】已经购买了1个包子");
                try {
                    if (list.isEmpty()){
                        //唤醒生产者
                        list.notify();
                        //消费者等待
                        list.wait();
                    }
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
