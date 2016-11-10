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
import java.util.List;

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
	private int depth = 0;
	private List<E> levelOrderList;

	/**
	 * 
	 * @param comp: a comparator that will compare the objects placed in the nodes of the tree
	 */
	public BinarySearchTree(Comparator comp) {
		this.comp = comp;
	}


	/**
	 * starter method for Node<E> add() this method sets "root" for Node<E> add() then it returns whether or not the
	 * "item" was successfully added
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
	 * this method recursively traverses the tree to find the spot in which the new object, "item" should be added, then
	 * it creates a new node containing "item" and places this node in the previously found position in the tree
	 */
	private Node<E> add(Node<E> localRoot, E item) {
		//TODO make sure it replaces an existing item if it is a double
		if (localRoot == null) {
			addReturn = true;
			return new Node<E>(item);
		}
		else if (comp.compare(item, localRoot.data) == 0) {
			addReturn = false;
		}
		else if (comp.compare(item, localRoot.data) < 0) {
			localRoot.left = add(localRoot.left, item);
		}
		else {
			localRoot.right = add(localRoot.right, item);
		}
		return localRoot;
	}


	/**
	 * uses the find() method to determine whether or not the tree contains a node containing "item" returns true if it
	 * does and false if it does not
	 */
	@Override
	public boolean contains(E item) {
		if (find(item) == null) {
			return false;
		}
		else {
			return true;
		}
	}


	/**
	 * public starter method for the private find() method sets the value of "root" for the private find() method and then
	 * returns whatever the private method does
	 */
	@Override
	public E find(E target) {
		return (E) find(root, target);
	}


	/**
	 * 
	 * @param localRoot: the root of the tree to be searched
	 * @param target: the item to be found
	 * @return: returns the object that matches "target" unless there is not one in the tree, then it returns null
	 * 
	 * compares "localRoot" to "target" if "localRoot" = "target" returns local "root.data" if "localRoot" < "target"
	 * searches the subtree with the root "localRoot.right.data" if "localRoot" > "target" searches the subtree with the
	 * root "localRoot.left.data" if "localRoot" is null, then return null
	 */
	private E find(Node<E> localRoot, E target) {
		if (localRoot == null) {
			return null;
		}
		int compResult = comp.compare(target, localRoot.data);
		if (compResult == 0) {
			return localRoot.data;
		}
		else if (compResult < 0) {
			return find(localRoot.left, target);
		}
		else {
			return find(localRoot.right, target);
		}
	}


	/**
	 * Starter method for Node<E> delete() changes the tree to a tree with the "target" deleted then returns the data in
	 * the deleted node
	 */
	@Override
	public E delete(E target) {
		root = delete(root, target);
		return deleteReturn;
	}


	/**
	 * 
	 * @param localRoot: the root of the tree that contains the "target" to be deleted
	 * @param target: an object that matches the object to be deleted
	 * @return: the object that was removed from the tree or null if nothing matches the target
	 * 
	 * recursive checks for a "localRoot.data" that matches "target" if "localRoot.data" matches "target" remove localRoot
	 * if "localRoot.data" > "target" check the subtree of the current tree who's root is "localRoot.left" if
	 * "localRoot.data" < "target" check the subtree of the current tree who's root is "localRoot.right"
	 * 
	 * if an inner node is deleted, moves all of its children to the correct places
	 */
	private Node<E> delete(Node<E> localRoot, E target) {
		if (localRoot == null) {
			deleteReturn = null;
			return localRoot;
		}
		else {

			int compResult = comp.compare(target, localRoot.data);
			if (compResult < 0) {
				localRoot.left = delete(localRoot.left, target);
				return localRoot;
			}
			else if (compResult > 0) {
				localRoot.right = delete(localRoot.right, target);
				return localRoot;
			}
			else {
				deleteReturn = localRoot.data;
				if (localRoot.left == null) {
					return localRoot.right;
				}
				else if (localRoot.right == null) {
					return localRoot.left;
				}
				else {
					if (localRoot.left.right == null) {
						localRoot.data = localRoot.left.data;
						localRoot.left = localRoot.left.left;
						return localRoot;
					}
					else {
						localRoot.data = findLargestChild(localRoot.left);
						return localRoot;
					}
				}
			}
		}
	}


	/**
	 * 
	 * @param parent: the root of the tree to be checked
	 * @return: the largest object in the tree
	 * 
	 * this is used in the delete() method to move nodes up if an inner node is deleted
	 */
	private E findLargestChild(Node<E> parent) {
		if (parent.right.right == null) {
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		}
		else {
			return findLargestChild(parent.right);
		}
	}


	/**
	 * prints the tree to the console in a preorder format
	 */
	public void printTree() {
		System.out.println(toString());
	}


	/**
	 * @return: a string of all of the nodes of the tree concatenated in a preorder format
	 */
	public String inorderString() {
		StringBuilder sb = new StringBuilder();
		inOrderTraverse(root, sb);
		return sb.toString();
	}


	/**
	 * prints the sorted data from the tree
	 */
	public void printInorderString() {
		// TODO combine with inorderString
		System.out.println(inorderString());
	}


	/**
	 * 
	 * @param node: where the data is kept
	 * @param sb: the string builder used to put all of the strings together
	 * 
	 * uses a string builder to append all of the nodes together in an inorder format separated by "\n" to make each one
	 * come out on a separate line when the string is printed
	 */
	private void inOrderTraverse(Node<E> node, StringBuilder sb) {
		if (node != null) {
			inOrderTraverse(node.left, sb);
			sb.append(node.toString());
			sb.append("\n");
			inOrderTraverse(node.right, sb);
		}
	}


	/**
	 * turns the data in the tree into a string in preorder format
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}


	/**
	 * 
	 * @param node: the node who's data will appended to the string
	 * @param depth: the level of the current node this is used to see how many spaces should be before each data when the
	 * string is printed
	 * @param sb: the string builder that will append everything
	 * 
	 * uses a string builder to create a string of all of the data in the tree in a preorder format
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append("   ");
		}

		if (node == null) {
			sb.append("null\n");
		}
		else {
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}


	/**
	 * removes an item from the tree and then makes that node's children move to their new spots
	 * 
	 * return: false if the "target" does not exist or true if the "target" is removed
	 */
	@Override
	public boolean remove(E target) {
		if (delete(target) == null) {
			return false;
		}
		else {
			return true;
		}
	}


	@Override
	public List<E> levelOrderTraversal() {
		// TODO Auto-generated method stub

		return levelOrderList;
	}

	private void levelOrderTraversal(Node<E> localRoot){
		if(localRoot != null){
		levelOrderList.add(localRoot.data);
		
		//TODO figure this stuff out tomorrow
	}
	}

	@Override
	public int maxDepth() {
		maxDepth(root, depth);
		return depth;
	}

	private void maxDepth(Node<E> localRoot, int depth){

		depth ++;

		if(localRoot != null){
			if(this.depth < depth){
				this.depth = depth;
			}

			maxDepth(localRoot.left, depth);
			maxDepth(localRoot.right, depth);
		}	
	}
}