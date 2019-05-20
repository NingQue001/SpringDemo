package algorithms;

/**
 * �����
 * 
 * What:����������������������������,��Ч�ʺܸ�,�����������������������,��Ч�ʺܲ
 * 		Ϊ��ʵ���ܹ����ٵ�����һ������������Ҫ��֤������ƽ��ģ����ߴ󲿷���ƽ��ģ�����ÿ���ڵ��������������������������ȡ�
 * 		���������һ��ƽ����������һ��Ҫ���������ɾ��Ҳ�ǣ����������Ҫ����ǲ����ƻ�������ƽ�⣬����ƻ��ˣ���ͨ������ľ������ı���ɫ������������������
 * 		����ʵ������ƽ�⡣
 * Features: 
 * 1. ÿ���ڵ㲻�Ǻ�ɫ,���Ǻ�ɫ
 * 2. ���ڵ��Ǻ�ɫ
 * 3. ���ӽڵ㲻�ܶ��Ǻ�ɫ
 * 4. ��һ�ڵ㵽Ҷ�ӽڵ���������ɫ�ڵ�ĸ�����һ����
 * 
 * �������: �²���Ľڵ����Ǻ�ɫ
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
		if(x.right == null) {
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
