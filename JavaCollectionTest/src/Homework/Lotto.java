package Homework;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("========================");
			System.out.println("Lotto 프로그램");
			System.out.println("----------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("========================");
			System.out.print("메뉴 선택 : ");
			String menuNum = sc.next();

			switch (menuNum) {
			case "1":
				loop: while (true) {
					System.out.println(" Lotto 구입 시작 \n");
					System.out.println("(1000원에 로또번호 하나입니다.)");
					System.out.print("금액 입력 : ");
					int money = sc.nextInt();
					if (money < 1000) {
						System.out.println("1000원 이상 입력해 주세요.\n");
						break loop;
					}
					System.out.println();

					
					System.out.println("행운의 로또번호는 아래와 같습니다.");
					for (int i = 0; i < money / 1000; i++) {
						Set<Integer> lottoRnd = new HashSet<Integer>();
						while (lottoRnd.size() < 6) {
							int num = (int) (Math.random() * 45 + 1);
							lottoRnd.add(num);
						}
						System.out.println("로또번호" + (i + 1) + " : " + lottoRnd);
					}
					System.out.println();

					int change = money % 1000;
					System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + change + "원입니다.\n");
					break;
				}
				break;

			case "2":
				System.out.println("감사합니다");
				return;
			}
		}
	}
}
