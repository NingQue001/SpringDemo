import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class BuhuoTestJdk8 {
	public void test() {
		
//		Executors.newFixedThreadPool(nThreads) //ʹ�õ���LinkedBlockingQueue
//		Executors.newSingleThreadExecutor()    //ʹ�õ���LinkedBlockingQueue
//		Executors.newCachedThreadPool()        //ʹ�õ���SynchronousQueue,����ʱ�䳬��60s,�������߳�
		
		/*
		 * �޽�
		 * Condition      notFull   notEmpty  
		 * ReentrantLock  putLock   takeLock
		 * 
		 * ����   put��offer,����offer��������ʱ��
		 * ȡ��   take��poll,����poll��������ʱ��
		 */
//		LinkedBlockingQueue
		
		/**
		 * 
		 */
//		ReentrantLock
		
		//����
		/**
		 * what: �ź���
		 * how: ����,���Ʒ�����Դ���߳�����(acquire��release)
		 * why: 
		 */
//		Semaphore
		
		/*
		 * CountDownLatch��CyclicBarrier������
		 * 
		 */
		
		
		/**
		 * JUC����: AQS
		 * 1. state
		 * 2. FIFO����
		 * 3. CLH����
		 */
//		AbstractQueuedSynchronizer

		
		
		/*
		 * CLH������
		 */
//		Lock
		
		/**
		 * JDK7��8������
		 * 
		 */
		ConcurrentHashMap
		
//		CopyOnWriteArrayList
		
//		TreeMap
	}
}
