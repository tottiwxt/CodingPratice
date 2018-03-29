
public class FindGreatestSumOfSubArray {

	/**
	 * @param args
	 */
	public int FindGreatestSumOfSubArray(int[] array) {
        int len =array.length;
        int sum = 0;
        int max = array[0];
        for(int i =0;i<len; i++){
        	if(sum<0) sum = 0;
        	sum += array[i];
        	if(sum >= max){
        		max = sum;
        	}
        }
		
		
		
		return sum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
