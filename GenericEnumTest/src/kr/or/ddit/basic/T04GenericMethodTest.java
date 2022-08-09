package kr.or.ddit.basic;

public class T04GenericMethodTest {

	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");
		boolean result1 = Util.<Integer, String>compare(p1, p2);
//		boolean result1 = Util.compare(p1, p2);
		if (result1) {
			System.out.println("논리(의미)적으로 동일한 객체임");
		} else {
			System.out.println("논리(의미)적으로 동일한 객체가 아님");
		}

		Pair<String, String> p3 = new Pair<String, String>("001", "고길동");
		Pair<String, String> p4 = new Pair<String, String>("001", "고길동");
		boolean result2 = Util.compare(p3, p4);
//		boolean result2 = Util.<String, String>compare(p3,p4);
		if (result2) {
			System.out.println("논리(의미)적으로 동일한 객체임");
		} else {
			System.out.println("논리(의미)적으로 동일한 객체가 아님");
		}
		
		p1.displayAll("키", 180);
	}
}

class Util {
	/*
	 * 제너릭 메서드 <T, R> R method(T t)
	 * 
	 * 파라미터 타입과 리턴타입으로 타입 파라미터(타입글자)를 가지는 메서드
	 * 
	 * 선언방법 : 리턴타입 앞에 <> 기호를 추가하고 타입글자를 기술 후 사용함.
	 */

	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());

		return keyCompare && valueCompare;
	}
}

/*
 * 멀티타입<K, V> 을 가지는 제너릭 클래스
 * 
 * @author pc14
 * 
 * @param <K>
 * 
 * @param <V>
 */
class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	// key값 
	public <K, V> void displayAll(K key, V value) {
		System.out.println(key + " : " + value);
	}
}