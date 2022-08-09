package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T15ObjectStreamTest {
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		// Member객체 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("일지매", 30, "경기");
		Member mem3 = new Member("이몽룡", 40, "강원");
		Member mem4 = new Member("성춘향", 50, "광주");

		ObjectOutputStream oos = null;

		try {
			// 객체를 파일에 저장

			// 출력용 스트림 객체 생성
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/memObj.bin")));

			// 쓰기 작업
			// 직렬화
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);

			System.out.println("쓰기 작업 완료~~");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/memObj.bin")));

			Object obj = null;

			while ((obj = ois.readObject() // 역직렬화
			) != null) {
				// 파일의 마지막에 다다르면 EOF(End Of File) Exception 발생
				// 읽어온 객체를 원래의 타입으로 변환 후 사용한다.
				Member mem = (Member) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("-------------");
			}
		} catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
			// 더이상 읽어올 객체가 없으면 예외발생.(EOF Exception)
			System.out.println("출력 작업 끝~");
		} finally {
			try {
				oos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("경과 시간(ms) : " + (endTime - startTime));
	}
}

class Member implements Serializable {
	// 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화 할 수 있도록 제한하고 있다
	// transient => 직렬화가 되지 않을 멤버변수에 지정한다.(static필드도 직렬화가 되지 않는다.)
	// 직렬화가 되지 않는 멤버변수는 기본값으로 저장된다.(참조형변수 : null, 숫자형 변수 : 0)
	transient private String name;
	private String addr;
	transient private int age;

	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
