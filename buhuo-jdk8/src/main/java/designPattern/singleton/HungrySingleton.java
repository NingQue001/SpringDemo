package designPattern.singleton;

public class HungrySingleton {
	private HungrySingleton() {}
	
	private static HungrySingleton instance = new HungrySingleton();
	
	//获取实例方法必须是静态方法
	public static HungrySingleton getInstance() {
		return instance;
	}
	
	public void playBasketBall() {
		System.out.println("饿汉: play basketBall");
	}
}
