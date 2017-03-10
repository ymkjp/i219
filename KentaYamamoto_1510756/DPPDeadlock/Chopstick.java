/*
 * Copyright (c) 3/10/17 11:33 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;

public class Chopstick {
  private boolean beingUsed;

  public Chopstick() {
    this.beingUsed = false;
  }

  public synchronized void acquire() throws InterruptedException {
    while (beingUsed) {
      this.wait();
    }
    beingUsed = true;
  }

  public synchronized void release() {
    beingUsed = false;
    this.notifyAll();
  }
}
