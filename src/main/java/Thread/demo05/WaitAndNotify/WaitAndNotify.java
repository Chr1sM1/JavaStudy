package Thread.demo05.WaitAndNotify;

/**
 * @ClassName WaitAndNotify
 * @Description TODO
 * @Author Chris
 * @Date 2021/4/21
 **/

import sun.font.TrueTypeFont;

/**
    等待唤醒案例:线程之间的通信
        创建一个顾客线程（消费者）：告知老板要的包子的种类和数量，调用wait方法，放弃cpu的执行，
        进入到Waiting状态（无限等待）
        创建一个老板线程（生产者）：花了5秒做包子，做好包子之后，调用notify方法，唤醒顾客吃包子

    注意：
         顾客和老板线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行
         同步使用的锁对象必须保证唯一
         只有锁对象才能调用wait和notify方法
    Object类中的方法
    void wait()
            在其他线程调用此对象的notify()方法或notifyAll()方法前，导致当前线程等待。
    void notify()
            唤醒在此对象显示器上等待的单个线程
            会继续执行wait方法之后的代码
 **/
public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        //创建锁对象，保证唯一
        final Object obj = new Object();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj){
                        System.out.println("告知老板要的包子的钟类和数量");
                        //调用wait方法，放弃cpu的执行，进入到Waiting状态（无限等待）
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("包子已经做好了，开吃！");
                        System.out.println("------------------");
                        obj.notify();
                    }
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                while(true){
                    synchronized (obj){
                        try {
                            Thread.sleep(3);//花3秒种做包子
                            // 保证等待和唤醒的线程只有一个执行，需要使用同步技术
                             System.out.println("老板3秒钟之后做好了包子，告知顾客，可以吃包子了");
                            // 做好包子之后，调用notify方法，唤醒顾客吃包子
                             obj.notify();
                             obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } 
                }
            }
        }.start();
    }
}
