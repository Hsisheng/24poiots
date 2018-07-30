package exprtree;


class ExprTreeNode implements TreeNode
// Facilitator class for the ExprTree and LogiTree class
{
    // Data members
    private String element;      // Expression tree element
    private TreeNode left,     // Reference to the left child
                     right;    // Reference to the right child
 

    // Constructor
    public ExprTreeNode ( String elem,
                          TreeNode leftPtr, TreeNode rightPtr )
    {                   
    		this.setElement(elem);
    		this.setLeft(leftPtr);
    		this.setRight(rightPtr);    	
    }


	@Override
	public void setElement(String element) {
		this.element=element;
		
	}
	

	@Override
	public String getElement() {
		return element;
	}


	@Override
	public TreeNode getLeft() {
		return left;
	}


	@Override
	public TreeNode getRight() {
		return right;
	}


	@Override
	public TreeNode setLeft(TreeNode node) {
		this.left=node;
		return left;
	}


	@Override
	public TreeNode setRight(TreeNode node) {
		this.right=node;
		return right;
	}

    // Class Methods used by client class
    //--- Insert method implementations for the interface TreeNode here ---//

} // class ExprTreeNode

