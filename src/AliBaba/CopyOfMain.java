package AliBaba;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// 删除相邻重复字符串
// eg. "我说你好你好你好啊"
//   -output: "我说你好啊"
public class CopyOfMain {


   

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	String str = in.nextLine();
        	ArrayList<Character> arrayList = new ArrayList<Character>();
        	for(int i = 0 ; i<str.length();i++){
        		if(arrayList.contains(str.charAt(i))){
        			int position = arrayList.indexOf(str.charAt(i));
        			int j =i;
        			for( j = i;position<i;position++){
        				if(position<arrayList.size()&&arrayList.get(position)==str.charAt(j)){
        					j++;
        				}
        				else{
        					break;
        				}
        			}
        			if(position!=i){
        				for(;i<j;i++){
        					arrayList.add(str.charAt(i));
        				}
        					
        			}
        			i = j;
        		}
        		else {
        			arrayList.add(str.charAt(i));
				
				}
        	}
        	
        	for(int i = 0;i<arrayList.size();i++){
        		System.out.print(arrayList.get(i));
        	}
        }
       
       
    }
}