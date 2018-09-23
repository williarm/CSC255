
public class SetIterator<Key> {
	Set<Key> set;
	BinarySearchTree.BinaryNode<Key> node;

	public SetIterator(Set<Key> theSet, BinarySearchTree.BinaryNode theNode) {
		set = theSet;
		node = theNode;
	}

	boolean hasValue() {
		return node != null;
	}
}
