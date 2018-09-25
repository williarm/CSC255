import java.util.Iterator;

public class SetIterator<E> implements Iterator {
	Set<E> set;
	BinarySearchTree.BinaryNode<E> node;

	public SetIterator(Set<E> theSet, BinarySearchTree.BinaryNode theNode) {
		this.set = theSet;
		this.node = theNode;
	}

	boolean hasValue() {
		return node != null;
	}

	void advance() {
		node = set.nextNode(node);
	}

	final E getElement() {
		return node.element;
	}

	BinarySearchTree.BinaryNode<E> getNode() {
		return node;
	}

	@Override
	public boolean hasNext() {
		return hasValue();
	}

	@Override
	public E next() {
		BinarySearchTree.BinaryNode<E> currentNode = node;
		advance();
		return currentNode.element;
	}
}
