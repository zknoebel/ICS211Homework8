
/**
 * import i0 and scanner to create trees from strings
 */
import java.io.*;
import java.util.Scanner;

/**
 * 
 * BinaryTree
 *
 * @author Zachery Knoebel
 *
 * @param <E>: The tree can have any type of object in it
 */
public class BinaryTree<E> implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  protected Node<E> root;


  public BinaryTree() {
    root = null;
  }


  protected BinaryTree(Node<E> root) {
    this.root = root;
  }


  /**
   * 
   * @param data: The object to be placed in the new root node
   * @param leftTree: will be a subtree who's root is the left child of the the new root node
   * @param rightTree: will be a subtree who's root is the right child of the the new root node
   */
  public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
    root = new Node<E>(data);

    if (leftTree != null) {
      root.left = leftTree.root;
    }
    else {
      root.left = null;
    }

    if (rightTree != null) {
      root.right = rightTree.root;
    }
    else {
      root.right = null;
    }

  }

  /**
   * creates a node used to connect the parts of the tree and store the objects that are stored in the tree
   */
  protected static class Node<E> {
    protected E data;
    protected Node<E> left;
    protected Node<E> right;


    public Node(E data) {
      this.data = data;
      left = null;
      right = null;
    }


    /**
     * creates a string of the object inside the node
     */
    public String toString() {
      return data.toString();
    }

  }


  /**
   * 
   * @return: returns a subtree of the current tree who's root is the left child of the current root
   */
  public BinaryTree<E> getLeftSubtree() {
    if (root != null && root.left != null) {

      return new BinaryTree<E>(root.left);
    }
    else {
      return new BinaryTree<E>(null);
    }
  }


  /**
   * @return: returns a subtree of the current tree who's root is the right child of the current root
   */
  public BinaryTree<E> getRightSubtree() {
    if (root != null && root.right != null) {

      return new BinaryTree(root.right);
    }
    else {
      return new BinaryTree<E>(null);
    }
  }


  /**
   * 
   * @return: the data object stored in root
   */
  public E getData() {
    return (E) root.data;
  }


  /**
   * 
   * @return: true if the node has no children false if the node has one or more children
   */
  public boolean isLeaf() {
    return (root == null) || ((root.left == null) && (root.right == null));
  }


  /**
   * returns a preorder format string of the tree
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    preOrderTraverse(root, 1, sb);
    return sb.toString();
  }


  /**
   * 
   * @param node: the node who's data will be added to the string
   * @param depth: the level of the tree that the node is located on
   * @param sb: the string builder
   * 
   */
  private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
    for (int i = 1; i < depth; i++) {
      sb.append("   ");
    }

    if (node == null) {
      sb.append("null\n");
    }
    else {
      sb.append("\n");
      preOrderTraverse(node.left, depth + 1, sb);
      preOrderTraverse(node.right, depth + 1, sb);
    }
  }


  /**
   * prints the string returned by the toString() method
   */
  public void printToString() {
    System.out.print(toString());
  }


  /**
   * 
   * @return: a tree that is created from a string
   * 
   * not currently implemented
   */
  public BinaryTree<E> readBinaryTree(Scanner scan) {
    BinaryTree<E> temp = new BinaryTree<E>();
    // TODO
    return temp;
  }
}
