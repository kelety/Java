package kr.or.ddit.basic;

public class T05GenericMethodTest {

	public static void main(String[] args) {
		int result1 = Util2.compare(10, 20);
		System.out.println(result1);
		
		int result2 = Util2.<Number>compare(3.14, 3);
		System.out.println(result2);
		
//		Util2.compare("C", "JAVA");   // Number타입으로 선언했기 때문에 String타입으로 불가능
	}
}

class Util2 {
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
	}
}