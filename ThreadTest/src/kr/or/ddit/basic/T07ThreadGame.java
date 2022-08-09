package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

//	컴퓨터와 가위바위보를 진행하는 프로그램
public class T07ThreadGame {
	public static boolean inputCheck;

	public static void main(String[] args) {
		PlayerInput input = new PlayerInput();
		ComputerInput inputCom = new ComputerInput();
		CountDown2 count = new CountDown2();

		input.start();
		inputCom.start();
		count.start();

		try {
			input.join();
			inputCom.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (PlayerInput.player.equals(ComputerInput.computer)) {
			System.out.println("비김");
		} else if ((PlayerInput.player.equals("가위") && ComputerInput.computer.equals("바위"))
				|| (PlayerInput.player.equals("바위") && ComputerInput.computer.equals("보"))
				|| (PlayerInput.player.equals("보") && ComputerInput.computer.equals("가위"))) {
			System.out.println("Computer 승리");
		} else {
			System.out.println("Player 승리");
		}
		
		System.out.println("===========");
		System.out.println("결과");
	}
}

// 사용자 입력 받는 스레드
class PlayerInput extends Thread {
	public static String player = null;

	@Override
	public void run() {
		player = JOptionPane.showInputDialog("가위바위보");
		T07ThreadGame.inputCheck = true;
		System.out.println("당신 : " + player);
	}
}

// 컴퓨터 난수 생성 스레드
class ComputerInput extends Thread {
	public static String computer = null;

	@Override
	public void run() {
		Random rnd = new Random();
		int rnum = rnd.nextInt(3);

		switch (rnum) {
		case 0:
			computer = "가위";
			break;
		case 1:
			computer = "바위";
			break;
		case 2:
			computer = "보";
			break;
		}
		System.out.println("컴퓨터 : " + computer);
	}
}

// 카운트다운 처리하는 스레드
class CountDown2 extends Thread {
	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			if (T07ThreadGame.inputCheck == true) {
				break;
			}

			System.out.println(i);

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("5초 경과. YOU LOSE.");
		System.exit(0);
	}
}