package designPattern.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumSingleton es = EnumSingleton.INSTANCE;
		
		es.playBasketBall();
		
		LazySingleton ls = LazySingleton.getInstance();
		ls.playBasketBall();
		
		HungrySingleton hs = HungrySingleton.getInstance();
		hs.playBasketBall();
	}

}
