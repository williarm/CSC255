import java.lang.Comparable;

public class BinarySearchTree<Key extends Comparable<Key>> {

	/********************************************************************************
	 * 
	 * Start of UnderflowException class
	 *
	 */
	public static class UnderflowException extends RuntimeException {

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
	public class BinaryNode {

		Comparable element; // The data in the node
		BinaryNode parent; // Parent node
		BinaryNode left; // Left child
		BinaryNode right; // Right child

		// Constructors
		BinaryNode(Comparable theElement) {
			this(theElement, null, null);
			System.out.println("In BinaryNode constructor (single parameter)");
		}

		BinaryNode(Comparable theElement, BinaryNode lt, BinaryNode rt) {
			System.out.println("In BinaryNode  Constructor (3 parameters)");
			element = theElement;
			left = lt;
			right = rt;
		}

		public BinaryNode(final Comparable theElement, BinaryNode lt, BinaryNode rt, BinaryNode p) {
			System.out.println("In BinaryNode constructor (4 parameters)");
			element = theElement;
			parent = p;
			left = lt;
			right = rt;
			System.out.println(element);
		}

	}

	/********************************************************************************
	 * 
	 * End of BinaryNode class
	 *
	 */

	/********************************************************************************
	 * 
	 * Start of BinarySearchTree methods
	 *
	 */

	BinaryNode root;
	// Comparator<? super Comparable> cmp;

	public BinarySearchTree() {
		System.out.println("In BinarySearchTree constructor (non-parameterized)");
		root = null;
	}

	public BinarySearchTree(BinarySearchTree<Key> rhs) {
		System.out.println("In BinarySearchTree constructor (parameterized)");
		if (rhs != null) {
			root = cloneTree(rhs.root, root);
		} else {
			root = null;
		}
	}

	public void getRoot() {
		if (root != null) {
			System.out.println("Root is not null");
		} else {
			System.out.println("Root is null");
		}
	}

	private void printTree(BinaryNode t) {
		System.out.println("In BinarySearchTree.printTree (parameterized)");
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}

	public void printTree() {
		System.out.println("In BinarySearchTree.printTree (non-parameterized)");
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}

	BinarySearchTree<Key> assign(final BinarySearchTree<Key> rhs) {
		System.out.println("In BinarySearchTree.assign");
		BinarySearchTree<Key> newTree = new BinarySearchTree<Key>();
		newTree = rhs;
		return newTree;
	}

	final Key findMin() {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		return (Key) findMinNode(root).element;

	}

	final Key findMax() {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		return (Key) findMaxNode(root).element;
	}

	boolean isEmpty() {
		System.out.println("In BinarySearchTree.isEmpty");
		return root == null;
	}

	void print() {
		System.out.println("In BinarySearchTree.print");
		printTree(root);
	}

	void makeEmpty() {
		System.out.println("In BinarySearchTree.makeEmpty");
		root = makeEmptyTree(root);
	}

	void insert(final Key element) {
		System.out.println("In BinarySearchTree.insert");
		root = insertNode(element, root, null);
	}

	BinaryNode find(final Key key) {
		System.out.println("In BinarySearchTree.find");
		return findNode(key, root);
	}

	boolean remove(final Key key) {
		System.out.println("In BinarySearchTree.remove");
		return removeTreeNode(find(key));
	}

	boolean removeNode(BinaryNode node) {
		System.out.println("In BinarySearchTree.removeNode");
		return removeTreeNode(node);
	}

	BinaryNode startNode() {
		System.out.println("In BinarySearchTree.startNode");
		return mostLeftNode(root);
	}

	BinaryNode nextNode(BinaryNode t) {
		System.out.println("In BinarySearchTree.nextNode");
		if (t == null) {
			return null;
		}
		BinaryNode q = t.right;
		if (q != null) {
			q = mostLeftNode(q);
		} else {
			q = t;
			while (q != null) {
				q = q.parent;
				if (q == null || t == q.left) {
					break;
				}
				t = q;
			}
		}
		return q;
	}

	BinaryNode mostLeftNode(BinaryNode q) {
		System.out.println("In BinarySearchTree.mostLeftNode");
		if (q != null) {
			while (q.left != null) {
				System.out.println("In the loop");
				q = q.left;
			}
		}
		return q;
	}

	BinaryNode findNode(Key x, BinaryNode t) {
		System.out.println("In BinarySearchTree.findNode");
		int compareResult;
		while (t != null) {
			compareResult = x.compareTo((Key) t.element);
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

	BinaryNode insertNode(Key x, BinaryNode t, BinaryNode p) {
		System.out.println("In BinarySearchTree.insertNode method");
		if (t == null) {
			System.out.println("In BinarySearchTree.insertNode method - First IF");
			return new BinaryNode(x, null, null, p);
		}
		int compareResult = x.compareTo((Key) t.element);

		if (compareResult < 0) {
			System.out.println("In BinarySearchTree.insertNode method - Second IF");
			// System.out.println("in second if");
			return insertNode(x, t.left, t);
		}
		if (compareResult > 0) {
			System.out.println("In BinarySearchTree.insertNode method - Third IF");
			return insertNode(x, t.right, t);
		}
		// Duplicate do nothing
		System.out.println("In BinarySearchTree.insertNode method - Fourth Condition");
		return t;
	}

	void repointNodeParent(BinaryNode s, BinaryNode q) {
		System.out.println("In BinarySearchTree.repointParentNode");
		BinaryNode p = s.parent;
		if (p.left == s) {
			p.left = q;
		} else {
			p.right = q;
		}
		if (q != null) {
			q.parent = p;
		}
	}

	BinaryNode replaceTreeNode(BinaryNode u, BinaryNode m) {
		System.out.println("In BinarySearchTree.replaceTreeNode");
		if (m != null) {
			repointNodeParent(m, null);
			repointNodeParent(u, m);
		}
		return m;
	}

	boolean removeTreeNode(BinaryNode p) {
		System.out.println("In BinarySearchTree.removeTreeNode");
		if (p == null) {
			return false;
		}
		BinaryNode m = (p.left != null && p.right != null) ? replaceTreeNode(p, mostLeftNode(p.right))
				: replaceTreeNode(p, p.left != null ? p.left : p.right);
		if (root == p) {
			m = root;
		}
		return true;
	}

	BinaryNode findMinNode(BinaryNode t) {
		System.out.println("In BinarySearchTree.findMinNode");
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

	BinaryNode findMaxNode(BinaryNode t) {
		System.out.println("In BinarySearchTree.findMaxNode");
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

	boolean containsElement(Key x, BinaryNode t) {
		System.out.println("In BinarySearchTree.containsElement");
		if (t == null) {
			return false;
		}

		int compareResult = x.compareTo((Key) t.element);

		if (compareResult < 0) {
			return containsElement(x, t.left);
		}
		if (compareResult > 0) {
			return containsElement(x, t.right);
		}
		return true;
	}

	void makeEmpty(BinaryNode t) {
		System.out.println("In BinarySearchTree.makeEmpty");
		root = makeEmptyTree(root);
	}

	BinaryNode makeEmptyTree(BinaryNode t) {
		System.out.println("In BinarySearchTree.makeEmptyTree");
		if (t != null) {
			makeEmpty(t.left);
			makeEmpty(t.right);
			// t.remove();
		}
		return null;
	}

	void printTree2(BinaryNode t, String output) {
		System.out.println("In BinarySearchTree.printTree2");
		if (t != null) {
			printTree2(t.left, t.left.element.toString());
			printTree2(t.right, t.right.element.toString());
		} else {
			output = "Empty tree\n";
		}
	}

	BinaryNode cloneTree(BinaryNode t, BinaryNode p) {
		System.out.println("In BinarySearchTree.cloneTree");
		if (t == null) {
			return null;
		}

		BinaryNode node = new BinaryNode(t.element, null, null, p);

		node.left = cloneTree(t.left, node);
		node.right = cloneTree(t.right, node);

		return node;
	}

	/********************************************************************************
	 * 
	 * End of BinarySearchTree methods
	 *
	 */
}
