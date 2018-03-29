public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
    	int count = 0;
    	int length = str.length();
    	for(int i = 0;i<str.length();i++) 
            if(str.charAt(i)==' '){
            	count ++;
            }
        int len = length+2*count; //ÐÂµÄ
        str.setLength(len);
        for(int i = length-1,  j =len -1; i >= 0 && j>= 0; i-- ){  //j ÐÂ   i ¾É
        	if(str.charAt(i)==' '){
        		str.setCharAt(j--, '0');
        		str.setCharAt(j--, '2');
        		str.setCharAt(j--, '%');
        	}
        	
        	else {
        		str.setCharAt(j--, str.charAt(i));
        	}
        }
            	
            	
            	
        return str.toString();
    }
}