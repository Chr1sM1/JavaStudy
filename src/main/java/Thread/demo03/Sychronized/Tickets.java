package Thread.demo03.Sychronized;

/**
 * @ClassName Ticket
 * @Description 解决线程安全问题
 * @Author Chris
 * @Date 2021/4/20
 **/
/**
    卖票案例出现了线程安全问题
    卖出了不存在的票和重复的票

    解决线程安全问题的一种方案：使用同步方法
    使用步骤：
        1.把访问了共享数据的代码抽取出来，放到一个方法中
        2.在方法上添加synchronized修饰符

    格式：定义方法的格式
    修饰符sunchronized返回值类型 方法名（参数列表）{}

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
            payTickets();
        }
    }

    /**定义一个同步方法
     * 同步方法也会把方法内部的代码锁住
     * 只让一个线程执行
     * 同步方法的锁对象是谁？
     * 就是实现类对象 new RunnableImpl（）
     * 也就是this
     */
    public synchronized void payTickets(){
            //先判断票是否存在
            if(tickets>0)
            {
                System.out.println(Thread.currentThread().getName()+"---->正在卖第"+tickets+"张票");
                tickets--;
            }
        }
    }
