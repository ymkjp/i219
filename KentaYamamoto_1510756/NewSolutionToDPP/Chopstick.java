/*
 * Copyright (c) 3/10/17 11:33 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;
import java.util.concurrent.Semaphore;

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

  public synchronized boolean pickUp() throws InterruptedException {
    if (beingUsed) {
      return false;
    } else {
      beingUsed = true;
      return true;
    }
  }

  public synchronized void putDown() {
    beingUsed = false;
  }
}
