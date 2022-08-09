package kr.or.ddit.basic;
import java.util.LinkedList;

public class T02StackQueueTest {
	public static void main(String[] args) {
		LinkedList<String> stack = new LinkedList<String>();

		stack.push("홍길동");
		stack.push("일지매");
		stack.push("홍길동");
		System.out.println("현재 stack값들 : " + stack);
		
//		String data = stack.;
//		System.out.println("꺼내온 자료 : " + temp);
//		System.out.println("꺼내온 자료 : " + queue.poll);
		System.out.println("현재 stack값들 : " + stack);
	}
}
