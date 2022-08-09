package kr.or.ddit.basic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T08MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();

		// 자료 추가 => put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");

		System.out.println("map => " + map);

		// 자료 수정 => 데이터를 저장할 떄 key값이 같으면 나중에 입력한 값이 저장된다.
		// => put(수정할key값, 새로운value값)
		map.put("addr", "서울");
		System.out.println("map => " + map);

		// 자료 삭제 ==> remove(삭제할key값)
		map.remove("name");
		System.out.println("map => " + map);

		// 자료 읽기 => get(key값)
		System.out.println("addr = " + map.get("addr"));
		System.out.println();

		// key값들을 읽어와 자료를 출력하는 방법

		// 방법 1 => keySet()메서드 이용하기
		// keySet()메서드 => Map의 key값들만 읽어와 Set형으로 반환한다.
		Set<String> keySet = map.keySet();

		System.out.println("Iterator를 이용한 방법");
		Iterator<String> it = keySet.iterator();

		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("---------------------------------------");

		// 방법 2 => Set형의 데이터를 '향상된 for문'으로 처리하는 방법
		System.out.println("향상된 for문을 이용한 방법");
		for (String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println();

		// 방법 3 => value값만 읽어와 출력하기 => values() 이용하기
		System.out.println("values()를 이용한 방법");
		for (String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("---------------------------------------");

		// 방법 4 => Map관련 클래스에는 Map.Entry타입의 내부 클래스가 만들어져 있다.
		// 이 내부 클래스는 key와 value라는 멤버변수로 구성되어 있다.
		// Map에서 이 Map.Entry타입의 객체들을 Set형으로 저장하여 관리한다.

		// Map.Entry타입의 객체 모두 가져오기 => entrySet() 이용하기
		Set<Map.Entry<String, String>> entrySet = map.entrySet();

		// 가져온 Entry객체들을 순서대로 처리하기 위해서 Iterator객체 이용
		Iterator<Map.Entry<String, String>> entryIt = entrySet.iterator();

		while (entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			System.out.println("key값 : " + entry.getKey());
			System.out.println("value값 : " + entry.getValue());
			System.out.println();
		}
	}
}
