package trees;

public class BinaryTreeNode {
	public char value;
	public BinaryTreeNode left = null;
	public BinaryTreeNode right = null;

	public boolean IsLeaf() {
		return this.left == null && this.right == null;
	}

	public void printpreorder() {
		System.out.println("this.value");
		// print left subtree
		if (this.left != null) {
			this.left.printpreorder();
		}

		// print right subtree
		if (this.right != null) {
			this.right.printpreorder();
		}
	}
	public void printinorder() {
		// print left subtree
		if (this.left != null) {
			this.left.printpreorder();
		}
		System.out.println("this.value");

		// print right subtree
		if (this.right != null) {
			this.right.printpreorder();
		}
		
	}
	public void printpostorder() {
		// print left subtree
		if (this.left != null) {
			this.left.printpreorder();
		}

		// print right subtree
		if (this.right != null) {
			this.right.printpreorder();
		}
		System.out.println("this.value");
		
	}

}
