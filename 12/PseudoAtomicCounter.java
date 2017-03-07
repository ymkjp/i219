/*
 * Copyright (c) 2017-02-13 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class PseudoAtomicCounter {
  private static int count = 0;
  public synchronized void inc() {
    count++;
  }
  public synchronized int get() {
    return count;
  }
}
