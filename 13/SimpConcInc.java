/*
 * Copyright (c) 3/7/17 12:17 AM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public class SimpConcInc extends Thread {

  private static int count = 0;

  public void run() {
    count++;
  }

  public static void main(String[] args) throws InterruptedException {

    Thread t = new SimpConcInc();
    t.start();

    count++;

    t.join();

    System.out.println("count: " + count);
    assert count == 2;

  }
}
