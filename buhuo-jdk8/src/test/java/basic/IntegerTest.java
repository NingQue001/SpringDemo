package basic;

public class IntegerTest {

	public static void main(String[] args) {
		Integer a = 1;
		Integer b = new Integer(1);
		Integer c = Integer.valueOf(1);
		
		System.out.println(a==b); //expect false
		System.out.println(a==c); //expect true
	}

}
