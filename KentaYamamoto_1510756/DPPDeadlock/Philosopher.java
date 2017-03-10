/*
 * Copyright (c) 3/10/17 11:33 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;

public class Philosopher extends Thread {
  private static int nextId = 0;
  private final int howManyDinners;
  private Chopstick right;
  private final int myId;
  private Chopstick left;
  private DiningRoom droom;

  public Philosopher(int n, Chopstick l, Chopstick r, DiningRoom dr) {
    this.myId = nextId++;
    this.left = l;
    this.right = r;
    this.howManyDinners =n; this.droom =dr;
  }

  public void run() {
    for (int i = 0; i < howManyDinners; i++) {
      // thinking
      try {
        droom.enter();
      } catch (InterruptedException e) {
      }
      try {
        left.acquire();
      } catch (InterruptedException e) {
      }
      try {
        right.acquire();
      } catch (InterruptedException e) {
      }
      // taking a dinner
      right.release();
      left.release();
      droom.leave();
    }
  }
}
