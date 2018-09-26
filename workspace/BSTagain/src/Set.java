import java.util.*;

public class Set<Key> {

	public BinarySearchTree tree; // each set element is represented by one tree node

	public SetIterator begin() {
		System.out.println("In Set.begin");
		return new SetIterator(this, tree.startNode());
	}

	public SetIterator end() {
		System.out.println("In Set.end");
		return new SetIterator(this, null);
		// return setIterator; // new SetIterator<E>(this, null);
	}

	public Set() {
		System.out.println("In Set constructor (non parameterized)");
		tree = new BinarySearchTree();
	}

	public Set(final BinarySearchTree rhs) {
		System.out.println("In Set constructor (parameterized)");
		if (rhs != null)
			tree = rhs;
		else
			tree = null;
	}

	/** 
	* Returns number of elements in the set
	*/
	public final int size() {
		System.out.println("In Set.size");
		int size = 0;
		while (tree.nextNode(tree.startNode()) != null) {
			size++;
		}
		// TODO Implement method size using tree.startNode() and tree.next()
		// count the number of nodes in the tree
		// tree.startNode();
		return size;
	}

	/**
	*  Returns true if there are no elements in the set
	*/
	public final boolean empty() {
		System.out.println("In Set.empty");
		return tree.isEmpty();
	}

	/** 
	* Remove all elements from the set
	*/
	public void clear() {
		System.out.println("In Set.clear");
		tree.makeEmpty();
	}

	/**
	* Inserts new element in the set
	*/
	public void insert(final Key key) {
		System.out.println("In Set.insert");
		tree.insert((Comparable) key);
	}

	/**
	* Removes one element from the set
	*/
	public int erase(final Key key) {
		System.out.println("In Set.erase");
		return tree.remove((Comparable) key) ? 1 : 0;
	}

	/**
	* Remove element that the iterator refers to
	*/
	public int erase(final SetIterator iter) {
		return tree.remove((Comparable) iter.getElement()) ? 1 : 0;
	}

	/**
	* Returns an iterator referring to the found element
	*/
	public final Iterator find(final Key key) {
		System.out.println("In Set.fine");
		// TODO Implement find method
		return null;
	}

	/** 
	* Returns number of times some element occurs in the set
	*/
	public final int count(final Key key) {
		System.out.println("In Set.count");
		return tree.find((Comparable) key) != null ? 1 : 0;
	}

	public BinarySearchTree.BinaryNode nextNode(BinarySearchTree.BinaryNode node) {
		System.out.println("In Set.nextNode");
		return tree.nextNode(node);
	}

	private void print() {
		System.out.println("In Set.print");

	}
}