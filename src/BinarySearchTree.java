/**
 * BinarySearchTree is a class that extends BinaryTree and uses the binary tree
 * structure to sort and search for objects.
 * 
 * when a new object is added it is placed in the next available node that is
 * compatible with its value. Since each node has between 0 and 2 children,
 * every level that the search moves down the tree will effectively cut the
 * group to be searched in half.
 */

/**
 * Comparator is imported so that the search tree can compare what ever type 
 * of object that it contains.
 */
import java.util.Comparator;

/**
 * 
 * BinarySearchTree
 *
 * @author Zachery Knoebel
 *
 * @param <E>
 */
public class BinarySearchTree<E> extends BinaryTree implements SearchTree<E> {
	private Comparator<E> comp;
	private boolean addReturn = false;
	private E deleteReturn;

	/**
	 * 
	 * @param comp: a comparator that will compare the objects placed in the 
	 * nodes of the tree
	 */
	public BinarySearchTree(Comparator comp) {
		this.comp = comp;
	}

	/**
	 * starter method for Node<E> add()
	 * this method sets "root" for Node<E> add()
	 * then it returns whether or not the "item" was successfully added
	 */
	@Override
	public boolean add(E item) {
		root = add(root, item);
		return addReturn;
	}

	/**
	 * 
	 * @param localRoot: the root node for the tree to be traversed
	 * @param item: the object to be added to the tree
	 * @return: returns the root of the tree after "item" has been added
	 * 
	 * this method recursively traverses the tree to find the spot in which
	 * the new object, "item" should be added, then it  creates a new node
	 * containing "item" and places this node in the previously found 
	 * position in the tree
	 */
	private Node<E> add(Node<E> localRoot, E item) {
		if (localRoot == null) {
			addReturn = true;
			return new Node<E>(item);
		} else if (comp.compare(item, localRoot.data) == 0) {
			addReturn = false;
		} else if (comp.compare(item, localRoot.data) < 0) {
			localRoot.left = add(localRoot.left, item);
		} else {
			localRoot.right = add(localRoot.right, item);
		}
		return localRoot;
	}

	/**
	 * uses the find() method to determine whether or not the tree contains 
	 * a node containing "item"
	 * returns true if it does and false if it does not
	 */
	@Override
	public boolean contains(E item) {
		if (find(item) == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * public starter method for the private find() method
	 * sets the value of "root" for the private find() method and then 
	 * returns whatever the private method does
	 */
	@Override
	public E find(E target) {
		return (E) find(root, target);
	}

	/**
	 * 
	 * @param localRoot: the root on the tree to be searched
	 * @param target: the item to be found
	 * @return: returns the node containing the item to be found, if 
	 * the item is not in the tree then it returns null
	 * 
	 * compares "localRoot" to "target"
	 * if "localRoot" = "target" returns local root
	 * if "localRoot" < "target" searches the subtree with the root "localRoot.right"
	 * if "localRoot" > "target" searches the subtree with the root "localRoot.left"
	 * if "localRoot" is null, then return null
	 */
	private E find(Node<E> localRoot, E target) {
		if (localRoot == null) {
			return null;
		}
		int compResult = comp.compare(target, localRoot.data);
		if (compResult == 0) {
			return localRoot.data;
		} else if (compResult < 0) {
			return find(localRoot.left, target);
		} else {
			return find(localRoot.right, target);
		}
	}

	@Override
	public E delete(E target) {
		root = delete(root, target);
		return deleteReturn;
	}

	private Node<E> delete(Node<E> localRoot, E target) {
		if (localRoot == null) {
			deleteReturn = null;
			return localRoot;
		} else {

			int compResult = comp.compare(target, localRoot.data);
			if (compResult < 0) {
				localRoot.left = delete(localRoot.left, target);
				return localRoot;
			} else if (compResult > 0) {
				localRoot.right = delete(localRoot.right, target);
				return localRoot;
			} else {
				deleteReturn = localRoot.data;
				if (localRoot.left == null) {
					return localRoot.right;
				} else if (localRoot.right == null) {
					return localRoot.left;
				} else {
					if (localRoot.left.right == null) {
						localRoot.data = localRoot.left.data;
						localRoot.left = localRoot.left.left;
						return localRoot;
					} else {
						localRoot.data = findLargestChild(localRoot.left);
						return localRoot;
					}
				}
			}
		}
	}

	private E findLargestChild(Node<E> parent) {
		if (parent.right.right == null) {
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		} else {
			return findLargestChild(parent.right);
		}
	}

	public void printTree() {
		System.out.println(toString());
	}

	public String inorderString() {
		StringBuilder sb = new StringBuilder();
		inOrderTraverse(root, sb);
		return sb.toString();
	}

	public void printInorderString() {
		System.out.println(inorderString());
	}

	private void inOrderTraverse(Node<E> node, StringBuilder sb) {
		if (node != null) {
			inOrderTraverse(node.left, sb);
			sb.append(node.toString());
			sb.append("\n");
			inOrderTraverse(node.right, sb);
		}
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
		} else {
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}

	@Override
	public boolean remove(E target) {
		if (delete(target) == null) {
			return false;
		} else {
			return true;
		}
	}
}