import java.util.*;
public class LowestCommonAncestor {
	static int a , b;
	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		a = 5;
		b = 7;
		
		System.out.println(findAnc(root).val);
	}
	
	private static Node findAnc(Node root) {
		if(root == null)
			return null;

//		System.out.println(root.val);
		if(root.val == a || root.val == b)
			return root;
		Node left = findAnc(root.left);
		Node right = findAnc(root.right);
		if(left == null && right == null)
			return null;
		
		if(left != null && right != null)
			return root;
		
		return (left == null) ? right : left;
	}
	
}

class Node{
	int val;
	Node left, right;
	Node(int val){
		this.val = val;
	}
}
