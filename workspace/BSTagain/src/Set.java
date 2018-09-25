import java.util.Iterator;

//Implement the following TODO methods:
// constructor clone
// size
// empty
// erase
// find

public class Set<E> {

	BinarySearchTree<E> tree;
	SetIterator<E> setIterator;

	public Set() {
		tree = new BinarySearchTree<E>();
		setIterator = new SetIterator<E>(this, tree.root);
	}

	public SetIterator begin() {
		return setIterator;
		// return new SetIterator<E>(this, tree.root);
	}

	public SetIterator end() {
		setIterator = new SetIterator<E>(this, null);
		return setIterator; // new SetIterator<E>(this, null);
	}

	final int size() {
		// TODO Implement method size using tree.start() and tree.next()
		// count the number of nodes in the tree
		// tree.startNode();
		return 0;
	}

	final boolean empty() {
		// TODO implement boolean method empty();
		return tree.isEmpty();
	}

	void clear() {
		tree.makeEmpty();
	}

	void insert(E key) {
		if (tree.isEmpty()) {
			System.out.println("Tree is empty");
		} else {
			System.out.println("Tree is not empty");
		}
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