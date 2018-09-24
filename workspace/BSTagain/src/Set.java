import java.util.Iterator;

//import BinarySearchTree.BinaryNode;

public class Set<E> {

	BinarySearchTree<E> tree;

	public Set() {
		tree = new BinarySearchTree<E>();
	}

	public SetIterator begin() {
		return new SetIterator<E>(this, tree.root);
	}

	public SetIterator end() {
		return new SetIterator<E>(this, null);
	}

	final int size() {
		// TODO Implement method size using tree.start() and tree.next()
		// count the number of nodes in the tree
		// tree.startNode();
		return 0;
	}

	final boolean empty() {
		// TODO implement boolean method empty();
		return false;
	}

	void clear() {
		tree.makeEmpty();
	}

	void insert(E key) {
		tree.insert(key);
	}

	int erase(E key) {
		tree.remove(key);
		return 0;
	}

	// Returns an interator referring to the found element
	Iterator find(E key) {
		// TODO Implement find method
		return null;
	}

	int count(E key) {
		if (tree.find(key) != null) {
			return 1;
		} else {
			return 0;
		}
	}

	BinarySearchTree.BinaryNode<E> nextNode(BinarySearchTree.BinaryNode node) {
		return tree.next(node);
	}

	// BinarySearchTree.BinaryNode nextNode(BinarySearchTree.BinaryNode node) {
	// return tree.next(node);
	// }

	private void print() {

	}
}