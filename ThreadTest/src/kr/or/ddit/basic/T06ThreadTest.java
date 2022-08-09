package kr.or.ddit.basic;

import javax.swing.JOptionPane;

//  멀티스레드를 활용한 카운트다운 처리
public class T06ThreadTest {
	// 입력 여부를 확인하기 위한 변수 선언(모든 스레드에서 공통으로 사용할 변수)
	public static boolean inputCheck = false;

	public static void main(String[] args) {
		DataInput input = new DataInput();
		CountDown count = new CountDown();
		
		input.start();
		count.start();
	}
}

// 데이터 입력을 받는 스레드 클래스
class DataInput extends Thread {
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		T06ThreadTest.inputCheck = true;
		System.out.println("입력한 값은 " + str + "입니다.");
	}
}

// 카운트다운을 처리하는 스레드 클래스
class CountDown extends Thread {
	
	public void run() {
		for (int i = 10; i >= 1; i--) {
			if(T06ThreadTest.inputCheck == true) {
				return;
			}
			
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// 10초가 경과되었는데도 입력이 없으면 프로그램을 종료한다.
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);  // 프로그램을 종료시키는 메서드
	}
}