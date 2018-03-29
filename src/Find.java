
public class Find {
	public boolean Find(int target, int [][] array) {
		
		int row = array.length;
		int line = array[0].length;
		
		for (int i = 0 ; i<row ; i++){
			for (int j = line-1; j>=0; j--){
				if (target == array[i][j])	
					return true;
				else if (target > array[i][j]) break;
				else if (target < array[i][j]) continue;
					
			}
		}
		
		
		return false;
    }
}
