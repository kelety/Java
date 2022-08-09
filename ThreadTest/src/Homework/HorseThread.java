package Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorseThread {
	public static void main(String[] args) {

		List<Horse> ths = new ArrayList<>();// 정렬을 해줘야 해서 list로 넣어줌
		ths.add(new Horse("1번마"));
		ths.add(new Horse("2번마"));
		ths.add(new Horse("3번마"));
		ths.add(new Horse("4번마"));
		ths.add(new Horse("5번마"));
		ths.add(new Horse("6번마"));
		ths.add(new Horse("7번마"));
		ths.add(new Horse("8번마"));
		ths.add(new Horse("9번마"));
		ths.add(new Horse("10번마"));

		for (Horse hs : ths) { 
			hs.start();
		}

		while (true) {// 현재 달리고 있는 위치
			for (int i = 0; i < ths.size(); i++) {// 말의 수만큼 반복
				System.out.print(ths.get(i).name + "\t");
				for (int j = 1; j <= 50; j++) {
					if (ths.get(i).place == j) {// i번째 위치가 j와 같으면
						System.out.print(">");// >로 변환
						continue;// 첫번째 for 문으로 올라감
					}
					System.out.print("-");// 나머지 - 출력
					
					if(j == 50) {
						System.out.print("\t경마중");
					} else if(j == 49) {
						System.out.print("|");
					}
				}
				System.out.println();
			}
			try {
				Thread.sleep(300); // 딜레이
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			int exitCnt = 0;// 스레드 갯수
			for (int i = 0; i < ths.size(); i++) {
				if (ths.get(i).getState() == Thread.State.TERMINATED) {// 스레드의 상태가 종료되었을때
					exitCnt++;// 스레드의 갯수 증가
				}
			}
			if (exitCnt == 10) {// 10번말이 모두 끝났을때는 끝남
				break;
			}
			System.out.println("\n=========================================================\n");
		}

		System.out.println();
		Collections.sort(ths);// 정렬한것
		System.out.println("===경기결과===");
		for (Horse h : ths) {// 리스트를 h에 넣고
			System.out.println(h);// h출력
		}
	}

}

class Horse extends Thread implements Comparable<Horse> {
	public static int setRank = 1;
	public String name;	// 이름
	public int rank;	// 순위
	public int place = 0;	// 달리는 말 현재 위치 찾기

	public Horse(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep((int) (Math.random() * 500));
				// 0~0.5초까지 칸이 랜덤으로 움직임
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (place < 50) {// 장소가 50까지 가야댐 즉, 50보다 작을때
				place++;// 증가
			}
		}
		rank = setRank++;// 1등한 다음에 등수에 넣어줌
	}

	@Override
	public int compareTo(Horse h) {
		return Integer.compare(rank, h.rank);// 비교해서 정렬
	}

	@Override
	public String toString() {
		return name + "\t: " + rank + "등 ";
	}

}