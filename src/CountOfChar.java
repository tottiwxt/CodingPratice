import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;




public class CountOfChar {

	/**
	 * @param args
	 */
	static class  CharCount{
		int count = 0;
		char ch ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			CharCount[] res = new CharCount[26];
			for(int i = 0;i<26;i++){
				res[i] = new CharCount();
			}
			for(int i = 0 ;i<26;i++)
				res[i].ch =  (char) ('a'+i);
			String str =  sc.nextLine();
			for(int i = 0 ; i<str.length();i++){
				res[str.charAt(i)-'a'].count++;
			}
			Arrays.sort(res, new Comparator<CharCount>() {
				@Override
				public int compare(CharCount o1, CharCount o2) {
					// TODO Auto-generated method stub
					
					return o2.count-o1.count>0?o2.count-o1.count:o1.ch>o2.ch?1:-1;
				}
			});
			
			for(int i = 0;i<res.length;i++){
				if(res[i].count!=0){
					System.out.print(res[i].ch);
				}
			}
		}
	}

}
