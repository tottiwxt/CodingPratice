
public class GetNumberOfK {

	/**
	 * @param args
	 */
	public int GetNumberOfK(int [] array , int k) {
	   int len = array.length;
	   int low = getLow(array,k,0,len-1);
	   int high = getHigh(array,k,0,len-1);
	   
		
		return high-low;
    }
	
	private int getHigh(int[] array, int k, int start, int end) {
		// TODO Auto-generated method stub
		if(start > end )  return -1;
		int mid = (end-start)/2;
		if(array[mid]==k){
			if(array[mid+1]!=k)	return mid;
			else {
				start = mid;
			}
		}
		
		return getHigh(array, k, start, end);
	}

	private int getLow(int[] array, int k, int start, int end) {
		// TODO Auto-generated method stub
		if(start > end )  return -1;
		int mid = start+(end-start)/2;
		if(array[mid]==k){
			if(mid == start ||array[mid-1]!=k)	return mid;
			else {
				start = mid;
			}
		}
		
		return getLow(array, k, start, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
