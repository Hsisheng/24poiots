package exprtree;



public interface TreeNode
{
	/**
	 * Sets the element of the node
	 * @param element The data value of the node
	 */
	void setElement(String element);

	/**
	 * @return The data value of the node
	 */
	String getElement();

	/**
	 * @return a reference to the root node of the left tree.  May be null.
	 */
	TreeNode getLeft();

	/**
	 * @return a reference to the root node of the right tree.  May be null.
	 */
	TreeNode getRight();

    /**
     * Sets the left subtree to be that rooted by the given node
     * @param node  The new root of the left subtree 
     * @return The root of the left subtree
     */
    TreeNode setLeft(TreeNode node);

    /**
     * Sets the right subtree to be that rooted by the given node
     * @param node  The new root of the right subtree
     * @return The root of the right subtree
     */
    TreeNode setRight(TreeNode node);
}