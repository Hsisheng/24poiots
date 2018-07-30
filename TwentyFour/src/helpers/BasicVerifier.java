package helpers;

import java.util.ArrayList;
import java.util.List;

import exprtree.ExprTree;

public class BasicVerifier implements Verifier{
	
	private final static List<List<Character>> ops;
	
	static {
		ops=PermuteGen.genOpPermute(3);
	}

	@Override
	public boolean isValid(Problem p) {
		List<String> ans=getAnswers(p.nums);
		if(ans.size()>0) {
			p.ans=ans;
			return true;
		}
		return false;
	}

	@Override
	public List<String> getAnswers(int nums[]) {
		List<String> ans=new ArrayList<String>();
		String[] exprSeed=new String[7];
		for(int i=0;i<4;i++) {
			exprSeed[i]=String.valueOf(nums[i]);
		}
		for(List<Character> opSeq:ops) {
			int j=0;
			for(int i=4;i<7;i++) {
				exprSeed[i]=String.valueOf(opSeq.get(j));
				j++;
			}
			List<List<String>> allPerm=PermuteGen.genStrPermute(exprSeed.clone());
			for(List<String> expr:allPerm) {
				ExprTree epTree=new ExprTree();
				if(epTree.build(expr)) {
					if(epTree.evaluate()==24.0) {
						ans.add(epTree.expression());
					}
				}

			}
		}
		return ans;
	}
	
	
	

}
