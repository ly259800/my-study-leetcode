package leetcode.editor.cn.thread.philosopher;

/**
 * 哲学家
 */
public class Philosopher extends Thread{

    private Chopsticks left;//左边筷子
    private Chopsticks right;//右边筷子
    private String name;
    private Integer index;

    public Philosopher(String name, Integer index,Chopsticks left, Chopsticks right) {
        this.left = left;
        this.right = right;
        this.name = name;
        this.index = index;
    }

    @Override
    public void run() {
        /**
         *          方式1，会造成死锁
         *         synchronized (left){
         *             System.out.println(name+"拿到了左手边的筷子!");
         *             synchronized (right){
         *                 System.out.println(name+"拿到了右手边的筷子!");
         *                 System.out.println(name+"可以就餐!");
         *             }
         *         }
         */

         //方式2，能够1个1个解开死锁，如果锁住的对象很多，会效率很低
         /*if(index == 1){
            synchronized (left){
                System.out.println(name+"拿到了左手边的筷子!");
                synchronized (right){
                    System.out.println(name+"拿到了右手边的筷子!");
                    System.out.println(name+"可以就餐!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            synchronized (right){
                System.out.println(name+"拿到了右手边的筷子!");
                synchronized (left){
                    System.out.println(name+"拿到了左手边的筷子!");
                    System.out.println(name+"可以就餐!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }*/



        //方式3,可以解开死锁，同时效率很高
        if (index %2 == 0) {
            synchronized (left) {
                System.out.println(name + "拿到了左手边的筷子!");
                synchronized (right) {
                    System.out.println(name + "拿到了右手边的筷子!");
                    System.out.println(name + "可以就餐!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            synchronized (right) {
                System.out.println(name + "拿到了右手边的筷子!");
                synchronized (left) {
                    System.out.println(name + "拿到了左手边的筷子!");
                    System.out.println(name + "可以就餐!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
