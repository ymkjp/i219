/*
 * Copyright (c) 3/7/17 9:12 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public class Counter {

  private int x = 0;

  public synchronized int get() {
    return x;
  }
  public synchronized void inc() {
    x++;
  }
}
