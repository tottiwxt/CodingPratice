package draft;

import java.lang.reflect.Method;

 class Test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent parent =  new Child();
		parent.method();
		parent.staticMethod();
		Child child = (Child) new Parent();
		child.method();
		
//		child c = (child) new Parent();
//		c.Method1();
		
	}
	
}
