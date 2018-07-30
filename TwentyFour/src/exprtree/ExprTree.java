package exprtree;
//--------------------------------------------------------------------
//
//  Laboratory 11                                       ExprTree.jshl
//
//  (Shell) Class definitions for the linked implementation of the
//  Expression Tree ADT -- including the recursive partners of the
//  public methods
//
//  The student is to complete all missing or incomplete method 
//     implementations for this class
//
//--------------------------------------------------------------------

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import helpers.BasicVerifier;



public class ExprTree implements Cloneable 
{
    // Data member
    private TreeNode root;       // Reference to the root node

    // Constructor
    public ExprTree ( )          
    {                   
    		
    	
    }
    
   
    public boolean build (List<String> expr )  // Build tree from prefix expression
    {             
    		
    		Stack<ExprTreeNode> nodeStack=new Stack<ExprTreeNode>();
    		
    		for(int i=0;i<expr.size();i++) {
    			String c=expr.get(i);

    				
				if(isDigit(c)) {
					nodeStack.push(new ExprTreeNode(c,null,null));
    			}

    			else {
    				ExprTreeNode left=null;
    				ExprTreeNode right=null;
    				try {
    					left=nodeStack.pop();
    					right=nodeStack.pop();
    				}catch(Exception e) {
    					
    				}
    				
    				ExprTreeNode opNode=new ExprTreeNode(c,left,right);
    				nodeStack.push(opNode);
    			}
    		}
    		if(nodeStack.size()==1) {
    			this.root=nodeStack.pop();
    			return true;
    		}
    		return false;
    	
    	
    }
    public String expression ( )               // Output expression in infix form
    {
    	StringBuffer sb=new StringBuffer();
    	infix(root,sb);
    	sb.deleteCharAt(0);
    	sb.deleteCharAt(sb.length()-1);
    	return sb.toString();
    	
    	
    }
    private void infix(TreeNode ptr,StringBuffer sb)
    {
        if (ptr != null)
        {
        	
    		if(!isDigit(ptr.getElement())) {
    			sb.append('(');
    		}
    		infix(ptr.getRight(),sb);
            sb.append(ptr.getElement());
            infix(ptr.getLeft(),sb);
            if(!isDigit(ptr.getElement())) {
            	sb.append(')');
    		}
            
        }

    }
    public float evaluate ( )                // Evaluate expression   
    {                   
    		if(this.root==null)
    			return 0;
    		return calculate(root);
    		
    }
    private float calculate(TreeNode ptr) {
    		if (ptr.getLeft() == null && ptr.getRight() == null)
            return toDigit(ptr.getElement());
        else
        {
            float result = (float) 0.0;
            float left = calculate(ptr.getLeft());
            float right = calculate(ptr.getRight());
            String operator = ptr.getElement();
            
            if(operator.equals("+")) result = left + right;
            if(operator.equals("-")) result = right - left;
            if(operator.equals("*")) result = left * right;
            if(operator.equals("/")) result = right / left;

           
            return result;
        }
    }
    private float toDigit(String ch)
    {
    		return Integer.parseInt(ch);
    	
        
    }
    
    public void clear ( )                    // Clear tree
    {
    		remove(root);
    		root=null;
    		
    	
    }
    
    private void remove(TreeNode node) {
    		if(null!=node) {
    			remove(node.getLeft());
        		remove(node.getRight());
        		node.setLeft(null);
        		node.setRight(null);
    		}
    		
    }
    
    
    private boolean isDigit(String ch){
        return !(ch.equals("+")||ch.equals("-")||ch.equals("*")||ch.equals("/"));
    }

    public void showStructure ( )
    {
        if ( root == null )
            System.out.println("Empty tree");
        else
        {
            System.out.println( );
            showSub(root, 1);
            System.out.println( );
        }
    }

  

    private void showSub ( TreeNode p, int level )
    {
        int j;                                     
        TreeNode right,
                 left;                                  

        if ( p != null )
        {
            right = p.getRight( );
            left = p.getLeft( );
            
            showSub(right, level+1);                // Output right subtree
            for ( j = 0 ; j < level ; j++ )         // Tab over to level
                System.out.print("\t");
            System.out.print(" " + p.getElement( ));// Output element
            if ( ( left != null ) &&                // Output "connector"
                 ( right != null ) )
                System.out.print("<");
            else if ( right != null )
                System.out.print("/");
            else if ( left != null )
                System.out.print("\\");
            System.out.println( );
            showSub(left, level+1);                 // Output left subtree
        }
    }
   
    
    public void commute() {
    		exchange(root);
    }
    private void exchange(TreeNode node) {
    		if(node!=null) {
    			TreeNode temp=node.getLeft();
    			node.setLeft(node.getRight());
    			node.setRight(temp);
    			exchange(node.getLeft());
    			exchange(node.getRight());
    		}
    }

   
        
} 