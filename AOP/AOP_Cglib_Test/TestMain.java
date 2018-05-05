package AOP_Cglib_Test;

import org.junit.Test;

public class TestMain {
    @Test
    public void demo01(){
        UserServiceImpl userService = MyBeanFactoryCglib.createService();
        userService.addUser();
        userService.updateUser();
        userService.delectUser();
    }
}
