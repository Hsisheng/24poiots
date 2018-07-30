package game.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import exprtree.ExprTrans;
import exprtree.ExprTree;
import game.GameGUI;
import helpers.Generater;
import helpers.Problem;

public class TwentyFourLogic implements Logic{
	
	private Generater gen;
	private GameGUI ui;
	private Problem pro;
	
	public TwentyFourLogic(GameGUI gui,Generater gen) {
		this.ui=gui;
		this.gen=gen;
		ui.setLogic(this);
	}

	@Override
	public void start() {
		Problem p=gen.generate();
		ui.hideAns();
		ui.changeNums(p.nums);
		ui.clearInput();
		this.pro=p;
		
	}

	@Override
	public void finish() {
		ui.showAns(pro.ans);
		
	}

	@Override
	public void check(String s) {
		if(mCheck(s)) {
			
			ui.showAns(pro.ans);
		}else {
			
		}
	}
	
	public boolean mCheck(String s) {
		int kuohaoCount=0;
		List<String> temp=new ArrayList<String>();
		List<Integer> set=new ArrayList<Integer>();
		for(int myNums:pro.nums) {
			set.add(myNums);
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(isDigit(c)) {
				sb.append(c);
			}else {
				if(sb.length()>0)temp.add(sb.toString());
				sb.delete(0, sb.length());
				temp.add(String.valueOf(c));
				if(c=='(') kuohaoCount++;
				if(c==')') kuohaoCount--;
			}
		}
		
		if(!(sb.length()==0)) temp.add(sb.toString());
		
		if(kuohaoCount!=0) return false;
		
		String infix[]=new String[temp.size()];
		int i=0;
		for(String str:temp) {
			infix[i]=str;
			i++;
		}
		ExprTree ept=new ExprTree();	
	
		if(!ept.build(ExprTrans.trans(infix))) return false;
		
		//ept.showStructure();
		if(ept.evaluate()!=24.0) return false;
		System.out.println(ept.evaluate());
		return true;
		
		
	}
	
	private boolean isDigit(char ch){
        return ch>=48 && ch<=57;
    }
	
	

}
