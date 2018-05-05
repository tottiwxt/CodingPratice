package AOP_JDK_Test;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("addUser");
    }

    @Override
    public void updateUser() {
        System.out.println("updateUser");
    }

    @Override
    public void delectUser() {
        System.out.println("delectUser");
    }
}
