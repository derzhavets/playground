package threads;

public class SimpleThreads {
	public static void main(String[] args) {
		Runnable myRunnable = new MyRunnable();
		Thread thread1 = new Thread(myRunnable);
		thread1.setName("Alpha");
		Thread thread2 = new Thread(myRunnable);
		thread2.setName("Beta");
		thread1.start();
		thread2.start();
		
		System.out.println("Main method bitch!");
	}
}
