package Thread.demo06.Baozi;

/**
 * @ClassName demo
 * @Description 测试类
 * @Author Chris
 * @Date 2021/4/22
 **/

/**
 测试类：
 创建包子对象
 创建包子铺线程，开启，生产包子
 创建包子铺线程，开启，生产包子
 **/
public class demo {
    public static void main(String[] args) {
        //创建包子对象
        Baozi bz = new Baozi();
        //创建包子铺线程，开启，生产包子
        new BaoziPu(bz).start();
        //创建包子铺线程，开启，生产包子
        new ChiHuo(bz).start();
    }
}
