import java.util.Comparator;

public class BinarySearchTree<E> implements SearchTree<E> {
	private Comparator<E> comp;
	protected BinarySearchNode<E> root;
	BinarySearchTree(){

	}

	/**
	 * Creates a new BinarySearchTree.
	 * @param c the comparator to use for determining order.
	 */
	public BinarySearchTree(Comparator<E> c) {
		BinarySearchNode<E> root = new BinarySearchNode<E>(null);
		comp = c;
		this.root = root;
	}

	protected class BinarySearchNode<E>{
		protected BinarySearchNode<E> left;
		protected BinarySearchNode<E> right;
		protected E data;

		BinarySearchNode(E data){
			this.data = data; 
		}
	}

	/**
	 * @return the contacts in order as a string.
	 */
	public String inorderString() {
		//TODO
		return null;
	}

	@Override
	public boolean add(E item) {
		if (root.data == null){
			root.data = item;
			return true;
		}else{
			if(comp.compare(item, root.data) == 0){
				System.out.println("Item already exists");
				return false;
			}else{
				BinarySearchNode<E> temp = new BinarySearchNode<E>(item);

				if(comp.compare(item, root.data) < 0){
					if(root.left == null){
						root.left = temp;
					}else{
						
					}
				}
			}
		}

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E find(E target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E delete(E target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(E target) {
		// TODO Auto-generated method stub
		return false;
	}
	// implement this class.
}