import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class BuhuoTestJdk8 {
	public void test() {
		
//		Executors.newFixedThreadPool(nThreads) //使用的是LinkedBlockingQueue
//		Executors.newSingleThreadExecutor()    //使用的是LinkedBlockingQueue
//		Executors.newCachedThreadPool()        //使用的是SynchronousQueue,空闲时间超过60s,则销毁线程
		
		/*
		 * 无界
		 * Condition      notFull   notEmpty  
		 * ReentrantLock  putLock   takeLock
		 * 
		 * 加入   put和offer,其中offer可以设置时间
		 * 取出   take和poll,其中poll可以设置时间
		 */
//		LinkedBlockingQueue
		
		/**
		 * 
		 */
//		ReentrantLock
		
		//共享
		/**
		 * what: 信号量
		 * how: 计数,限制访问资源的线程数量(acquire和release)
		 * why: 
		 */
//		Semaphore
		
		/*
		 * CountDownLatch与CyclicBarrier的区别
		 * 
		 */
		
		
		/**
		 * JUC核心: AQS
		 * 1. state
		 * 2. FIFO队列
		 * 3. CLH队列
		 */
//		AbstractQueuedSynchronizer

		
		
		/*
		 * CLH队列锁
		 */
//		Lock
		
		/**
		 * JDK7和8的区别
		 * 
		 */
		ConcurrentHashMap
		
//		CopyOnWriteArrayList
		
//		TreeMap
	}
}
