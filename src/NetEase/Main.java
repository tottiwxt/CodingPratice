package NetEase;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
   
        int x_small = 1000000000;
        int y_large = -1000000000;
        int x_large = -1000000000;
        int y_small = 1000000000;
            for(int j = 0; j < n; j++){             
				x1[j] = sc.nextInt();
				if(x1[j]<x_small) x_small = x1[j];
				
            }//左下x
            for(int j = 0; j < n; j++){             
				y1[j] = sc.nextInt();
				if(y1[j]<y_small) y_small = y2[j];
            }//左下y
            for(int j = 0; j < n; j++){             
				x2[j] = sc.nextInt();
				if(x1[j]>x_large) x_large = x1[j];
            }//右上x
            for(int j = 0; j < n; j++){             
				y2[j] = sc.nextInt();
				if(y2[j]>y_large) y_large = y2[j];
            }//右上y
       
            int x_move = 0;
            int y_move = 0;
             x_move = -x_small;
            System.out.println(("x_move:"+x_move));
             y_move = -y_small;
             System.out.println(("y_move:"+y_move));
             int[][] area = new int[x_large-x_small+1][y_large-y_small+1];
            for(int i = 0;i< x_large+x_move;i++)
            	for(int j = 0; j<y_large+y_move;j++){
            		area[i][j]= 0;
            	}
            int max = 0;
            for(int i = 0 ;i<n;i++){
            	for(int x = x_small+x_move;x<x_large+x_move;x++)
            		for(int y=y_small+y_move;y<y_large+y_move;y++){
            			area[x][y]++;
            			if(area[x][y]>max)
            				max = area[x][y];
            		}
            }
            System.out.println(max);
     }
	private static int find(int n, int k) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 1 ; i<=n ;i++)
			for(int j =1; j<=n; j++){
				if(i%j>=k)
					count++;
			}
		return count;
	}
	
}
