import java.util.Iterator;

class SetIterator<Key> implements Iterator {
	private final Set<Key> set;
	private BinarySearchTree.BinaryNode node;

	public SetIterator(final Set<Key> theSet, BinarySearchTree.BinaryNode theNode) {
		System.out.println("In SetIterator constructor");
		this.set = theSet;
		this.node = theNode;
	}

	public boolean hasValue() {
		System.out.println("In SetIterator.hasValue");
		return node != null;
	}

	public void advance() {
		System.out.println("In SetIterator.advance");
		node = set.nextNode(node);
	}

	public final Key getElement() {
		System.out.println("In SetIterator.getElement");
		return (Key) node.element;
	}

	public BinarySearchTree.BinaryNode getNode() {
		System.out.println("In SetIterator.getNode");
		return (BinarySearchTree.BinaryNode) node;
	}

	@Override
	public boolean hasNext() {
		System.out.println("In SetIterator.hasNext");
		return hasValue();
	}

	@Override
	public Key next() {
		System.out.println("In SetIterator.next");
		BinarySearchTree.BinaryNode currentNode = node;
		advance();
		return (Key) currentNode.element;
	}
}
