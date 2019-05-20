package designPattern.singleton;

public class HungrySingleton {
	private HungrySingleton() {}
	
	private static HungrySingleton instance = new HungrySingleton();
	
	//��ȡʵ�����������Ǿ�̬����
	public static HungrySingleton getInstance() {
		return instance;
	}
	
	public void playBasketBall() {
		System.out.println("����: play basketBall");
	}
}
