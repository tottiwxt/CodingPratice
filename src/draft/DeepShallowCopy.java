package draft;

public class DeepShallowCopy {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("xutao", 24,new Pet("dog"));
//		Person p2 = p1;
		Person p2 = (Person) p1.clone();
		p2.name = "jiaping";
		p2.pet.name = "cat";
		System.out.println("p1的名为:"+p1.name);
		System.out.println("p1的宠物名为:"+p1.pet.name);
		System.out.println("p2的宠物名为:"+p2.pet.name); //宠物名一样，浅拷贝
	}

}
 class Person implements Cloneable{
	String name;
	int age;
	Pet pet;
	public Object clone(){
		Person b =null;
		try{
			b = (Person)super.clone();
		}catch (CloneNotSupportedException  e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
	public Person(String name,int age,Pet pet) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.pet = pet;
	}
	
}

 class Pet{
	 String name;
	 Pet(String name){
		 this.name = name ;
	 }
 }