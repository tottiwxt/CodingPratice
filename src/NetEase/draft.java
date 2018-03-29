package NetEase;

import java.awt.List;
import java.util.ArrayList;

public class draft {
		
		public static class N{
			static int a;
			int b;
			static int c;
			public  N() {
				// TODO Auto-generated constructor stub
			
			}
			
			public static int methodA() {
				return ++a;
			}
			public  int methodB() {
				return ++b;
			}
			public static int methodC(){
				return ++c;
			}
		}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		N a = new N();
		a.methodA();
		System.out.println(a.methodA());
		N b = new N();
		b.methodB();
		System.out.println(b.methodB());
		N c = new N();
		c.methodC();
		System.out.println(c.methodC());
		//System.out.println(a.a);
		
	}

}
