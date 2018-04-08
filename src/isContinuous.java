import java.util.Arrays;


public class isContinuous {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = { 0,0,3,7,5};
		System.out.println(isContinuous(x));
	}
	
	public static boolean isContinuous(int [] numbers) {
		Arrays.sort(numbers);
		int count = 0;
		for(int i = 0 ;i<numbers.length-1;i++){
			if(numbers[i]== 0)
				count++;
			else if(numbers[i+1]-numbers[i]>1+count)
				return false;
			else if(numbers[i+1]-numbers[i]==1)
				continue;
			else if(numbers[i+1]-numbers[i]==0)
				return false;
			else if (numbers[i+1]-numbers[i]==1+count)
				count = 0;
		}
		
		return true;
    }

}
