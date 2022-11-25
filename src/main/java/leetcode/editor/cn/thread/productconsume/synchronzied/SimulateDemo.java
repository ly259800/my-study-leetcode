package leetcode.editor.cn.thread.productconsume.synchronzied;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟生产者和消费者场景
 */

public class SimulateDemo {


    public static void main(String[] args) {
        List<Food> foodList= new ArrayList<>(5);
        //创建1个生产者
        ProductThread productThread = new ProductThread(foodList, 5);
        new Thread(productThread).start();
        //创建1个消费者
        new Thread(new ConsumeThread(foodList, foodList.size())).start();
    }


}
