package AOP_JDK_Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
    //jdk动态代理
    public static UserService creatService(){
        //目标类
        final UserService userService = new UserServiceImpl();
        //切入类
        final Aspect aspect = new Aspect();
        //目标类与切入类结合
        UserService proxyService = (UserService) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //执行目标类方法
                        aspect.before();
                        Object obj = method.invoke(userService,args);
                        aspect.after();
                        return obj;
                    }
                });
        return proxyService;
    }
}
