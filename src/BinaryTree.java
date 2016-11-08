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

	protected class Node<E> {
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
		BinaryTree<E> temp = new BinaryTree(root.left);

		return temp;
	}

	public BinaryTree<E> getRightSubtree() {
		BinaryTree<E> temp = new BinaryTree(root.right);

		return temp;
	}

	public E getData() {
		return (E) root.data;
	}

	public boolean isLeaf() {
		return ((root.left == null) && (root.right == null));
	}

	public String toString() {
		String temp = null;
		return temp;
	}

	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		// TODO
	}

	public BinaryTree<E> readBinaryTree(Scanner scan) {
		BinaryTree<E> temp = new BinaryTree<E>();
		// TODO
		return temp;
	}
}
