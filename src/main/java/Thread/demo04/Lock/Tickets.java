package Thread.demo04.Lock;

/**
 * @ClassName Ticket
 * @Description TODO
 * @Author Chris
 * @Date 2021/4/20
 **/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 卖票案例出现了线程安全问题
 卖出了不存在的票和重复的票

 解决线程安全问题的第三种方案：使用Lock锁
 java。util.concurrent.locks.Lock接口
 Lock 实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作。
 Lock接口中的方法：
        void lock()获得锁。
        void unlock()释放锁。
 java.util.concurrent.locks.ReentrantLock implements Lock接口

 使用步骤：
    1.在成员位置创建一个ReentrantLock对象。
    2.在可能会出现安全问题的代码前调用Lock接口中的方法lock获取锁
    3.在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁
 **/
public class Tickets implements Runnable{
    //定义一个多个线程共享的票源
    private int tickets = 100;
    //1.在成员位置创建一个ReenrantLock对象
    Lock l = new ReentrantLock();

    public void run() {
        //定义死循环，让卖票操作重复执行
        while(true)
        {
            //2.在可能会出现安全问题的代码前调用Lock接口中的方法Lock获取锁
            l.lock();
            try {
                //先判断票是否存在
                if(tickets>0)
                {
                //提高安全问题出现的概率，让程序睡眠
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName()+"---->正在卖第"+tickets+"张票");
                    tickets--;
                }
            }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    l.unlock();
                }
        }
    }
}
