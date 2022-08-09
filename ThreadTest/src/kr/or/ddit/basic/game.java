package kr.or.ddit.basic;

import java.util.Random;
import javax.swing.JOptionPane;

public class game {
	public static boolean inputCheck;

	public static void main(String[] args) {
		RSP rsp = new RSP();
		CountDown3 count = new CountDown3();

		rsp.start();
		count.start();
	}
}

class RSP extends Thread {
	
	@Override
	public void run() {
		// player 
		String player = JOptionPane.showInputDialog("가위바위보");
		game.inputCheck = true;
		System.out.println("Player : " + player);
		
		
		// computer
		Random rnd = new Random();
		int rnum = rnd.nextInt(3);
		String computer = null;
		
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
		System.out.println("Computer : " + computer);
		
		
		// 결과
		System.out.println("============");
		System.out.println("결과");
		if (player.equals(computer)) {
			System.out.println("비김");
		} else if ((player.equals("가위") && computer.equals("바위"))
				|| (player.equals("바위") && computer.equals("보"))
				|| (player.equals("보") && computer.equals("가위"))) {
			System.out.println("Computer 승리");
		} else {
			System.out.println("Player 승리");
		}
	}
}

// 카운트 처리 스레드
class CountDown3 extends Thread {
	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			if (game.inputCheck == true) {
				return;
			}

			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("5초 경과. YOU LOSE.");
		System.exit(0);
	}
}
