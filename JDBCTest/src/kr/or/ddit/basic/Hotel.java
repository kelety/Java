package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import kr.or.ddit.util.JDBCUtil;

public class Hotel {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.hotelStart();

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

	// 체크인 출력 메서드
	private void checkIn() {
		boolean chk = false;
		String roomNum = "";

		do {
			System.out.println("어느방에 체크인 하시겠습니까?");
			roomNum = sc.next();
			System.out.println("방번호 입력 => " + roomNum + " <= 입력");

			chk = checkRoom(roomNum);
			if (chk == true) {
				System.out.println(roomNum + " 방에는 이미  사람이 있습니다.");
				System.out.println("다시 입력해주세요.");
			}
		} while (chk == true);
		System.out.println("누구를 체크인 하시겠습니까?");
		String name = sc.next();
		sc.nextLine(); // 입력버퍼 비우기
		System.out.println("이름 입력 => " + name + " <= 입력");

		try {
			conn = JDBCUtil.getConnection();
			String sql = " insert into hotel_mng(room_num, guest_name)" + " values (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomNum);
			pstmt.setString(2, name);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("체크인 되었습니다.\n");
			} else {
				System.out.println(roomNum + "방 추가 작업 실패ㅜㅜ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	// 체크아웃 메서드
	private void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		String roomNum = sc.next();
		System.out.println("방번호 입력 => " + roomNum + " <= 입력");

		try {
			conn = JDBCUtil.getConnection();
			String sql = " delete from hotel_mng where room_num = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomNum);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("체크아웃 되었습니다.\n");
			} else {
				System.out.println(roomNum + "방 정보 삭제 실패ㅜㅜㅜ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	// 객실상태 출력 메서드
	private void roomStatus() {
		System.out.println("---------------");
		System.out.println("방번호\t투숙객");
		System.out.println("---------------");

		try {
			conn = JDBCUtil.getConnection();
			String sql = " select * from hotel_mng ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String roomNum = rs.getString("room_num");
				String name = rs.getString("guest_name");

				System.out.println(roomNum + "\t" + name);
			}
			System.out.println("---------------");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	// roomNum을 이용해 방이 비어있는지 체크
	private boolean checkRoom(String roomNum) {

		boolean chk = false;

		try {
			conn = JDBCUtil.getConnection();
			String sql = " select  count(*) from hotel_mng where room_num = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomNum);
			rs = pstmt.executeQuery();

			int cnt = 0;
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if (cnt > 0) {
				chk = true;
			}
		} catch (SQLException e) {
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		return chk;
	}
}
