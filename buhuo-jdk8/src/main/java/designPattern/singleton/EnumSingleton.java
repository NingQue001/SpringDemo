package designPattern.singleton;

/*
 * 枚举
 * 天然线程安全，可防止反射生成实例 ??
 */
public enum EnumSingleton {
	INSTANCE;
	
	public void playBasketBall() {
		System.out.println("枚举: play basketBall");
	}
}
