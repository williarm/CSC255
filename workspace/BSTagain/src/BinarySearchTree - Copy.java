import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<Comparable> {

	/********************************************************************************
	 * 
	 * Start of BinaryNode class
	 *
	 */
	public static class BinaryNode<E> {
		// Constructors
		BinaryNode(E theElement) {
			this(theElement, null, null);
		}

		BinaryNode(E theElement, BinaryNode<E> lt, BinaryNode<E> rt) {
			element = theElement;
			left = lt;
			right = rt;
		}

		public BinaryNode(E theElement, BinaryNode<E> lt, BinaryNode<E> rt, BinaryNode<E> p) {
			element = theElement;
			parent = p;
			left = lt;
			right = rt;
		}

		E element; // The data in the node
		BinaryNode<E> parent; // Parent node
		BinaryNode<E> left; // Left child
		BinaryNode<E> right; // Right child

//		// @Override
//		public boolean hasNext() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		@Override
//		public Object next() {
//			// TODO Auto-generated method stub
//			return null;
//		}
	}

	/********************************************************************************
	 * 
	 * End of BinaryNode class
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
	 * Start of BinarySearchTree methods
	 *
	 */

	BinaryNode<E> root;
	Comparator<? super E> cmp;

	public BinarySearchTree() {
		root = null;
	}

	public BinarySearchTree(BinarySearchTree<E> rhs) {
		if (rhs != null) {
			root = cloneTree(rhs.root, root);
		} else {
			root = null;
		}
	}

	private void printTree(BinaryNode<E> t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
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

	private int height(BinaryNode<E> t) {
		if (t == null)
			return -1;
		else
			return 1 + Math.max(height(t.left), height(t.right));
	}

	BinarySearchTree<E> assign(BinarySearchTree<E> rhs) {
		BinarySearchTree<E> newTree = new BinarySearchTree();
		newTree = rhs;
		return newTree;
	}

	boolean isEmpty() {
		return root == null;
	}

	void print() {
		printTree(root);
	}

	void makeEmpty() {
		root = makeEmptyTree(root);
	}

	void insert(E element) {
		root = insertNode(element, root, null);
	}

	BinaryNode<E> find(E element) {
		return findNode(element, root);
	}

	boolean remove(E element) {
		return removeTreeNode(find(element));
	}

	boolean removeNode(BinaryNode<E> node) {
		return removeTreeNode(node);
	}

	BinaryNode<E> startNode() {
		return mostLeftNode(root);
	}

	BinaryNode<E> nextNode(BinaryNode<E> t) {
		if (t == null) {
			return null;
		}
		BinaryNode<E> q = t.right;
		if (q.right.hasNext()) {
			q = mostLeftNode(q);
		} else {
			q = t;
			while (q.hasNext()) {
				q = q.parent;
				if (q == null || t == q.left) {
					break;
				}
				t = q;
			}
		}
		return q;
	}

	BinaryNode<E> mostLeftNode(BinaryNode<E> q) {
		if (q.left != null) {
			while (q.left.hasNext()) {
				System.out.println("In the loop");
				q = q.left;
			}
		}
		return q.left;
	}

	BinaryNode<E> findNode(E x, BinaryNode<E> t) {
		int compareResult;
		while (t != null) {
			compareResult = myCompare(x, t.element);
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

	BinaryNode<E> insertNode(E x, BinaryNode<E> t, BinaryNode<E> p) {
		if (t == null) {
			return new BinaryNode<E>(x, null, null, p);
		}
		int compareResult = myCompare(x, t.element);
		if (compareResult < 0) {
			return insertNode(x, t.left, t);
		}
		if (compareResult > 0) {
			return insertNode(x, t.right, t);
		}
		// Duplicate do nothing
		return t;
	}

	void repointNodeParent(BinaryNode<E> s, BinaryNode<E> q) {
		BinaryNode<E> p = s.parent;
		if (p.left == s) {
			p.left = q;
		} else {
			p.right = q;
		}
		if (q != null) {
			q.parent = p;
		}
	}

	BinaryNode<E> replaceTreeNode(BinaryNode<E> u, BinaryNode<E> m) {
		if (m != null) {
			repointNodeParent(m, null);
			repointNodeParent(u, m);
		}
		return m;
	}

	boolean removeTreeNode(BinaryNode<E> p) {
		if (p == null) {
			return false;
		}
		BinaryNode<E> m = (p.left.hasNext() && p.right.hasNext()) ? replaceTreeNode(p, mostLeftNode(p.right))
				: replaceTreeNode(p, p.left.hasNext() ? p.left : p.right);
		if (root == p) {
			m = root;
		}
		return true;
	}

	BinaryNode<E> findMinNode(BinaryNode<E> t) {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		if (t == null) {
			return null;
		}
		if (t.left == null) {
			return t;
		}
		return findMinNode(t.left);
	}

	BinaryNode<E> findMaxNode(BinaryNode<E> t) {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		if (t != null) {
			while (t.right != null) {
				t = t.right;
			}
		}
		return t;
	}

	boolean containsElement(E x, BinaryNode<E> t) {
		if (t == null) {
			return false;
		}

		int compareResult = myCompare(x, t.element);

		if (compareResult < 0) {
			return containsElement(x, t.left);
		}
		if (compareResult > 0) {
			return containsElement(x, t.right);
		}
		return true;
	}

	void makeEmpty2(BinaryNode<E> t) {
		root = makeEmptyTree(root);
	}

	BinaryNode<E> makeEmptyTree(BinaryNode<E> t) {
		if (t != null) {
			makeEmpty2(t.left);
			makeEmpty2(t.right);
			t.remove();
		}
		return null;
	}

	void printTree2(BinaryNode<E> t, String output) {
		if (t != null) {
			printTree2(t.left, t.left.element.toString());
			printTree2(t.right, t.right.element.toString());
		} else {
			output = "Empty tree\n";
		}
	}

	BinaryNode<E> cloneTree(BinaryNode<E> t, BinaryNode<E> p) {
		if (t == null) {
			return null;
		}

		BinaryNode<E> node = new BinaryNode<E>(t.element, null, null, p);

		node.left = cloneTree(t.left, node);
		node.right = cloneTree(t.right, node);

		return node;
	}

	/********************************************************************************
	 * 
	 * End of BinarySearchTree methods
	 *
	 */

	// old methods

	// public void insert(E x) {
	// root = insert(x, root);
	// }

	// public void remove(E x) {
	// root = remove(x, root);
	// }

	// public E findMin() {
	// if (isEmpty())
	// throw new UnderflowException();
	// return findMin(root).element;
	// }

	// public E findMax() {
	// if (isEmpty())
	// throw new UnderflowException();
	// return findMax(root).element;
	// }

	// public boolean contains(E x) {
	// return contains(x, root);
	// }

	// public void makeEmpty() {
	// root = null;
	// }

	// public boolean isEmpty() {
	// return root == null;
	// }

	// private BinaryNode<E> insert(E x, BinaryNode<E> t) {
	// if (t == null)
	// return new BinaryNode<>(x, null, null);
	//
	// int compareResult = myCompare(x, t.element);
	//
	// if (compareResult < 0)
	// t.left = insert(x, t.left);
	// else if (compareResult > 0)
	// t.right = insert(x, t.right);
	// else
	// ; // Duplicate; do nothing
	// return t;
	// }

	// private BinaryNode<E> remove(E x, BinaryNode<E> t) {
	// if (t == null) {
	// return t; // Item not found; do nothing
	// }
	// int compareResult = myCompare(x, t.element);
	//
	// if (compareResult < 0)
	// t.left = remove(x, t.left);
	// else if (compareResult > 0)
	// t.right = remove(x, t.right);
	// else if (t.left != null && t.right != null) // Two children
	// {
	// t.element = findMin(t.right).element;
	// t.right = remove(t.element, t.right);
	// } else
	// t = (t.left != null) ? t.left : t.right;
	// return t;
	// }

	// private BinaryNode<E> findMin(BinaryNode<E> t) {
	// if (t == null)
	// return null;
	// else if (t.left == null)
	// return t;
	// return findMin(t.left);
	// }
	//
	// private BinaryNode<E> findMax(BinaryNode<E> t) {
	// if (t != null)
	// while (t.right != null)
	// t = t.right;
	//
	// return t;
	// }

	// private boolean contains(E x, BinaryNode<E> t) {
	// if (t == null)
	// return false;
	//
	// int compareResult = myCompare(x, t.element);
	//
	// if (compareResult < 0)
	// return contains(x, t.left);
	// else if (compareResult > 0)
	// return contains(x, t.right);
	// else
	// return true; // Match
	// }

}
