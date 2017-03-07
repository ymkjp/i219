/*
 * Copyright (c) 3/6/17 11:33 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public class AtomicBBuf<E> {
  private Queue<E> queue;
  private int noe = 0;
  private final int capacity;

  public AtomicBBuf(int cap) {
    this.queue = new EmpQueue<E>();
    this.capacity = cap;
  }

  public synchronized void put(E e) {
    if (noe < capacity) {
      queue = queue.enq(e);
      noe++;
    }
  }

  public synchronized E get() {
    if (noe > 0) {
      E e = queue.top();
      queue = queue.deq();
      noe--;
      return e;
    }
    return null;
  }
}
