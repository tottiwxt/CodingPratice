package Synchronize;

public class Synchronized implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 /*synchronized(this) {  
             for (int i = 0; i < 5; i++) {  
                  System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);  
             }  
        }  */
		fun1();
		fun2();
	}
	public synchronized void fun1(){
		for (int i = 0; i < 5; i++) {  
            System.out.println(Thread.currentThread().getName() + " fun1  " + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public  void fun2(){
		for (int i = 0; i < 5; i++) {  
            System.out.println(Thread.currentThread().getName() + " fun2  " + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
       }  
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Synchronized t = new Synchronized();
		final Synchronized ts = new Synchronized();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				t.fun1();
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				t.fun1();
			}
		}, "t2");
		t1.start();
		t2.start();
//
//		System.out.println(Runtime.getRuntime().maxMemory());
//		System.out.println(Runtime.getRuntime().freeMemory());
//		System.out.println(Runtime.getRuntime().totalMemory());

//		for (int i = 0; i < 5; i++) {
//
//				Thread th = new MyThread();
//				th.start();
//			}
//		}

	}
}
