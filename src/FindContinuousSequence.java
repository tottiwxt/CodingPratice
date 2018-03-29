import java.util.ArrayList;


public class FindContinuousSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 ArrayList<Integer> tmp = new ArrayList<Integer>();
//		 tmp.add(1);
//		 tmp.add(2);
//		 tmp.remove(0);
//		 //tmp.remove()
//		 System.out.println(tmp.get(0));
		System.out.println(FindContinuousSequence(15));
	}
	
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
	    ArrayList tmp = new ArrayList<Integer>();
	    ArrayList res =new ArrayList<ArrayList<Integer>>();
	    //tmp.
	    if(sum == 1 )  return res;
	    int tmpsum = 0;
		for(int i = 1 ;i<=sum/2+1;i++){
			tmpsum += i;
			if(tmpsum == sum){
				System.out.println("Ìí¼Ó"+i);
				tmp.add(i);
				res.add(tmp);
				System.out.println("res =="+res.get(0));
				//tmp.clear();
				//tmpsum = 0;
			}
			else if(tmpsum<sum){
				tmp.add(i);
				System.out.println("Ìí¼Ó"+i);
			}
			else if(tmpsum>sum){
				tmp.add(i);
				while(tmpsum>sum){
					System.out.println("Ìí¼Ó"+i);
					int remove = (int) tmp.get(0);
					System.out.println("É¾³ý" + remove);
					tmpsum -= remove;
					tmp.remove(0);
					if(tmpsum == sum){
						res.add(new ArrayList(tmp));
						
					}
				}
			}
		}
		
		
		return res;
    }

}
