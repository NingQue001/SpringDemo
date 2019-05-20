package designPattern.singleton;

public class LazySingleton {
	private LazySingleton() {}
	
	//�����volatile
	private volatile static LazySingleton instance;
	
	//��ȡʵ�����������Ǿ�̬����
	public static LazySingleton getInstance() {
        if (instance == null) {
            // ����
            synchronized (LazySingleton.class) {
                // ��һ���ж�Ҳ�Ǳ���ģ���Ȼ���в�������
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
	
	public void playBasketBall() {
		System.out.println("����: play basketBall");
	}
}
