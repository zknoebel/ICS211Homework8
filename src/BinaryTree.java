import java.io.*;
import java.util.Scanner;

public class BinaryTree<E> implements Serializable {
	protected Node<E> root;

	public BinaryTree() {
		root = null;
	}

	protected BinaryTree(Node<E> root) {
		this.root = root;
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<E>(data);

		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}

		if (rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}

	}

	protected static class Node<E> {
		protected E data;
		protected Node<E> left;
		protected Node<E> right;

		public Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}

		public String toString() {
			return data.toString();
		}

	}

	public BinaryTree<E> getLeftSubtree() {
		if (root != null && root.left != null) {

			return new BinaryTree<E>(root.left);
		} else {
			return new BinaryTree<E>(null);
		}
	}

	public BinaryTree<E> getRightSubtree() {
		if (root != null && root.right != null) {

			return new BinaryTree(root.right);
		} else {
			return new BinaryTree<E>(null);
		}
	}

	public E getData() {
		return (E) root.data;
	}

	public boolean isLeaf() {
		return (root == null) || ((root.left == null) && (root.right == null));
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}

	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append("   ");
		}

		if (node == null) {
			sb.append("null\n");
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}
	
	public void printToString(){
		System.out.print(toString());
	}

	public BinaryTree<E> readBinaryTree(Scanner scan) {
		BinaryTree<E> temp = new BinaryTree<E>();
		// TODO
		return temp;
	}
}
