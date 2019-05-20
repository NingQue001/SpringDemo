package locks;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
				System.out.println("���߳� park start! "+System.currentTimeMillis());
				LockSupport.park();
				System.out.println("���߳� unpark "+System.currentTimeMillis());
			}
		);
		
		thread.start();
		
		Thread.sleep(3*1000);
		System.out.println("���߳� unpark start!");
		LockSupport.unpark(thread);
	}
}
