package ReferencePass;

public class ReferencePass {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    ReferencePass(String name, int age){
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        ReferencePass obj = new ReferencePass("Bonbon",20);
        Pass(obj);
        System.out.println(obj.getName());
    }

    private static void Pass(ReferencePass obj) {
        obj.setName("Pig");
    }
}
