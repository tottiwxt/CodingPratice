

 class ThreadTest1 extends Thread {

	private Thread thread;
	private String thread_name;
	
	ThreadTest1(String name){
		this.thread_name = name;
		System.out.println("create thread :"+ name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("start Thread :"+ thread_name);
		for(int i = 0 ; i<5;i++){
			try {
				System.out.println("running Thread "+thread_name +"for the "+ i +"time");
				thread.sleep(i);
				System.out.println("running Thread "+thread_name +"wake up");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Starting " +  thread_name );
	      if (thread == null) {
	         thread = new Thread (this, thread_name);
	         thread.start ();
	      }
	}

	
}

class ThreadTest {
     
	public static void main(String args[] ){
		ThreadTest1 th1 = new ThreadTest1("1");
		ThreadTest1 th2 = new ThreadTest1("2");
		th1.start();
		th2.start();
	}
	
}
