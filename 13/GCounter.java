/*
 * Copyright (c) 3/7/17 9:11 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public class GCounter {

  private static int x = 0;

  private static Object lock = new Object();

  public static int get() {
    return x;
  }

  public void inc() {
    synchronized (lock) {
      x++;
    }
  }
}
