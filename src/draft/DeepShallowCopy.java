package draft;

public class DeepShallowCopy {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("xutao", 24);
		Person p2 = p1;
		p2.name = "jiaping";
		System.out.println(p1.name);
	}

}
 class Person{
	String name;
	int age;
	public Person(String name,int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}
}
