/*
 * Copyright (c) 3/6/17 11:27 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public class PseudoSafeInc1 extends Thread {
  private PseudoAtomicCounter counter;
  private int times;
  public PseudoSafeInc1(PseudoAtomicCounter c,int n) {
    this.counter = c;
    this.times = n;
  }
  public void run() {
    for (int i = 0; i < times; i++) {
      counter.inc();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    PseudoAtomicCounter c1 = new PseudoAtomicCounter();
    PseudoAtomicCounter c2 = new PseudoAtomicCounter();
    PseudoAtomicCounter c3 = new PseudoAtomicCounter();
    Thread t1 = new PseudoSafeInc1(c1,1000000);
    Thread t2 = new PseudoSafeInc1(c2,1000000);
    Thread t3 = new PseudoSafeInc1(c3,1000000);
    t1.start();
    t2.start();
    t3.start();
    t1.join();
    t2.join();
    t3.join();
    System.out.println("Counter: " + c1.get());
  }
}
