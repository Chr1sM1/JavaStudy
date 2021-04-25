package Thread.demo07.ThreadPool;

/**
 * @ClassName RunnableImpl
 * @Description TODO
 * @Author Chris
 * @Date 2021/4/25
 **/
public class RunnableImpl implements Runnable {
    //2.创建一个类，实现Runnable接口，重写run方法，设置线程任务。
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个新的线程");
    }
}
