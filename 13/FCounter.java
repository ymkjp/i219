/*
 * Copyright (c) 3/7/17 9:09 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public class FCounter {

  private static int x = 0;

  public static int get() {
    return x;
  }

  public synchronized void inc() {
    x++;
  }
}
