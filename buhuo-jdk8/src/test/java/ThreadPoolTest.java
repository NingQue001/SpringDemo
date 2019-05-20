import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService p = Executors.newFixedThreadPool(2);
		Thread bT = new Thread(() -> {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " /0");
			int k = 1 /0;
		}  );
		Thread oT = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " sleep...");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " sleep end");
		}  );
		
		p.execute(bT);
		p.execute(oT);
		p.execute(oT);
	}

}
