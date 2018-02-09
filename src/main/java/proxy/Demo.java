package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 行一 at 2018/2/9 10:25
 */
public class Demo {

    public static void main(String... args) {
        final Target target = new Target();
        TargetInterface proxyInstance = (TargetInterface) Proxy.newProxyInstance(Demo.class.getClassLoader(), Target.class.getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName();
                System.out.println("方法" + name + "被代理了");
                method.invoke(target);
                return null;
            }
        });
        System.out.println("打印:方法b被代理了");
        proxyInstance.b();
        System.out.println();
        System.out.println("不打印方法b被代理了");
        proxyInstance.a();
    }
}
