/*
 * Copyright (c) 2017-02-13 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class SafeInc1 extends Thread {
  private AtomicCounter counter;
  private int times;
  public SafeInc1(AtomicCounter c,int n) {
    this.counter = c; this.times = n;
  }
  public void run() {
    for (int i = 0; i < times; i++) {
      counter.inc();
    }
  }
  public static void main(String[] args) throws InterruptedException {
    AtomicCounter c = new AtomicCounter();
    Thread t1 = new SafeInc1(c,1000000);
    Thread t2 = new SafeInc1(c,1000000);
    Thread t3 = new SafeInc1(c,1000000);
    t1.start();
    t2.start();
    t3.start();
    t1.join();
    t2.join();
    t3.join();
    System.out.println("Counter: " + c.get());
  }
}
