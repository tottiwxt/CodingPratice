package meituan;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Test {
}
public class Main
{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner  = new Scanner(System.in);
        while(scanner.hasNext()){
          int n = scanner.nextInt();
          int X = scanner.nextInt();
          ArrayList<Integer> al = new ArrayList<>();
          for(int i = 0;i<n;i++){
              al.add(scanner.nextInt());
          }
            al.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int i = o1 > o2 ? 1 : -1;
                    return i;
                }
            });
          int min = 100000;
          int index  = -1;
          for(int i = 0 ;i<n;i++){
                if(al.get(i)>=X){
                    min  = al.get(i);
                    index = i;
                    break;
                }
          }
          int minSum = 0;

              int left = 0 ;
              int right = 0;
              for(int i = 0 ; i<n;i++){
                  minSum+=al.get(i);
                  right++;
                  int tmpSum = minSum;
                  if(minSum>=X){
                      //大于X了
                      //开始优化
                      right --;
                      {
                          for(;right>=0;right--){
                              int minus = al.get(right);
                              if(minSum-minus>=X){
                                  minSum -= minus;
                              }
                          }
                      }
                      break;
                  }
              }


            System.out.println(minSum<min?minSum:min);

        }
    }


}