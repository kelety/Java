package kr.or.ddit.basic;

public class T04ThreadTest {

//	1~20억까지의 합계를 구하는데 걸린 시간 체크해 보기
//	전체 합계를 구하는 작업을 단독으로 했을 때(1개의 스레드를 사용했을 때)
	public static void main(String[] args) {
		
		// 단일 스레드로 처리할 때
		SumThread sm = new SumThread(1L, 2000000000L);
		
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();

		System.out.println("스레드 1개로 처리할 떄의 처리시간(ms) : " + (endTime - startTime));
		System.out.println("\n");
		
		
		// 여러 스레드가 협력해서 처리했을 때
		SumThread[] sumThs = new SumThread[] {
				new SumThread(		   1L,  500000000L),
				new SumThread( 500000000L, 1000000000L),
				new SumThread(1000000000L, 1500000000L),
				new SumThread(1500000000L, 2000000000L)
		};
		
		startTime = System.currentTimeMillis();
		for(Thread th : sumThs) {
			th.start();
		}
		for(Thread th : sumThs) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("협력(스레드4개) 처리할 떄의 처리시간(ms) : " + (endTime - startTime));
	}
}

class SumThread extends Thread {
	private long min, max;

	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}

	public void run() {
		long sum = 0;
		for (long i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println(min + " ~ " + max + "까지의 합 : " + sum);
	}
}