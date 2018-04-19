package iqiyi;

import java.util.Scanner;

public class MaxChildStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
           String str = in.nextLine();
           char[] string = str.toCharArray();
          
           String res = Max(string,0,string.length-1);
           System.out.println(res);
        }
    }

	private static String Max(char[] str, int start, int end) {
		// TODO Auto-generated method stub\
		if(start == end)
			return ""+str[end];
		char max = str[start];
		
		int index = start;
		for(int i = start;i<=end;i++){
			if(str[i]>max){
				index = i ;
				max = str[i];
			}	
		}
		String  resString = ""+max;
		//System.out.println("max="+index);
		if(index+1<=end)
			resString +=  Max(str, index+1, end);
		return resString;
	}

}
