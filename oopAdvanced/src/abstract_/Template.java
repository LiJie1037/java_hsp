package abstract_;

abstract public class Template {
    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("任务执行时间 " + (end - start));
    }

    public abstract void job();
}
