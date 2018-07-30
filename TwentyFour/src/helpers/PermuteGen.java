package helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteGen {
	
	private static char[] ops=new char[] {'+','-','*','/'};
	
	
	
	/**
	 * 加减乘除选n个 可重复选 所有选法
	 * @param n
	 * @return
	 */
	public static List<List<Character>> genOpPermute(int n){
		ArrayList<Character> tempList=new ArrayList<Character>();
		List<List<Character>> ans=new ArrayList<List<Character>>();
		opBacktrack(n,tempList,ans,new HashSet<Integer>());
		return ans;
	}
	
	private static void opBacktrack(int n,ArrayList<Character> tempList,List<List<Character>> ans,HashSet<Integer> set) {
		if(tempList.size()==n) {
			int i=1;
			for(char c:tempList) {
				i*=c;
			}
			if(!set.contains(i)) {
				ans.add(new ArrayList<Character>(tempList));
				set.add(i);
			}
		}else {
			for(int i=0;i<4;i++) {
				tempList.add(ops[i]);
				opBacktrack(n,tempList,ans,set);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	/**
	 * 输出n个String的全排列
	 * @param n
	 * @return
	 */
	public static List<List<String>> genStrPermute(String[] strs){
		ArrayList<String> tempList=new ArrayList<String>();
		List<List<String>> ans=new ArrayList<List<String>>();
		Arrays.sort(strs);
		strBacktrack(strs,tempList,ans,new boolean[strs.length]);
		return ans;
	}
	
	private static void strBacktrack(String[] strs,ArrayList<String> tempList,List<List<String>> ans,boolean[] used) {
		if(tempList.size()==strs.length) {
			ans.add(new ArrayList<String>(tempList));
		}else {
			for(int i=0;i<strs.length;i++) {
				if(!(used[i] || i>0 && strs[i].equals(strs[i-1]) && !used[i-1])) {
					tempList.add(strs[i]);
					used[i]=true;
					strBacktrack(strs,tempList,ans,used);
					tempList.remove(tempList.size()-1);
					used[i]=false;;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		List<List<String>> ans=genStrPermute(new String[] {"9","8","2","8","+","+","+"});
		System.out.println(ans.size());
		for(List<String> list:ans) {
			for(String i:list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
