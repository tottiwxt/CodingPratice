package AOP_JDK_Test;

public class Aspect {
    public void before(){
        System.out.println("在方法前执行");
    }
    public void after(){
        System.out.println("在方法后执行");
    }
}
