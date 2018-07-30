package helpers;

import java.util.Random;

public class BasicGenerater implements Generater {
	
	private Verifier vfr;
	
	public BasicGenerater(Verifier v) {
		this.vfr=v;
	}

	@Override
	public Problem generate() {
		Problem p=null;
		do {
			Random rnd=new Random();
			int[] nums=new int[4];
			for(int i=0;i<4;i++) {
				nums[i]=rnd.nextInt(13)+1;
			}
			p=new Problem(nums,null);
		}while(!vfr.isValid(p));
		
		return p;
	}
	
	

}
