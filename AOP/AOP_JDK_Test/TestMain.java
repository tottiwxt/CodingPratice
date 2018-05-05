package AOP_JDK_Test;

import org.junit.Test;

public class TestMain {
    @Test
    public void demo01(){
        UserService userService = MyBeanFactory.creatService();
        userService.addUser();
    }
}
