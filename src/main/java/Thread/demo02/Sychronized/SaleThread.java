package Thread.demo02.Sychronized;

/**
 * @ClassName SaleThread
 * @Description TODO
 * @Author Chris
 * @Date 2021/4/20
 **/
public class SaleThread {
    public static void main(String[] args) {
        Tickets t = new Tickets();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
    }
}
