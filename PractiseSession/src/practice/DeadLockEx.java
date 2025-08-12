package practice;
public class DeadLockEx {

	// Creating two resources
	static class Resource1 {
		synchronized void method1(Resource2 resource2) {
			System.out.println("Thread 1: Holding Resource 1...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			System.out.println("Thread 1: Waiting for Resource 2...");
			resource2.lastMethod();
		}

		synchronized void lastMethod() {
			System.out.println("Thread 1: Inside lastMethod of Resource 1");
		}
	}

	static class Resource2 {
		synchronized void method1(Resource1 resource1) {
			System.out.println("Thread 2: Holding Resource 2...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			System.out.println("Thread 2: Waiting for Resource 1...");
			resource1.lastMethod();
		}

		synchronized void lastMethod() {
			System.out.println("Thread 2: Inside lastMethod of Resource 2");
		}
	}

	public static void main(String[] args) {
		Resource1 resource1 = new Resource1();
		Resource2 resource2 = new Resource2();

		// Thread 1 attempts to lock Resource1 then Resource2
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				resource1.method1(resource2);
			}
		});

		// Thread 2 attempts to lock Resource2 then Resource1
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				resource2.method1(resource1);
			}
		});

		t1.start();
		t2.start();
	}
}
