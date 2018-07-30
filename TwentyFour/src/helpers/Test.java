package helpers;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		Verifier v=new BasicVerifier();
		List<String> ans=v.getAnswers(new int[] {12,12,12,11});
		for(String s:ans) {
			System.out.println(s);
		}

		System.out.println("共有解法： "+ans.size());
	}

}
