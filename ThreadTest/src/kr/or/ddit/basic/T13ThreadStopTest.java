package kr.or.ddit.basic;

public class T13ThreadStopTest {
	public static void main(String[] args) {
//		ThreadStopEx1 th = new ThreadStopEx1();
//		th.start();
//
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
////		th.stop();	// 강제종료 
//		th.setStop(true);

		
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		th2.interrupt();
		
	}
}

class ThreadStopEx1 extends Thread {

	private boolean stop;

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {

		while (!stop) {
			System.out.println("스레드 처리 중...");
		}
		System.out.println("자원 정리 중 ...");
		System.out.println("실행 종료");
	}
}

// interrupt()메서드를 이용하여 스레드를 멈추게 하는 방법
class ThreadStopEx2 extends Thread {

	@Override
	public void run() {

//		// 방법 1 => sleep()메서드나 join()메서드 등을 사용했을때 interrupt()메서드를 호출하면
//		// InterruptedException이 발생한다.
//		try {
//			while (true) {
//				System.out.println("스레드 처리중...");
//				Thread.sleep(1);
//			}
//		} catch (InterruptedException e) {}
		
		
		// 방법 2 => interrupt()메서드가 호출되었는지 검사하기
		while(true) {
			System.out.println("스레드 처리중...");
			
//			// 검사방법 1) 스레드 객체의 인스턴스 메서드를 이용하는 방법
//			if(this.isInterrupted()) {	// interrupt() 호출되면 true 리턴
//				System.out.println("인스턴스 메서드 isInterrupted 호출됨");
//				break;
//			}
			
			
			// 검사방법 2) 스레드의 정적 메서드를 이용하는 방법
			if(Thread.interrupted()) {
				System.out.println("정적메서드 interrupted 호출됨");
				break;
			}
		}
		
		System.out.println("자원 정리 중 ...");
		System.out.println("실행 종료");
	}

}