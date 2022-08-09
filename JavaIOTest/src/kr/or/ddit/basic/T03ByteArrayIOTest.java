package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class T03ByteArrayIOTest {
	public static void main(String[] args) {
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		// 직접 복사하기
		outSrc = new byte[inSrc.length];  // 배열 공간 확보
		for(int i=0;i<inSrc.length;i++) {
			outSrc[i] = inSrc[i];
		}
		System.out.println("직접 복사하기");
		System.out.println("직접 복사 후 outSrc => " + Arrays.toString(outSrc));
		System.out.println();

	
		// arraycopy를 이용한 배열 복사방법
		outSrc = new byte[inSrc.length];	// 배열 공간 확보
		System.out.println("arraycopy를 이용한 배열 복사");
		System.arraycopy(inSrc, 0, outSrc, 0 , inSrc.length);
		System.out.println("직접 복사 후 outSrc => " + Arrays.toString(outSrc));
		System.out.println();
		
		
		// 스트림 객체 생성하기
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int data; // 읽어온 바이트 데이터를 저장할 변수
		
		// read() 메서드 => byte 단위로 자룔르 읽어와 int형으로 반환한다. 더이상 읽어올 자료가 없으면 -1을 반환한다.
		while((data = bais.read())!= -1) {
			baos.write(data);  // 출력하기
		}
		
		// 출력된 스트림 값들을 배열로 변환해서 반환하는 메서드
		outSrc = baos.toByteArray();
		
		System.out.println("inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
	}
}
