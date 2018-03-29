
public class VerifySquenceOfBST {
	 public boolean VerifySquenceOfBST(int [] sequence) {
		 int len = sequence.length;
		 int root = sequence[len-1];
		 
		 return Verify(sequence,0,len-1);		 
		 
		  }

	private boolean Verify(int[] sequence, int l, int r) {
		// TODO Auto-generated method stub
		if(l>=r) return true;
		int mid = sequence[r];
		int index = l;
		boolean bool = false;
		for(int i = r-1; i>=l ;i--){
			if(sequence[i]<mid) {
				index = i;
				bool = true;
				break;
				} 
		}
		if(bool){
		for(int i = index;i>=l;i--)
			if(sequence[i]>mid) return false;
		}
		else{
			for(int i = index;i>=l;i--)
				if(sequence[i]>mid) return false;
			
		}
		
		return Verify(sequence,l,index)&&Verify(sequence,index+1,r-1);
	}
}
