package locks;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
				System.out.println("子线程 park start! "+System.currentTimeMillis());
				LockSupport.park();
				System.out.println("子线程 unpark "+System.currentTimeMillis());
			}
		);
		
		thread.start();
		
		Thread.sleep(3*1000);
		System.out.println("主线程 unpark start!");
		LockSupport.unpark(thread);
	}
}
