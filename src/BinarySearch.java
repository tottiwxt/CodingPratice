import java.util.ArrayList;


public class BinarySearch {
	
	
	public static void main(String[] args){
		
		int[] list = { 1, 3, 5, 7 , 10 , 22, 23, 30 , 40 , 50};;
		System.out.println(BinaryFind(list,230));
		
	}
	public static int BinaryFind(int[] list, int target){
		int start = 0;
		int end = list.length-1;
		while(start!=end){
			int mid = (start+end)/2;
			if(mid ==  start || mid == end) return 0;
			if(list[mid]==target)
				return target;
			else if(list[mid]>target)
				end = mid;
			else if (list[mid]<target)
				start = mid;
		}
		
		
		return 0;
	}
}
