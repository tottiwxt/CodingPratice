package AOP_JDK_Test;

import org.junit.jupiter.api.Test;

public class TestMain {
    @Test
    public void demo01(){
        UserService userService = MyBeanFactory.creatService();
        userService.addUser();
    }
}
