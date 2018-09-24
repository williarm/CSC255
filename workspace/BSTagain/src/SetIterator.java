
public class SetIterator<E> {
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
}
