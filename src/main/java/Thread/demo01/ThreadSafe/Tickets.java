package Thread.demo01.ThreadSafe;

/**
 * @ClassName Ticket
 * @Description TODO
 * @Author Chris
 * @Date 2021/4/20
 **/
public class Tickets implements Runnable{
    //定义一个多个线程共享的票源
    private int tickets = 100;
    public void run() {
        //定义死循环，让卖票操作重复执行
        while(true)
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
