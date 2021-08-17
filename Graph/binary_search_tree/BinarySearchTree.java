/**
 * Binary Search Tree
 * 
 * Output : 
 * 20 30 40 50 60 70 80 
 * After deleting 20
 * 30 40 50 60 70 80 
 * After deleting 30
 * 40 50 60 70 80 
 * After deleting 50
 * 40 60 70 80 
 */

package binary_search_tree;

class Node {
	int val;
	Node left, right;

	Node(int v) {
		val = v;
		left = right = null;
	}
}

public class BinarySearchTree {
	private static Node root;

	private static Node insert(Node node, int value) {
		if (node == null) {
			node = new Node(value);
			return node;
		}
		if (value < node.val)
			node.left = insert(node.left, value);
		else
			node.right = insert(node.right, value);
		return node;
	}

	private static Node findSuccessor(Node node) {
		if (node.left == null)
			return node;
		return findSuccessor(node.left);
	}

	private static Node delete(Node node, int value) {
		if (node == null)
			return null;

		if (node.val == value) {
			if (node.left == null && node.right == null) {
				return null;
			}
			if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			} else {
				Node succ = findSuccessor(node.right);
				node.val = succ.val;
				node.right = delete(node.right, succ.val);
			}
		} else {
			node.left = delete(node.left, value);
			node.right = delete(node.right, value);
		}

		return node;
	}

	private static void printTree(Node node) {
		if (node == null)
			return;

		printTree(node.left);
		System.out.print(node.val + " ");
		printTree(node.right);
	}

	public static void main(String[] args) {
		root = insert(root, 50);
		root = insert(root, 30);
		root = insert(root, 20);
		root = insert(root, 40);
		root = insert(root, 70);
		root = insert(root, 60);
		root = insert(root, 80);

		// change();
		printTree(root);
		System.out.println();

		delete(root, 20);
		System.out.println("After deleting 20");
		printTree(root);
		System.out.println();

		delete(root, 30);
		System.out.println("After deleting 30");
		printTree(root);
		System.out.println();

		delete(root, 50);
		System.out.println("After deleting 50");
		printTree(root);
		System.out.println();
	}

}
