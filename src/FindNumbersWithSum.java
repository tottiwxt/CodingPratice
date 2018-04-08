import java.util.ArrayList;


public class FindNumbersWithSum {

	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
	
        ArrayList<Integer> res =new ArrayList<Integer>();
    	if(array.length==0) return res;
		int i = 0; 
		int j = array.length-1;
		int min = 999999999;
		
		while(i!=j){
			if(array[i]+array[j]==sum){
				if(array[i]*array[j]<min){
					min = array[i]*array[j];
					if(!res.isEmpty()){
					res.set(0,array[i]);
					res.set(1,array[j]);
					}
					else{
						res.add(array[i]);
						res.add(array[j]);
					}
				}
				i++;
			}
			else if(array[i]+array[j]<sum){
				i++;
			}
			else if(array[i]+array[j]>sum){
				j--;
			}
		}
		
		
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
