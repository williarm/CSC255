import java.util.Iterator;

public class Set<E> {
	BinarySearchTree<E> tree;

	public Set(Set<E> rhs) {

	}

	public SetIterator begin() {
		return null;
	}

	int size() {
		// TODO Implement method size using tree.start() and tree.next()
		// count the number of nodes in the tree
		return 0;
	}

	boolean empty() {
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
		return (tree.remove(key) ? 1 : 0);
	}

	Iterator find(E key) {
		// TODO Implement find method
		return null;
	}

	int count(E key) {
		return tree.find(key) ? 1 : 0;
	}
	
	BinarySearchTree.BinaryNode nextNode(BinarySearchTree.BinaryNode node) {
		return tree.next(node);
	}
	
	private void print() {
		
	}
}