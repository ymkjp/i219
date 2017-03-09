
/*
 * Copyright (c) 3/10/17 11:33 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;

public class DiningPhilosopherProblem {
  public void begin(int n,int m) {
    Chopstick left;
    Chopstick right = new Chopstick();
    Chopstick tmp = right;
    Waiter w = new Waiter(n - 1);
    for (int i = 0; i < n-1; i++) {
      left = right;
      right = new Chopstick();
      (new Philosopher(m,left,right, w)).start();
    }
    left = right;
    right = tmp;
    (new Philosopher(m,left,right, w)).start();
  }
}
