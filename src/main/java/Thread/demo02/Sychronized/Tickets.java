package Thread.demo02.Sychronized;

/**
 * @ClassName Ticket
 * @Description 解决线程安全问题
 * @Author Chris
 * @Date 2021/4/20
 **/
/**
    卖票案例出现了线程安全问题
    卖出了不存在的票和重复的票

    解决线程安全问题的一种方案：使用同步代码块
    格式：
        synchronized(锁对象){
        可能出现线程安全问题的代码（访问了共享数据的代码）
        }

    注意：
        1.通过代码块中的锁对象，可以使用任意的对象
        2.但似乎必须保证多个线程使用的锁对象是同一个
        3.锁对象作用：
            把同步代码块锁住，只让一个线程在同步代码块中执行。
 **/
public class Tickets implements Runnable{
    //定义一个多个线程共享的票源
    private int tickets = 100;

    //创建一个锁对象
    final Object obj = new Object();

    public void run() {
        //定义死循环，让卖票操作重复执行
        while(true)
        {
            //同步代码块
            synchronized (obj)
            {
                //先判断票是否存在
                if(tickets>0)
                {
                    System.out.println(Thread.currentThread().getName()+"---->正在卖第"+tickets+"张票");
                    tickets--;
                }
            }
        }
    }
}
