package kr.or.ddit.basic;

public class T03GenericTest {
	/*
	 *제너릭 클래스를 만드는 방법
	 *
	 * 형식)
	 * 	class 클래스명<제너릭타입글자> {
	 * 		제너릭타입 글자 변수명;	// 변수선언에 제너릭을 사용하는 경우
	 * 		...
	 * 		제너릭타입글자 메서드명() { // 반환값이 있는 메서드에서 사용
	 * 			...
	 * 			return 값;
	 * 		}
	 * 		...
	 *  }
	 *  
	 *  -- 제너릭타입글자 --
	 *  T => Type
	 *  K => Key
	 *  V => Value
	 *  E => Element(자료구조에 들어가는 것들을 나타낼 떄 사용)
	*/	
	
	
	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		
		String rtnVal1 = (String) ng1.getVal();
		System.out.println("문자열 반환값 => " + rtnVal1);

		Integer irtnVal2 = (Integer) ng2.getVal();
		System.out.println("정수 반환값 => " + irtnVal2);
		System.out.println("----------------------------");
		System.out.println();
		
		
		MyGeneric<String> mg1 = new MyGeneric<String>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		rtnVal1 = mg1.getVal();
		irtnVal2 = mg2.getVal();
		
		System.out.println("제너릭 문자열 반환값 : " + rtnVal1);
		System.out.println("제너릭 정수형 반환값 : " + irtnVal2);
	}
}

class NonGenericClass{
	private Object val;
	
	public void setVal(Object val) {
		this.val = val;
	}

	public Object getVal() {
		return this.val;
	}
}

class MyGeneric<T>{
	private T val;
	
	public void setVal(T val) {
		this.val = val;
	}

	public T getVal() {
		return this.val;
	}
}
