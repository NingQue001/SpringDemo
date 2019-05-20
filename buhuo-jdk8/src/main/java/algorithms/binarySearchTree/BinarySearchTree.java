package algorithms.binarySearchTree;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 二叉查找树,又叫二叉排序树
 * feature:
 * 1. 左边节点比父节点小,右边节点比父节点大
 * 
 *           ⑤
 *         /   \
 *        ④     ⑥
 *       /       \
 *      ②         ⑨
 *               /
 *              ⑧
 * 中序遍历即可排序: [2, 4, 5, 6, 8, 9]
 *
 */
public class BinarySearchTree {
	
	private Node root;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public boolean insert(int data) {
		Node newNode = new Node(data);
		
		if(root == null) {
			root = newNode;
			return true;
		} else {
			Node current = root;
			Node parent;
			while(current != null) {
				parent = current;
				if(current.data > data) { //往左遍历
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = newNode;
						return true;
					}
				} else if(current.data < data) { //往右遍历
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	
	public Node search(int data) {
		if(root == null) {
			return null;
		} else {
			Node current = root;
			while(current != null) {
				if(current.data == data) {
					return current;
				} else if(current.data > data) { //遍历左子树
					current = current.leftChild;
				} else if(current.data < data) {
					current = current.rightChild;
				}
			}
		}
		
		return null;
	}
	
	/*
	 * Inorder Traversal(LDR, Left-Data-Right)
	 */
	public void inorderTraversal(Node root) {
		if(root != null) {
			inorderTraversal(root.leftChild);
			System.out.print(root.data + " ");
			inorderTraversal(root.rightChild);
		}
	}
	
	static final class Node {
		int data;
		Node leftChild;
		Node rightChild;
				
		public Node(int data) {
			this.data = data;
		}
	}

}
