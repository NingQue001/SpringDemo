package clh;

import java.util.concurrent.atomic.AtomicReference;

public class CLHLock implements Lock {
	// β�ͣ��������̹߳��е�һ���������߳̽����󣬰��Լ�����Ϊtail 
	private final AtomicReference<QNode> tail; 
	// ǰ���ڵ㣬ÿ���̶߳���һ���� 
	private final ThreadLocal<QNode> myPred; 
	// ��ǰ�ڵ㣬��ʾ�Լ���ÿ���̶߳���һ���� 
	private final ThreadLocal<QNode> myNode; 

	public CLHLock() { 
		tail = new AtomicReference<QNode>(new QNode()); 
		myNode = new ThreadLocal<QNode>() { 
			protected QNode initialValue() { 
				return new QNode(); 
			} 
		}; 
	    myPred = new ThreadLocal<QNode>(); 
	} 

	public void lock() {
		// ��ȡ��ǰ�̵߳Ĵ���ڵ� 
		QNode node = myNode.get(); 
		// ���Լ���״̬����Ϊtrue��ʾ��ȡ���� 
		node.locked = true;
		// ���Լ����ڶ��е�β�ͣ����ҷ�����ǰ��ֵ����һ�ν�����ȡ���캯���е��Ǹ�new QNode 
		QNode pred = tail.getAndSet(node); 
	    // �ѾɵĽڵ����ǰ���ڵ㡣 
		myPred.set(pred); 
	    // �ж�ǰ���ڵ��״̬��Ȼ���ߵ��� 
		while (pred.locked) {
			
		} 
		// һ��ʼ���ǣ�ǰ���ڵ��ǿյģ�β�ͽڵ�ֻ��һ�����á� 
		// ����һ���߳̽������������߳�A��A�����Լ���lockΪtrue��A���Լ�������е�β�͡��ж�����Ľڵ�lockΪfalse��A�ߵ��� 
		// ���ڶ����߳̽������������߳�B��B�����Լ���lockΪtrue��B�õ�A�ڵ㡣���Ұ��Լ�������е�β�͡� 
		// ����������߳̽������õ�����B��QNode��ֻҪ���Լ���unlock��������̣߳���Զ��lock==true����ת�� 
	} 

	public void unlock() { 
		QNode node = myNode.get(); 
		node.locked = false; 
		myNode.set(myPred.get()); 
	} 
	// unlock. ��ȡ�Լ���node�����Լ���locked����Ϊfalse
}
