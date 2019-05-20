package clh;

import java.util.concurrent.atomic.AtomicReference;

public class CLHLock implements Lock {
	// 尾巴，是所有线程共有的一个。所有线程进来后，把自己设置为tail 
	private final AtomicReference<QNode> tail; 
	// 前驱节点，每个线程独有一个。 
	private final ThreadLocal<QNode> myPred; 
	// 当前节点，表示自己，每个线程独有一个。 
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
		// 获取当前线程的代表节点 
		QNode node = myNode.get(); 
		// 将自己的状态设置为true表示获取锁。 
		node.locked = true;
		// 将自己放在队列的尾巴，并且返回以前的值。第一次进将获取构造函数中的那个new QNode 
		QNode pred = tail.getAndSet(node); 
	    // 把旧的节点放入前驱节点。 
		myPred.set(pred); 
	    // 判断前驱节点的状态，然后走掉。 
		while (pred.locked) {
			
		} 
		// 一开始的是，前驱节点是空的，尾巴节点只是一个引用。 
		// 当第一个线程进来，假设是线程A。A设置自己的lock为true，A把自己放入队列的尾巴。判断最初的节点lock为false，A走掉。 
		// 当第二个线程进来，假设是线程B。B设置自己的lock为true，B拿到A节点。并且把自己放入队列的尾巴、 
		// 如果第三个线程进来，拿到的是B的QNode。只要是自己不unlock。后面的线程，永远在lock==true中旋转。 
	} 

	public void unlock() { 
		QNode node = myNode.get(); 
		node.locked = false; 
		myNode.set(myPred.get()); 
	} 
	// unlock. 获取自己的node。把自己的locked设置为false
}
