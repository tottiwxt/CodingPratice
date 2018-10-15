//package AOP_Cglib_Test;
//
//
//
//import java.lang.reflect.Method;
//
//public class MyBeanFactoryCglib {
//
//    public static UserServiceImpl createService(){
//        //目标类
//        final UserServiceImpl userService = new UserServiceImpl();
//        //切面类
//        final Aspect aspect = new Aspect();
//
//
//        //核心类
//        Enhancer enhancer = new Enhancer();
//        //确定父类
//        enhancer.setSuperclass(userService.getClass());
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//                aspect.before();
//                Object obj = method.invoke(userService,args);
//                aspect.after();
//                return obj;
//            }
//        });
//
//        //代理类
//        UserServiceImpl proxyService = (UserServiceImpl)enhancer.create();
//        return proxyService;
//    }
//
//
//
//}
