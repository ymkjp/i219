/*
 * Copyright (c) 3/6/17 11:30 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class DeadlockInc extends Thread {
  private NonatomicCounter counter1, counter2;
  public DeadlockInc(NonatomicCounter c1,NonatomicCounter c2) {
    this.counter1 = c1;
    this.counter2 = c2;
  }
  public void run() {
    synchronized (counter1) {
      for (int i=1; i < 5000; i++) ;
      synchronized (counter2) {
        counter1.inc();
        counter2.inc();
      }
    }
  }
  public static void main(String[] args) throws InterruptedException {
    NonatomicCounter c1 = new NonatomicCounter();
    NonatomicCounter c2 = new NonatomicCounter();
    Thread t1 = new DeadlockInc(c1,c2);
    Thread t2 = new DeadlockInc(c2,c1);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("Counter1: " + c1.get() + ", Counter2: " + c2.get());
  }
}
