package leetcode.editor.cn.thread.taskfail;

public class Task{

    private String name;

    private Integer timeSeconds;

    private boolean state;

    public Task(String name, Integer timeSeconds, boolean state) {
        this.name = name;
        this.timeSeconds = timeSeconds;
        this.state = state;
    }

    public Boolean runTask() {
        System.out.println("任务执行中...");




        return state;
    }

    public void cannel(){
        //任务取消执行


    }

}
