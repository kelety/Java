package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {

	public static void main(String[] args) {
		new Hotel().hotelStart();

		File file = new File("d:/D_Other/Hotel.txt");
		System.out.println(file.getName() + " 파일 생성 완료");

		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream("d:/D_Other/Hotel.txt");
			int data = 0;
			while ((data = fis.read()) != -1) {
				System.out.println(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private Scanner sc;
	private Map<String, HotelVO> hotelMap;

	public Hotel() {
		sc = new Scanner(System.in);
		hotelMap = new HashMap<String, HotelVO>();
	}

	public void hotelStart() {
		System.out.println("*******************************");
		System.out.println("\t호텔 문을 열었습니다.");
		System.out.println("*******************************\n");

		while (true) {
			System.out.println("*******************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃  3.객실상태   4.업무종료");
			System.out.println("*******************************");
			int menuNum = sc.nextInt();
			System.out.println("메뉴선택 => " + menuNum + " <= 입력");
			switch (menuNum) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomStatus();
				break;
			case 4:
				System.out.println("호텔 문을 닫았습니다.");
				return;
			default:
				System.out.println("다시 입력하세요.");
			}
		}
	}

	private void checkIn() {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		FileWriter fw = null;
		FileReader fr = null;
		
		try {
			fw = new FileWriter("d:/D_Other/Hotel.txt");
			fr = new FileReader("d:/D_Other/Hotel.txt");
			String data =null;
			
			System.out.println("어느방에 체크인 하시겠습니까?");
			String roomNum = sc.next();
			System.out.println("방번호 입력 => " + roomNum + " <= 입력");
			while((data = isr.readLine()) != null) {
				fw.write(data); // 콘솔에서 입력받은 값을 파일로 출력하기
			}
			
			System.out.println("누구를 체크인 하시겠습니까?");
			String name = sc.next();
			System.out.println("이름 입력 => " + name + " <= 입력");
			while((data = isr.read()) != null) {
				fw.write(data); // 콘솔에서 입력받은 값을 파일로 출력하기
			}
			
			if (hotelMap.get(roomNum) != null) {
				System.out.println(roomNum + "방에는 이미 사람이 있습니다.\n");
				return;
			}
			
			hotelMap.put(roomNum, new HotelVO(roomNum, name));
			System.out.println("체크인 되었습니다.\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	private void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		String roomNum = sc.next();
		System.out.println("방번호 입력 => " + roomNum + " <= 입력");

		if (hotelMap.remove(roomNum) == null) {
			System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.\n");
		} else {
			System.out.println("체크아웃 되었습니다.\n");
		}
	}

	private void roomStatus() {
		FileOutputStream fos = null;
		
		Set<String> keySet = hotelMap.keySet();

		if (keySet.size() == 0) {
			System.out.println("체크인된 방이 없습니다.\n");
		} else {
			Iterator<String> it = keySet.iterator();
			int cnt = 0;
			while (it.hasNext()) {
				
				
				try {
					cnt++;
					String roomNum = it.next();
					HotelVO hVo = hotelMap.get(roomNum);
					System.out.println("방번호 : " + hVo.getRoomNum() + ", 투숙객 : " + hVo.getName() + "\n");
					
					fos = new FileOutputStream("d:/D_Other/Hotel.txt");
//					fos.write(hotelMap);
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						fos.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
			}
		}

	}

}

class HotelVO {
	private String roomNum;
	private String name;

	public HotelVO(String roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("[방번호=%s, 이름=%s]", roomNum, name);
	}

}
