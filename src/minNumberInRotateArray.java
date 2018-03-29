
public class minNumberInRotateArray {
	
	//·¨1
	/*
	public int minNumberInRotateArray(int [] array) {
		
		int min = array[0];
		for(int i=1;i<array.length;i++){
			if(array[i]<min)
				return array[i];
		}
		return 0;
    }
    */
	public int minNumberInRotateArray(int [] array) {
		int head = 0;
		int tail = array.length-1;
		int mid = 0;
	    while(array[head]>=array[tail]){
	    	 int len = tail-head;
	    	 if(len==1) {
	    		 if(array[head]<array[tail]) return array[head];
	    		 else return array[tail];
	    	 }
	    	 
	    	 if(len%2==0) mid = (tail+head)/2;
	    	 
	    	 else mid = (tail-1+head)/2;
	    	 
	    	 
	    	 if(array[mid]<array[tail]){
	    		 tail = mid;
	    	 }
	    	 else {
	    		 head = mid;
	    	 }
	    }
		
		return 0;
	}
}
