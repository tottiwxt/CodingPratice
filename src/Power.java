
public class Power {
	 public double Power(double base, int exponent) {
		 double result = 1;
		 
		 if(exponent>0){
		 for(int i =0; i<exponent;i++) {
			 
			 result = result * base;
		 }
		 }
		 else if(exponent ==0)  return 1;
		 else {
			 exponent = -exponent;
			 base = 1/base;
			 for(int i =0;i<exponent;i++){
				 result = result*base;
			 }
		 }
		 return result;
	        
	  }
}
