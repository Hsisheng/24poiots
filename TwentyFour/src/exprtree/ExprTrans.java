package exprtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExprTrans {
	
	public static List<String> trans(String[] infix) {
		List<String> ans=new ArrayList<String>();
		Stack<String> stack=new Stack<String>();
		
		for(int i=0;i<infix.length;i++) {
			String c=infix[i];
			if(isDigit(c)) ans.add(c);
			else if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")){
				if(stack.isEmpty()) {
					stack.push(c);
				}else {
					if(c.equals("+")||c.equals('-')) {
						while(!stack.isEmpty()) {
							String chr=stack.pop();
							if(chr.equals("+")||chr.equals("-")||chr.equals("*")||chr.equals("/")) {
								ans.add(chr);
							}else {
								stack.push(chr);
								break;
							}
						}
					}else {
						while(!stack.isEmpty()) {
							String chr=stack.pop();
							if(chr.equals("*")||chr.equals("/")) {
								ans.add(chr);
							}else {
								stack.push(chr);
								break;
							}
						}
					}
					stack.push(c);
				}
			}else {
				if(c.equals("(")) stack.push(c);
				else {
					while(!stack.isEmpty()) {
						String chr=stack.pop();
						if(chr.equals("(")) break;
						ans.add(chr);
					}
				}
			}
		}
		while(!stack.isEmpty()) {
			String c=stack.pop();
			if(!c.equals("("))ans.add(c);
		}
		return ans;
	}
	
	
	 private static boolean isDigit(String ch)
	    {
	        return !(ch.equals("(")||ch.equals(")")||ch.equals("+")||ch.equals("-")||ch.equals("*")||ch.equals("/"));
	    }

}
