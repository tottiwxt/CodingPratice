import java.awt.datatransfer.StringSelection;


public class LeftRotateString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LeftRotateString("",2));
	}
	
	
	public static String LeftRotateString(String str,int n) {
        if(str == "") return null;
		String tmp;
        tmp = str.substring(0, n);
        String tmp2 = str.substring(n,str.length());
        
		
		
		return tmp2+tmp;
    }
}
