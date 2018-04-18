package draft;

public class QuickSort {

	/**
	 * @param args
	 */
	static int[] quickSort1(int[] num,int begin,int end){
		
		int number = num[begin];
		int low = begin;
		int high = end;
		boolean bool = true;
		while(low<high){
			
			if(bool){
				while(num[high]>number&&high>low)
					high--;
				if(num[high]<num[low]){
					num[low] = num[high];
					bool = false;
					//break;
				}
			}
			else{
				while(num[low]<number&&low<high)
					low++;
				if(num[low]>num[high]){
					num[high] = num[low];
					bool = true;
					//break;
				}
			}
		}
		System.out.println("break");
		num[low] = number;
		
		if(low-1>begin)
			num = quickSort(num, begin, low-1);
		if(low+1<end)
			num = quickSort(num, low+1, end);
		
		
		return num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int num[] = { 21, 0,11,88,55,66,77,44,22,33,99999, -8888};
			num = quickSort1(num,0,11);
			for(int i = 0; i<num.length;i++)
				System.out.println(num[i]);
	}
	private static int[] quickSort(int[] num, int start, int end) {
		// TODO Auto-generated method stub
		int tmp = num[start];
		int i = start;
		int j = end;
		while(i<j){
			while(j>i&&num[j]>tmp)
				j--;
			num[i] = num[j];
			while(i<j&&num[i]<tmp)
				i++;
			num[j] = num[i];
		}
		System.out.println("break");
		num[i] = tmp;
		if(i-1>start)
		num = quickSort(num, start, i-1);
		if(i+1<end)
		num = quickSort(num, i+1, end);
		return num;
	}

}
