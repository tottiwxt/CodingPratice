
public class reOrderArray {
    public void reOrderArray(int [] array) {
    	int length = array.length;
        int[] odd= new int[length/2+1]; 
        int [] even = new int[length/2+1];
        int ocount = 0;
        int ecount = 0;
    	for(int i = 0; i<array.length;i++){
        	if(array[i]%2 == 0)
        		even[ecount++] = array[i];
        	else 
        		odd[ocount++] = array[i];
        }
    	int x=0;
    	for(;x<ocount;x++){
    		array[x] = odd[x];
    	}
    	for(int j=0;j<ecount;j++){
    		array[j+x] = even[j];
    	}
    }
}
