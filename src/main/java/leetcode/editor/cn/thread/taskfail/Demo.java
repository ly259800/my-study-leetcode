package leetcode.editor.cn.thread.taskfail;

import java.util.concurrent.CompletableFuture;

/**
 * 有多个任务，其中1个任务执行失败，则其他任务都应该取消执行
 */

public class Demo {

    public static void main(String[] args) throws Exception{
        Task task1= new Task("task1",1,false);
        Task task2= new Task("task2",3,true);
        Task task3= new Task("task3",4,true);

        CompletableFuture.supplyAsync(()->task1.runTask()).thenAccept((result->callback(result,task1)));
        CompletableFuture.supplyAsync(()->task2.runTask()).thenAccept((result->callback(result,task2)));
        CompletableFuture.supplyAsync(()->task3.runTask()).thenAccept((result->callback(result,task3)));
    }


    private static void callback(Boolean reuslt,Task task){
        if (!reuslt){
            //任务执行失败,调用任务取消执行的逻辑
            task.cannel();
        }
    }
}
