/*
 * Copyright (c) 3/10/17 11:33 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;

public class DiningRoom {
  private final int howManyPeopleCanEnter;
  private int cnt;

  public DiningRoom(int howMany) {
    this.howManyPeopleCanEnter = howMany;
    this.cnt = 0;
  }

  public synchronized void enter() throws InterruptedException {
    if (howManyPeopleCanEnter > cnt) {
      cnt++;
    } else {
      while (howManyPeopleCanEnter <= cnt) {
        this.wait();
      }
      cnt++;
    }
  }

  public synchronized void leave() {
    cnt--;
    this.notifyAll();
  }
}
