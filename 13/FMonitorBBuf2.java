/*
 * Copyright (c) 3/6/17 11:51 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;

public class FMonitorBBuf2<E> {
  private Queue<E> queue;
  private int noe = 0;
  private final int capacity;
  private List<E> log;

  public FMonitorBBuf2(int cap, List<E> log) {
    this.queue = new EmpQueue<E>();
    this.capacity = cap;
    this.log = log;
  }

  public synchronized void put(E e) throws InterruptedException {
    while (noe >= capacity) this.wait();

    if (noe < capacity) {
      queue = queue.enq(e);
      log.add(e);
      noe++;
      this.notifyAll();
    }
  }

  public synchronized E get() throws InterruptedException {
    while (noe < 0) this.wait();

    if (noe > 0) {
      E e = queue.top();

      queue = queue.deq();
      noe--;

      this.notifyAll();

      return e;
    }
    return null;
  }

}

