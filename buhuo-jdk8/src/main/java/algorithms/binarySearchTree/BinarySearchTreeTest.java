package algorithms.binarySearchTree;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

import algorithms.binarySearchTree.BinarySearchTree.Node;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(3);
		tree.insert(7);
		tree.insert(6);
		tree.insert(2);
		tree.insert(1);
		tree.insert(9);
		
		tree.inorderTraversal(tree.getRoot());
		
		Node node = tree.search(3);
		System.out.println("\nLeft : " + node.leftChild.data);
		System.out.println("Right : " + node.rightChild.data);
	}
}
