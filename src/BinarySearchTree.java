import java.util.Comparator;

public class BinarySearchTree<E> extends BinaryTree implements SearchTree<E> {
	private Comparator<E> comp;
	private boolean addReturn = false;
	private E deleteReturn;

	public BinarySearchTree(Comparator comp) {
		this.comp = comp;
	}

	@Override
	public boolean add(E item) {
		root = add(root, item);
		return addReturn;
	}

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

	@Override
	public boolean contains(E item) {
		if (find(item) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public E find(E target) {
		return (E) find(root, target);
	}

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

	private E findLargestChild(Node<E> parent){
		if(parent.right.right == null){
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		}
		else{
			return findLargestChild(parent.right);
		}
	}

	public void printTree(){
		System.out.println(toString());
	}
	
	public String inorderString(){
		StringBuilder sb = new StringBuilder();
		inOrderTraverse(root, sb);
		return sb.toString();
	}
	
	public void printInorderString(){
		System.out.println(inorderString());
	}
	
	private void inOrderTraverse(Node<E> node, StringBuilder sb){
		if(node != null){
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