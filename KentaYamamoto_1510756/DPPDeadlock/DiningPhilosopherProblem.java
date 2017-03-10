/*
 * Copyright (c) 3/10/17 11:33 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;

public class DiningPhilosopherProblem {
  public void begin(int n,int m) {
//    DiningRoom dr = new DiningRoom(n-1);
    DiningRoom dr = new DiningRoom(n);
    Chopstick left;
    Chopstick right = new Chopstick();
    Chopstick tmp = right;
    for (int i = 0; i < n-1; i++) {
      left = right;
      right = new Chopstick();
      (new Philosopher(m,left,right,dr)).start();
    }
    left = right;
    right = tmp;
    (new Philosopher(m,left,right,dr)).start();
  }
}
