package HUAWEI;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] direction ={{-1,0},{0,1},{0,-1},{1,0}};
        while (in.hasNextInt()) {//注意while处理多个case
            int m = in.nextInt();
            int n = in.nextInt();
            int height = in.nextInt();
            int map[][] = new int[m][n];
            int res[][] = new int[m][n];
            for(int i = 0;i<m;i++)
                for(int j = 0;j<n;j++) {

                    map[i][j] = in.nextInt();
                    res[i][j] = 0;
                }
//            for(int i = 0 ;i <m;i++) {
//                for (int j = 0; j < n; j++)
//                    System.out.print(map[i][j]+ " ");
//                System.out.println("");
//            }
            for(int i = 0;i<m;i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] <= height) {
                        for (int k = 0; k < 4; k++) {
                            int newX = i + direction[k][0];
                            int newY = j + direction[k][1];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                                if (map[newX][newY] <= height) {
                                    map[newX][newY] = -99999999;
                                    map[i][j] = -99999999;
                                }
                            }
                        }
                    }

                }
            }

//                        for(int i = 0 ;i <m;i++) {
//                for (int j = 0; j < n; j++)
//                    System.out.print(map[i][j]+ " ");
//                System.out.println("");
//            }
            int max = 0;
            for(int i = 0 ;i <m;i++) {
                for (int j = 0; j < n; j++)
                {
                     res[i][j] = getLongest(height,map,i,j,res,direction,m,n);
                    if(res[i][j]>=max)
                        max = res[i][j];

                }
            }
            System.out.println(max);
        }
    }

    private static int getLongest(int height,int[][] map, int x, int y ,int[][] res,int[][] direction,int m,int n ) {
        if(res[x][y]!=0)
            return res[x][y];
        int maxlength = 0 ;

        if(map[x][y]==-99999999)
            return 0;
        for(int i =0 ;i<4;i++){
            int newX = x +direction[i][0];
            int newY = y + direction[i][1];
            if(newX>=0&&newX<m&&newY>=0&&newY<n&&map[newX][newY]<map[x][y]&&map[newX][newY]!=-99999999){
                int length = getLongest(height,map,newX,newY,res,direction,m,n);
                if(length>maxlength)
                    maxlength = length;
            }
        }

        res[x][y] = maxlength+1;
        return maxlength+1;
    }
}