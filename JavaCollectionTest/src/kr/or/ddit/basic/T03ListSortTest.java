package kr.or.ddit.basic;
import java.util.*;

public class T03ListSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		System.out.println("정렬 전 : " + list);
		
		/*
		 * // 정렬은 Collections.T03ListSortTest() 매서드를 이용하여 정렬한다. // 정렬은 기본적으로 오름차순정렬을
		 * 수행한다 // 정렬방식을 변경하려면 정렬방식을 결정하는 객체를 만들어서 // Collections.sort()매서드의 인수로 넘겨주면
		 * 된다.
		 */		
		Collections.sort(list); //오름차순으로 정렬하기
		System.out.println("정렬 후 : " + list);
	
		Collections.shuffle(list); //섞기
		System.out.println("섞기 후 : " + list);
		
		Collections.sort(list, new Desc());
		System.out.println("외부정렬자로 정렬 후 : " + list);
	}
}

/*
 * 정렬방식을 결정하는 class는 Comparator라는 인터페이스를 구현해야 한다
 * 이 Comparator인터페이스의 compare()라는 매서드를 재정의하여 구현하면 된다.
*/
class Desc implements Comparator<String>{
	/*
	 * compare()매서드의 반환값을 결정하는 방법
	 * => 이 매서드가 양수를 반환하면 두값의 순서가 바뀐다.(오름차순이 기본)
	 * 
	 * - 오름차순이 정렬일 경우
	 * => 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환하도록 한다
	 * 
	 * - String객체에는 정렬을 위해서 compareTo()매서드가 구현되어 있는데
	 * 이 매서드의 반환값은 오름차순에 맞게 반환되도록 구현되어 있다
	 * (Wrapper클래스와 Date, File클래스에도 구현되어 있다)
	*/	
	
	@Override
	public int compare(String str1, String str2) {
		return str1.compareTo(str2);
	}
	
}

