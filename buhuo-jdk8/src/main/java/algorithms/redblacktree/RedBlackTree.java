package algorithms.redblacktree;

public class RedBlackTree<T extends Comparable<T>> {

	private RBNode<T> root; //���ڵ�
	private static final boolean RED = false; //����������־
	private static final boolean BLACK = true;
	
	public RedBlackTree() {
		root = null;
	}
	
	public RBNode<T> parentOf(RBNode<T> node) { //��ø��ڵ�
		return node != null? node.parent : null;
	}
	
	public void setParent(RBNode<T> node, RBNode<T> parent) { //���ø��ڵ�
		if(node != null) 
			node.parent = parent;
	}
	
	public boolean colorOf(RBNode<T> node) { //��ýڵ����ɫ
		return node != null? node.color : BLACK;
	}
	
	public boolean isRed(RBNode<T> node) { //�жϽڵ����ɫ
		return (node != null)&&(node.color == RED)? true : false;
	}
	
	public boolean isBlack(RBNode<T> node) {
		return !isRed(node);
	}
	
	public void setRed(RBNode<T> node) { //���ýڵ����ɫ
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
	
	//�ڲ��ࣺ�ڵ���
	public class RBNode<T extends Comparable<T>> {
		boolean color; //��ɫ
		T key; //�ؼ���(��ֵ)
		RBNode<T> left; //���ӽڵ�
		RBNode<T> right; //���ӽڵ�
		RBNode<T> parent; //���ڵ�
		
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
	 * ����ʾ��ͼ: ��x����
	 * 
	 *      p                    p  
	 *     /                    / 
	 *    x                    y
	 *   / \         -->      / \  
	 *  lx  y                x   ry
	 *     / \              / \
	 *    ly  ry           lx ly
	 *    
	 *  ������������:
	 *  1. ��y�����ӽڵ㸳��x�����ӽڵ�,����x����y���ӽڵ�ĸ��ڵ�(ly�ǿ�ʱ)
	 *  2. ��x�ĸ��ڵ㸳��y�ĸ��ڵ�,������p���ӽڵ�Ϊy(���ӽڵ�����ӽڵ�)
	 *  3. ��y�����ӽڵ���Ϊx,x�ĸ��ڵ���Ϊy
	 *  
	 */
	public void leftRotate(RBNode x) {
		//1. ��y�����ӽڵ㸳��x�����ӽڵ�,����x����y���ӽڵ�ĸ��ڵ�(ly�ǿ�ʱ)
		RBNode y = x.right;
		x.right = y.left;
		if(y.left != null) {
			y.left.parent = x;
		}
		
		//2. ��x�ĸ��ڵ㸳��y�ĸ��ڵ�,������p���ӽڵ�Ϊy(���ӽڵ�����ӽڵ�)
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
		
		//3. ��y�����ӽڵ���Ϊx,x�ĸ��ڵ���Ϊy
		y.left = x;
		x.parent = y;
	}
	
	/*
	 * ����ʾ��ͼ: ��y����
	 * 
	 *       p                    p  
	 *      /                    / 
	 *     y                    x
	 *    / \         -->      / \  
	 *   x   ry               lx  y
	 *  / \                      / \
	 * lx rx                    rx  ry
	 *    
	 *  ������������:
	 *  1. ��x�����ӽڵ㸳��y�����ӽڵ�,����y����x���ӽڵ�ĸ��ڵ�(x�����ӽڵ�ǿ�ʱ)
	 *  2. ��y�ĸ��ڵ㸳��x�ĸ��ڵ�,������p���ӽڵ�Ϊx(���ӽڵ�����ӽڵ�)
	 *  3. ��x�����ӽڵ���Ϊy,y�ĸ��ڵ���Ϊx
	 *  
	 */
	public void rightRotate(RBNode y) {
		RBNode x = y.left;
		
		//1. ��x�����ӽڵ㸳��y�����ӽڵ�,����y����x���ӽڵ�ĸ��ڵ�(x�����ӽڵ�ǿ�ʱ)
		y.left = x.right;
		if(x.right != null) {
			x.right.parent = y;
		}
		
		//2. ��y�ĸ��ڵ㸳��x�ĸ��ڵ�,������p���ӽڵ�Ϊx(���ӽڵ�����ӽڵ�)
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
		
		//3. ��x�����ӽڵ���Ϊy,y�ĸ��ڵ���Ϊx
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
		RBNode<T> current = null; //��ʾ���node�ĸ��ڵ�
		RBNode<T> x = this.root; //������������
		
		//1. �ҵ�����λ��
		while(x != null) {
			current = x;
			int cmp = node.key.compareTo(x.key);
			if(cmp < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		
		node.parent = current; //�ҵ��˲����λ��,������current��Ϊnode�ĸ��ڵ�
		
		//2. �ж�node����ڵ㻹���ҽڵ�
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
		
		//3. ���������
		insertFixUp(node);
	}
	
	/*
	 * ����ǵ�һ�β��룬����ԭ��Ϊ�գ�����ֻ��Υ����-�����Ĺ���2������ֻҪ�Ѹ��ڵ�Ϳ�ڼ��ɣ��������ڵ�ĸ��ڵ��Ǻ�ɫ�ģ��ǲ���Υ����-�����Ĺ���ʲôҲ����Ҫ����
	 * ������������������������Ǿ�Ҫ��ʼ��ɫ����ת�ˣ�
����     * 1. ����ڵ�ĸ��ڵ��������ڵ㣨�游�ڵ����һ���ӽڵ㣩��Ϊ��ɫ��
	 *    ����: ����ǰ�ڵ�ĸ��ڵ������ڵ�Ϳ�ڣ����游�ڵ�Ϳ�죬�ٽ���ǰ�ڵ�ָ�����游�ڵ�
	 * 2. ����ڵ�ĸ��ڵ��Ǻ�ɫ�ģ�����ڵ��Ǻ�ɫ�ģ��Ҳ���ڵ����丸�ڵ�����ӽڵ㡣
	 *    ����: ����ǰ�ڵ�ĸ��ڵ���Ϊ�µĽڵ㣬���µĵ�ǰ�ڵ�Ϊ֧������������
	 * 3. ����ڵ�ĸ��ڵ��Ǻ�ɫ�ģ�����ڵ��Ǻ�ɫ�ģ��Ҳ���ڵ����丸�ڵ�����ӽڵ㡣
	 *    ����: ����ǰ�ڵ�ĸ��ڵ�Ϳ�ڣ����游�ڵ�Ϳ�죬���游�ڵ�Ϊ֧�����������������Ѹ��ڵ�Ϳ��
	 */
	public void insertFixUp(RBNode<T> node) {
		RBNode<T> parent, gparent; //���ڵ���游�ڵ�
		
		//��Ҫ����������: ���ڵ����,�Ҹ��ڵ����ɫ�Ǻ�ɫ
		while(((parent = parentOf(node)) != null) && isRed(parent)) {
			gparent = parentOf(parent); //����游�ڵ�
			
			//�����ڵ����游�ڵ�����ӽڵ�,�����else�෴
			if(parent == gparent.left) {
				RBNode<T> uncle = gparent.right; //�������ڵ�
				
				//case1: ����ڵ�Ҳ�Ǻ�ɫ
				if(uncle != null && isRed(uncle)) {
					setBlack(parent);//�����ڵ������ڵ�Ϳ��
					setBlack(uncle);
					
					setRed(gparent);//���游�ڵ�Ϳ��
					
					node = gparent;
					continue;//����whileѭ��,�����ж�
				}
				
				//case2:����ڵ��Ǻ�ɫ��,�ҵ�ǰ�ڵ������ӽڵ�
				if(node == parent.right) {
					leftRotate(parent);//�Ը��ڵ���Ϊ֧������
					
					RBNode<T> tmp = parent;//���ڵ�͵�ǰ�ڵ����,Ϊ�����������׼��
					parent = node;
					node = tmp;
				}
				
				//case3: ����ڵ��Ǻ�ɫ��,�ҵ�ǰ�ڵ������ӽڵ�
				setBlack(parent);
				setRed(gparent);
				rightRotate(gparent);
			} else { //�����ڵ����游�ڵ���ҽڵ�,��������ȫ�෴,������һ����
				RBNode<T> uncle = gparent.left; //�������ڵ�
				
				//case1: ����ڵ�Ҳ�Ǻ�ɫ
				if(uncle != null && isRed(uncle)) {
					setBlack(parent);//�����ڵ������ڵ�Ϳ��
					setBlack(uncle);
					
					setRed(gparent);//���游�ڵ�Ϳ��
					
					node = gparent;
					continue;//����whileѭ��,�����ж�
				}
				
				//case2:����ڵ��Ǻ�ɫ��,�ҵ�ǰ�ڵ������ӽڵ�
				if(node == parent.left) {
					rightRotate (parent);//�Ը��ڵ���Ϊ֧������
					
					RBNode<T> tmp = parent;//���ڵ�͵�ǰ�ڵ����,Ϊ�����������׼��
					parent = node;
					node = tmp;
				}
				
				//case3: ����ڵ��Ǻ�ɫ��,�ҵ�ǰ�ڵ������ӽڵ�
				setBlack(parent);
				setRed(gparent);
				leftRotate(gparent);
			}
			
			
		}
		
		//���ø��ڵ�Ϊ��ɫ
		setBlack(this.root);
	}
	
	/******************* ��ӡ����� *********************/
	public void print() {
		if(root != null) {
			print(root, root.key, 0);
		}
	}
	/*
	 * key---�ڵ�ļ�ֵ
	 * direction--- 0:��ʾ�ýڵ��Ǹ��ڵ�
	 *              1:��ʾ�ýڵ������ĸ��ڵ�����ӽڵ�
	 *              2:��ʾ�ýڵ������ĸ��ڵ�����ӽڵ�
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
