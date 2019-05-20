package designPattern.singleton;

public class LazySingleton {
	private LazySingleton() {}
	
	//必须加volatile
	private volatile static LazySingleton instance;
	
	//获取实例方法必须是静态方法
	public static LazySingleton getInstance() {
        if (instance == null) {
            // 加锁
            synchronized (LazySingleton.class) {
                // 这一次判断也是必须的，不然会有并发问题
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
	
	public void playBasketBall() {
		System.out.println("懒汉: play basketBall");
	}
}
