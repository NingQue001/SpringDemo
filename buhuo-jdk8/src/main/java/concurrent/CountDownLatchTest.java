package concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(2);
		new Thread(() -> {
			System.out.println("�߳�" + Thread.currentThread().getName() + " ��ִ��");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�߳�" + Thread.currentThread().getName() + " ִ�н���");
			latch.countDown();
		}).start();
		
		new Thread(() -> {
			System.out.println("�߳�" + Thread.currentThread().getName() + " ��ִ��");
			try {
				Thread.sleep(2000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = 1 / 0;
			System.out.println("�߳�" + Thread.currentThread().getName() + " ִ�н���");
			latch.countDown();
		}).start();
		
		try {
			latch.await();
			System.out.println("�����߳�ִ������");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
