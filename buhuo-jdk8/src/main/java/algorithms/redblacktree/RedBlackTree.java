package algorithms.redblacktree;

public class RedBlackTree<T extends Comparable<T>> {

	private RBNode<T> root; //根节点
	private static final boolean RED = false; //定义红黑树标志
	private static final boolean BLACK = true;
	
	public RedBlackTree() {
		root = null;
	}
	
	public RBNode<T> parentOf(RBNode<T> node) { //获得父节点
		return node != null? node.parent : null;
	}
	
	public void setParent(RBNode<T> node, RBNode<T> parent) { //设置父节点
		if(node != null) 
			node.parent = parent;
	}
	
	public boolean colorOf(RBNode<T> node) { //获得节点的颜色
		return node != null? node.color : BLACK;
	}
	
	public boolean isRed(RBNode<T> node) { //判断节点的颜色
		return (node != null)&&(node.color == RED)? true : false;
	}
	
	public boolean isBlack(RBNode<T> node) {
		return !isRed(node);
	}
	
	public void setRed(RBNode<T> node) { //设置节点的颜色
		if(node != null) 
			node.color = RED;
	}
	
	public void setBlack(RBNode<T> node) {
		if(node != null) {
			node.color = BLACK;
		}
	}
	 
	public void setColor(RBNode<T> node, boolean color) {
		if(node != null)
			node.color = color;
	}
	
	//内部类：节点类
	public class RBNode<T extends Comparable<T>> {
		boolean color; //颜色
		T key; //关键字(键值)
		RBNode<T> left; //左子节点
		RBNode<T> right; //右子节点
		RBNode<T> parent; //父节点
		
		public RBNode(T key, boolean color, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
			this.key = key;
			this.color = color;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
		public T getKey() {
			return key;
		}
		
		public String toString() {
			return "" + key + (this.color == RED? "R" : "B");
		}
	}
	
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
		if(x.right != null) {
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
	
	public void insert(T key) {
		RBNode<T> node = new RBNode<T>(key, RED, null, null, null);
		if(node != null) {
			insert(node);
		}
	}
	
	public void insert(RBNode<T> node) {
		RBNode<T> current = null; //表示最后node的父节点
		RBNode<T> x = this.root; //用来向下搜索
		
		//1. 找到插入位置
		while(x != null) {
			current = x;
			int cmp = node.key.compareTo(x.key);
			if(cmp < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		
		node.parent = current; //找到了插入的位置,将当期current做为node的父节点
		
		//2. 判断node是左节点还是右节点
		if(current != null) {
			int cmp = node.key.compareTo(current.key);
			if(cmp < 0) {
				current.left = node;
			} else {
				current.right = node;
			}
		} else {
			this.root = node;
		}
		
		//3. 修正红黑树
		insertFixUp(node);
	}
	
	/*
	 * 如果是第一次插入，由于原树为空，所以只会违反红-黑树的规则2，所以只要把根节点涂黑即可；如果插入节点的父节点是黑色的，那不会违背红-黑树的规则，什么也不需要做；
	 * 但是遇到如下三种情况，我们就要开始变色和旋转了：
　　     * 1. 插入节点的父节点和其叔叔节点（祖父节点的另一个子节点）均为红色。
	 *    操作: 将当前节点的父节点和叔叔节点涂黑，将祖父节点涂红，再将当前节点指向其祖父节点
	 * 2. 插入节点的父节点是红色的，叔叔节点是黑色的，且插入节点是其父节点的右子节点。
	 *    操作: 将当前节点的父节点作为新的节点，以新的当前节点为支点做左旋操作
	 * 3. 插入节点的父节点是红色的，叔叔节点是黑色的，且插入节点是其父节点的左子节点。
	 *    操作: 将当前节点的父节点涂黑，将祖父节点涂红，在祖父节点为支点做右旋操作。最后把根节点涂黑
	 */
	public void insertFixUp(RBNode<T> node) {
		RBNode<T> parent, gparent; //父节点和祖父节点
		
		//需要修正的条件: 父节点存在,且父节点的颜色是红色
		while(((parent = parentOf(node)) != null) && isRed(parent)) {
			gparent = parentOf(parent); //获得祖父节点
			
			//若父节点是祖父节点的左子节点,下面的else相反
			if(parent == gparent.left) {
				RBNode<T> uncle = gparent.right; //获得叔叔节点
				
				//case1: 叔叔节点也是红色
				if(uncle != null && isRed(uncle)) {
					setBlack(parent);//将父节点和叔叔节点涂黑
					setBlack(uncle);
					
					setRed(gparent);//将祖父节点涂红
					
					node = gparent;
					continue;//继续while循环,重新判断
				}
				
				//case2:叔叔节点是黑色的,且当前节点是右子节点
				if(node == parent.right) {
					leftRotate(parent);//以父节点作为支点左旋
					
					RBNode<T> tmp = parent;//父节点和当前节点调换,为下面的右旋做准备
					parent = node;
					node = tmp;
				}
				
				//case3: 叔叔节点是黑色的,且当前节点是左子节点
				setBlack(parent);
				setRed(gparent);
				rightRotate(gparent);
			} else { //若父节点是祖父节点的右节点,与上面完全相反,本质是一样的
				RBNode<T> uncle = gparent.left; //获得叔叔节点
				
				//case1: 叔叔节点也是红色
				if(uncle != null && isRed(uncle)) {
					setBlack(parent);//将父节点和叔叔节点涂黑
					setBlack(uncle);
					
					setRed(gparent);//将祖父节点涂红
					
					node = gparent;
					continue;//继续while循环,重新判断
				}
				
				//case2:叔叔节点是黑色的,且当前节点是右子节点
				if(node == parent.left) {
					rightRotate (parent);//以父节点作为支点左旋
					
					RBNode<T> tmp = parent;//父节点和当前节点调换,为下面的右旋做准备
					parent = node;
					node = tmp;
				}
				
				//case3: 叔叔节点是黑色的,且当前节点是左子节点
				setBlack(parent);
				setRed(gparent);
				leftRotate(gparent);
			}
			
			
		}
		
		//设置根节点为黑色
		setBlack(this.root);
	}
	
	/******************* 打印红黑树 *********************/
	public void print() {
		if(root != null) {
			print(root, root.key, 0);
		}
	}
	/*
	 * key---节点的键值
	 * direction--- 0:表示该节点是根节点
	 *              1:表示该节点是它的父节点的左子节点
	 *              2:表示该节点是它的父节点的右子节点
	 */
	private void print(RBNode<T> tree, T key, int direction) {
		if(tree != null) {
			if(0 == direction) 
				System.out.printf("%2d(B) is root\n", tree.key);
			else
				System.out.printf("%2d(%s) is %2d's %6s child\n", 
						tree.key, isRed(tree)?"R":"b", key, direction == 1?"right":"left");
			print(tree.left, tree.key, -1);
			print(tree.right, tree.key, 1);
		}
	}

}
