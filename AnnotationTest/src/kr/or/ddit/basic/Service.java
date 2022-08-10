package kr.or.ddit.basic;

public class Service {
	@PrintAnnotation()  //@PrintAnnotation(value = "-", count = 20)과 같다 default값 
	public void method1() {
		System.out.println("메서드1에서 출력되었습니다.");
	}

	@PrintAnnotation("%")   // value값만 쓸 경우에는 value 생략 가능하지만, value값과 count 값을 같이 적는 경우 생략 불가능 
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}

	@PrintAnnotation(value = "^", count = 50)
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}

	@Override
	public String toString() {
		return String.format("Service [getClass()=%s, hashCode()=%s, toString()=%s]", getClass(), hashCode(),
				super.toString());
	}
	
}
