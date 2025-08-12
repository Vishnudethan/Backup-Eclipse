package practice;
/*class Pen {}
class Pencil {}

public class DeadLockExample {

    static final Pen pen = new Pen();
    static final Pencil pencil = new Pencil();

    public static void main(String[] args) {

        // Thread 1: Has pen, wants pencil
        Thread t1 = new Thread(() -> {
            synchronized (pen) {
                System.out.println("Thread 1: Holding pen...");

                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread 1: Waiting for pencil...");
                synchronized (pencil) {
                    System.out.println("Thread 1: Got pencil too!");
                }
            }
        });

        // Thread 2: Has pencil, wants pen
        Thread t2 = new Thread(() -> {
            synchronized (pencil) {
                System.out.println("Thread 2: Holding pencil...");

                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread 2: Waiting for pen...");
                synchronized (pen) {
                    System.out.println("Thread 2: Got pen too!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}*/
public class DeadLockExample {

    static  String lock1 = new String();
    static  String lock2 = new String();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");

                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread 1: Waiting for lock2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Got lock2!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock2...");

                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread 2: Waiting for lock1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Got lock1!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

