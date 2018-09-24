import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<E> {

	/********************************************************************************
	 * 
	 * Start of BinarySearchTree methods
	 *
	 */

	BinaryNode<E> root;
	Comparator<? super E> cmp;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(E x) {
		root = insert(x, root);
	}

	public void remove(E x) {
		root = remove(x, root);
	}

	public E findMin() {
		if (isEmpty())
			throw new UnderflowException();
		return findMin(root).element;
	}

	public E findMax() {
		if (isEmpty())
			throw new UnderflowException();
		return findMax(root).element;
	}

	public boolean contains(E x) {
		return contains(x, root);
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void printTree() {
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}

	private int myCompare(E lhs, E rhs) {
		if (cmp != null)
			return cmp.compare(lhs, rhs);
		else
			return ((Comparable) lhs).compareTo(rhs);
	}

	private BinaryNode<E> insert(E x, BinaryNode<E> t) {
		if (t == null)
			return new BinaryNode<>(x, null, null);

		int compareResult = myCompare(x, t.element);

		if (compareResult < 0)
			t.left = insert(x, t.left);
		else if (compareResult > 0)
			t.right = insert(x, t.right);
		else
			; // Duplicate; do nothing
		return t;
	}

	private BinaryNode<E> remove(E x, BinaryNode<E> t) {
		if (t == null)
			return t; // Item not found; do nothing

		int compareResult = myCompare(x, t.element);

		if (compareResult < 0)
			t.left = remove(x, t.left);
		else if (compareResult > 0)
			t.right = remove(x, t.right);
		else if (t.left != null && t.right != null) // Two children
		{
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		} else
			t = (t.left != null) ? t.left : t.right;
		return t;
	}

	private BinaryNode<E> findMin(BinaryNode<E> t) {
		if (t == null)
			return null;
		else if (t.left == null)
			return t;
		return findMin(t.left);
	}

	private BinaryNode<E> findMax(BinaryNode<E> t) {
		if (t != null)
			while (t.right != null)
				t = t.right;

		return t;
	}

	private boolean contains(E x, BinaryNode<E> t) {
		if (t == null)
			return false;

		int compareResult = myCompare(x, t.element);

		if (compareResult < 0)
			return contains(x, t.left);
		else if (compareResult > 0)
			return contains(x, t.right);
		else
			return true; // Match
	}

	private void printTree(BinaryNode<E> t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}

	private int height(BinaryNode<E> t) {
		if (t == null)
			return -1;
		else
			return 1 + Math.max(height(t.left), height(t.right));
	}

	// nextNode
	// mostLeftNode
	// findNode

	// start custom methods

	BinaryNode<E> findNode(E x, BinaryNode<E> t) {
		int compareResult = myCompare(x, t.element);
		while (t != null) {
			if (compareResult < 0) {
				t = t.left;
			} else if (compareResult > 0) {
				t = t.right;
			} else {
				return t;
			}
		}
		return null;

	}

	BinaryNode<E> find(E element) {
		return findNode(element, root);
	}

	BinaryNode startNode() {
		return mostLeftNode(root);
	}

	public BinaryNode<E> next(BinaryNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	BinaryNode<E> mostLeftNode(BinaryNode q) {
		if (q.left != null) {
			while (q.left.hasNext()) {
				System.out.println("In the loop");
				q = q.left;
			}
		}
		return q.left;
	}

	// end custom methods

	/********************************************************************************
	 * 
	 * End of BinarySearchTree methods
	 *
	 */

	/********************************************************************************
	 * 
	 * Start of UnderflowException class
	 *
	 */
	private static class UnderflowException extends RuntimeException {

		UnderflowException(String message) {
			super(message);
		}

		UnderflowException() {
			super();
		}

	}

	/********************************************************************************
	 * 
	 * End of UnderflowException class
	 *
	 */

	/********************************************************************************
	 * 
	 * Start of BinaryNode class
	 *
	 */
	public static class BinaryNode<E> implements Iterator {
		// Constructors
		BinaryNode(E theElement) {
			this(theElement, null, null);
		}

		BinaryNode(E theElement, BinaryNode<E> lt, BinaryNode<E> rt) {
			element = theElement;
			left = lt;
			right = rt;
		}

		E element; // The data in the node
		BinaryNode<E> left; // Left child
		BinaryNode<E> right; // Right child

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	/********************************************************************************
	 * 
	 * End of BinaryNode class
	 *
	 */

}
