package Homework;
import java.util.*;

public class StudentSort {

	public static void main(String[] args) {
		List<Student> stdList = new ArrayList<Student>();

		stdList.add(new Student("20160930", "윤동기", 88, 77, 66));
		stdList.add(new Student("20170930", "홍길동", 88, 97, 96));
		stdList.add(new Student("20180930", "개똥이", 76, 87, 92));
		stdList.add(new Student("20190930", "일지매", 75, 90, 80));
		stdList.add(new Student("20220930", "고길동", 66, 77, 88));
		stdList.add(new Student("20200930", "우영우", 66, 77, 88));

		System.out.println("정렬 전 : ");
		for (Student std : stdList) {
			System.out.println(std);
		}
		System.out.println();

		Collections.sort(stdList);
		System.out.println("학번 오름차순 정렬 : ");
		for (Student std : stdList) {
			System.out.println(std);
		}
		System.out.println();

		Collections.sort(stdList, new StudentScoreSum());
		System.out.println("총점 역순 정렬 : ");
		for (Student std : stdList) {
			System.out.println(std);
		}
		System.out.println();

		Collections.sort(stdList);
		System.out.println("총점이 같을때 학번의 내림차순");
		for (Student std : stdList) {
			System.out.println(std);
		}
	}
}

//class StudentRank implements Comparator<Student> {
//	public int compare(Student std1, Student std2) {
//		if (std1.getScoreSum() == std2.getScoreSum()) {
//			if (Integer.parseInt(std1.getStudentID()) > Integer.parseInt(std2.getStudentID())) {
//				return (std1.getStudentID()).compareTo(std2.getStudentID());
//			} else if (Integer.parseInt(std1.getStudentID()) == Integer.parseInt(std2.getStudentID())) {
//				return 0;
//			} else {
//				return -1;
//			}
//		}
//	}
//}

class StudentScoreSum implements Comparator<Student> {

	public int compare(Student str1, Student str2) {
		if (str1.getScoreSum() > str2.getScoreSum()) {
			return -1;
		} else if (str1.getScoreSum() == str2.getScoreSum()) {
			return 0;
		} else {
			return 1;
		}
	}
}

class Student implements Comparable<Student> {
	
	private String studentID; // 오름차순 총점이 같으면 학번의 내림차순으로
	private String name;
	private int korScore;
	private int engScore;
	private int mathScore;
	private int scoreSum; // 역순
	private int rank;

	public Student(String studentID, String name, int korScore, int engScore, int mathScore) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		scoreSum = korScore + engScore + mathScore;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getScoreSum() {
		return scoreSum;
	}

	public void setScoreSum(int scoreSum) {
		this.scoreSum = scoreSum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [학번=" + studentID + ", 이름=" + name + ", 국어점수=" + korScore + ", 영어점수=" + engScore + ", 수학점수="
				+ mathScore + ", 총점=" + scoreSum + ", 순위=" + rank + "]";
	}

	@Override
	public int compareTo(Student std) {
		return this.getStudentID().compareTo(std.getStudentID());
	}

//	public int compareToID(Student std2) {
//		if (this.scoreSum == std2.scoreSum) {
//			return Integer.parseInt(this.getStudentID().compareTo(std2.getStudentID()));
//		}
//	}
}