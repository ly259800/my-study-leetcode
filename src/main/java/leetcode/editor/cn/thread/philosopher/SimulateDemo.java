package leetcode.editor.cn.thread.philosopher;

/**
 * 哲学家就餐问题模拟
 * 在1个餐桌上有5个哲学家，每个哲学家左手和右手边都有1根筷子，当哲学家左手和右手都拿到筷子时才可就餐，模拟这个就餐的场景
 */

public class SimulateDemo {

    public static void main(String[] args) {
        Chopsticks cs1 = new Chopsticks();
        Chopsticks cs2 = new Chopsticks();
        Chopsticks cs3 = new Chopsticks();
        Chopsticks cs4 = new Chopsticks();
        Chopsticks cs5 = new Chopsticks();
        new Philosopher("p1",1,cs1,cs2).start();
        new Philosopher("p2",2,cs2,cs3).start();
        new Philosopher("p3",3,cs3,cs4).start();
        new Philosopher("p4",4,cs4,cs5).start();
        new Philosopher("p5",5,cs5,cs1).start();

    }









}
