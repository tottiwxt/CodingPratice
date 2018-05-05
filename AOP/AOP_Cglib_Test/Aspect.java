package AOP_Cglib_Test;

public class Aspect {
    public void before(){
        System.out.println("Cglib在方法前执行/Cglib");
    }
    public void after(){
        System.out.println("Cglib在方法后执行/Cglib");
    }
}
