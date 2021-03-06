/*
 * Copyright (c) 3/10/17 11:33 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;

public class Philosopher extends Thread {
  private final int myId;
  private static int nextId = 0;
  private final int howManyDinners;
  private Chopstick right;
  private Chopstick left;
  private List<Chopstick> resources;
  private Waiter waiter;

  public Philosopher(int n, Chopstick l, Chopstick r, Waiter w) {
    this.myId = nextId++;
    this.left = l;
    this.right = r;
    this.howManyDinners = n;
//    this.waiter = w;
//    this.resources = new ArrayList<Chopstick>();
//    this.resources.add(right);
//    this.resources.add(left);
  }

  public void run() {
    for (int i = 0; i < howManyDinners; i++) {
      try {
        eat();
      } catch (InterruptedException e) {
        System.err.println(e);
      }
    }
  }
//
//  public void eat() throws InterruptedException {
//    // thinking
//    waiter.acquire(resources.size());
//    left.acquire();
//    right.acquire();
//    // taking a dinner
//    right.release();
//    left.release();
//    waiter.release(resources.size());
//  }

  /**
   * @see http://stackoverflow.com/a/27086122/879951
   * @throws InterruptedException
   */
  public void eat() throws InterruptedException {
    // For JPF, Better to use infinite loop but not recursive call
    while (true) {
      // thinking
      if (left.pickUp()) {
        if (right.pickUp()) {
          // taking a dinner
          right.putDown();
          left.putDown();
          return;
        } else {
          left.putDown();
        }
      }
    }
  }
}
