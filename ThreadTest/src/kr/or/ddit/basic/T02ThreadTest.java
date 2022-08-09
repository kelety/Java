package kr.or.ddit.basic;

public class T02ThreadTest {
	public static void main(String[] args) {

		// 멀티 스레드 프로그램 방식

		// 방법 1) Thread 클래스를 상속한 class의 인스턴스를 생성한 후 이 인스턴스의 start() 메서드를 실행한다.
		MyThread1 th1 = new MyThread1();
		th1.start();

		// 방법 2) Runnable인터페이스를 구현한 클래스의 인스턴스를 생성한 후 이 인스턴스를 Thread객체의 인스턴스를 생성할 떄 생성자의 파라미터로 넘겨준다.
		//		  이때 생선된 Thread객체의 인스턴스의 start() 실행한다.
		Runnable r = new MyThread2();
		Thread th2 = new Thread(r);
		th2.start();
	
		// 방법 3) 익명클래스를 이용하는 방법
		// 		 Runnable인터페이스를 구현한 익명클래스를 Thread 인스턴스를 생성할때 매개변수로 넘겨준다.
		Thread th3 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 200; i++) {
					System.out.print("@");
					try {
						// Thread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춘다. 시간은 밀리세컨드 단위 사용. 즉, 1000은 1초를 의미
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		th3.start();
		
		// Thread.start()으로 실행하게되면 동시?에 실행되는것처럼 multi_thread가 됨
		// Thread.run()으로 실행하게되면 개별로 실행된다. single_thread
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춘다. 시간은 밀리세컨드 단위 사용. 즉, 1000은 1초를 의미
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyThread2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.print("$");
			try {
				// Thread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춘다. 시간은 밀리세컨드 단위 사용. 즉, 1000은 1초를 의미
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
