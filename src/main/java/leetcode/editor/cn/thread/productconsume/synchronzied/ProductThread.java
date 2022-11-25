package leetcode.editor.cn.thread.productconsume.synchronzied;

import java.util.List;

/**
 * 生产者线程
 */

public class ProductThread implements Runnable{

    //当前拥有的食物
    private List<Food> list;
    //食物总数
    private int sum;

    public ProductThread(List<Food> list,int sum) {
        this.list = list;
        this.sum = sum;
    }

    @Override
    public void run() {
        synchronized (list){
            while (true){
                //当前没用食物，则进行生产
                list.add(new Food("包子"));
                System.out.println("生产单生产了1个包子,当前包子数:"+list.size()+",总数："+sum);
                if (list.size()==sum){
                    //食物生成完毕，等待消费者购买
                    try {
                        //唤醒消费者
                        list.notify();
                        //生产者等待
                        list.wait();
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
