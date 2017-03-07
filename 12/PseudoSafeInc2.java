/*
 * Copyright (c) 3/6/17 11:29 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class PseudoSafeInc2 extends Thread {
  private NonatomicCounter counter;
  private int times;
  public PseudoSafeInc2(NonatomicCounter c,int n) {
    this.counter = c;
    this.times = n;
  }
  public void run() {
    for (int i = 0; i < times; i++) {
      synchronized (this) {
        counter.inc();
      }
    }
  }
  public static void main(String[] args) throws InterruptedException {
    NonatomicCounter c = new NonatomicCounter();
    Thread t1 = new PseudoSafeInc2(c,1000000);
    Thread t2 = new PseudoSafeInc2(c,1000000);
    Thread t3 = new PseudoSafeInc2(c,1000000);
    t1.start();
    t2.start();
    t3.start();
    t1.join();
    t2.join();
    t3.join();
    System.out.println("Counter: " + c.get());
  }
}
