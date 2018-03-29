import java.util.ArrayList;



public class Fibonacci {
	public int Fibonacci(int n) {
			int first =1 ;
			int second = 1;
			if(n==0) return 0;
			if(n==1) return 1;
			if(n==2) return 1;
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(1);
			for(int i=3;i<n;i++){
				list = cal(list);
			}
			return list.get(0)+list.get(1);
    }

	private ArrayList<Integer> cal(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		int num = list.get(0)+list.get(1);
		list.set(0, list.get(1));
		list.set(1, num);
		return list;
	}
}
