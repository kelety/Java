package kr.or.ddit.basic;
import java.util.*;

public class T01ArrayListTest {

	public static void main(String[] args) {
		List list1 = new ArrayList();
		
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		list1.add('k');
		list1.add(true);
		list1.add(12.34);
		
		System.out.println("size => " + list1.size());
		System.out.println("list1 => " + list1);
		System.out.println("=================");
		
		System.out.println("1번쨰 자료 : " + list1.get(1));
		System.out.println("=================");
		
		list1.add(0, "zzz");
		System.out.println("list1 => " + list1);
		System.out.println("=================");
		
		String temp = (String)list1.set(0, "YYY");
		System.out.println("temp => " + temp);
		System.out.println("list1 => " + list1);
		System.out.println("=================");
		
		list1.remove(0);
		System.out.println("삭제후 : " + list1);
		System.out.println("=================");
		
		list1.remove("bbb");
		System.out.println("bbb삭제후 => " + list1);
		System.out.println("=================");

		
		List<String> list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i+ " : " + list2.get(i));
		}
		
		for(String s : list2) {
			System.out.println(s);
		}
		
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));
		
		System.out.println("DDD의 index값 : " + list2.indexOf("DDD"));
		System.out.println("ZZZ의 index값 : " + list2.indexOf("ZZZ"));
		
		
		Object[] strArr = list2.toArray();
		System.out.println("배열의 개수 : " + strArr.length);
		
		String[] strArr2 = list2.toArray(new String[0]);
		System.out.println("strArr2의 개수 : " + strArr2.length);
		
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i+ " : " + list2.get(i));
			list2.remove(list2.get(i));
		}
		System.out.println();
		
		System.out.println(list2.size());
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i+ " : " + list2.get(i));
		}
		
		
	}

}
