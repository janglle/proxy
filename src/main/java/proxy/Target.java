package proxy;

/**
 * @author 行一 at 2018/2/9 10:24
 */
public class Target implements TargetInterface {
    public void a() {
        System.out.println("a方法执行...");
        b();
    }

    public void b() {
        System.out.println("b方法执行...");
    }
}
