package concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(2);
		new Thread(() -> {
			System.out.println("线程" + Thread.currentThread().getName() + " 在执行");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程" + Thread.currentThread().getName() + " 执行结束");
			latch.countDown();
		}).start();
		
		new Thread(() -> {
			System.out.println("线程" + Thread.currentThread().getName() + " 在执行");
			try {
				Thread.sleep(2000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = 1 / 0;
			System.out.println("线程" + Thread.currentThread().getName() + " 执行结束");
			latch.countDown();
		}).start();
		
		try {
			latch.await();
			System.out.println("所有线程执行完了");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
