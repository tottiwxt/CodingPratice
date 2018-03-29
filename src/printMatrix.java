import java.util.ArrayList;


public class printMatrix {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	    ArrayList<Integer> array = new ArrayList<Integer>();
		if(matrix == null) return null;
		
		int column = matrix[0].length; //5
		int row = matrix.length; //1
	
			int c = 0;
			for(;c<column;c++){
				
				array.add(matrix[0][c]);  
			} // c = 4
			int r = 1;
			for(;r<row;r++){
				array.add(matrix[r][c-1]);
			}//  r = 4
			if(column > 1 && row >1){
			for(;c-2>=0;c--){
				array.add(matrix[r-1][c-2]);
			} // r=4 c=1  
			}
			if(row > 2){
			for(;r-2>=1;r--){
				array.add(matrix[r-2][c-1]);
			} //c= 1 , r = 2
			}
			if(row>=3 && column >=3) {
				int matrix2[][]  ;
				matrix2 = new int[row-2][column-2];
				for(int i =1; i < row-1; i++   )
					for(int j = 1;j < column - 1; j++ )
						matrix2[i-1][j-1]=matrix[i][j];
				 array.addAll(printMatrix(matrix2));
			}
			
		
		
		
		
		return array;
	       
    }
}
