package algorithms;

/**
 * 红黑树
 * 
 * What:二叉查找树如果插入的数据是随机的,则效率很高,但是如果插入的数据是有序的,则效率很差。
 * 		为了实现能够快速地搜索一棵树，我们需要保证树总是平衡的（或者大部分是平衡的），即每个节点的左子树和右子树个数尽量相等。
 * 		红黑树就是一棵平衡树，对于一个要插入的数（删除也是），插入过程要检查是不是破坏了树的平衡，如果破坏了，则通过程序的纠正（改变颜色、左旋和右旋），来
 * 		重新实现树的平衡。
 * Features: 
 * 1. 每个节点不是黑色,就是红色
 * 2. 根节点是黑色
 * 3. 父子节点不能都是红色
 * 4. 任一节点到叶子节点所包含黑色节点的个数是一样的
 * 
 * 插入规则: 新插入的节点总是红色
 */
public class RedBlackTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class RedBlackTree {
	RBNode root;
	private final static boolean Red = true; 
	
	/*
	 * 左旋示意图: 对x左旋
	 * 
	 *      p                    p  
	 *     /                    / 
	 *    x                    y
	 *   / \         -->      / \  
	 *  lx  y                x   ry
	 *     / \              / \
	 *    ly  ry           lx ly
	 *    
	 *  左旋三个步骤:
	 *  1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(ly非空时)
	 *  2. 将x的父节点赋给y的父节点,并更新p的子节点为y(左子节点或右子节点)
	 *  3. 将y的左子节点设为x,x的父节点设为y
	 *  
	 */
	public void leftRotate(RBNode x) {
		//1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(ly非空时)
		RBNode y = x.right;
		x.right = y.left;
		if(y.left != null) {
			y.left.parent = x;
		}
		
		//2. 将x的父节点赋给y的父节点,并更新p的子节点为y(左子节点或右子节点)
		y.parent = x.parent;
		if(x.parent == null) {
			this.root = y;
		} else {
			if(x == x.parent.left) {
				x.parent.left = y;
			} else {
				x.parent.right = y;
			}
		}
		
		//3. 将y的左子节点设为x,x的父节点设为y
		y.left = x;
		x.parent = y;
	}
	
	/*
	 * 右旋示意图: 对y右旋
	 * 
	 *       p                    p  
	 *      /                    / 
	 *     y                    x
	 *    / \         -->      / \  
	 *   x   ry               lx  y
	 *  / \                      / \
	 * lx rx                    rx  ry
	 *    
	 *  左旋三个步骤:
	 *  1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x的右子节点非空时)
	 *  2. 将y的父节点赋给x的父节点,并更新p的子节点为x(左子节点或右子节点)
	 *  3. 将x的右子节点设为y,y的父节点设为x
	 *  
	 */
	public void rightRotate(RBNode y) {
		RBNode x = y.left;
		
		//1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x的右子节点非空时)
		y.left = x.right;
		if(x.right == null) {
			x.right.parent = y;
		}
		
		//2. 将y的父节点赋给x的父节点,并更新p的子节点为x(左子节点或右子节点)
		x.parent = y.parent;
		if(x.parent == null) {
			this.root = y;
		} else {
			if(y == y.parent.left) {
				y.parent.left = x;
			} else {
				y.parent.right = x;
			}
		}
		
		//3. 将x的右子节点设为y,y的父节点设为x
		x.right = y;
		y.parent = x;
	}
	
	public void insert(int key) {
		RBNode<int> node = new RBNode(Red, key, null, null, null);
	}
}

class RBNode<T extends Comparable<T>> {
	boolean isRed;
	T key;
	RBNode<T> left;
	RBNode<T> right;
	RBNode<T> parent;
	
	public T getKey() {
		return key;
	}
}
