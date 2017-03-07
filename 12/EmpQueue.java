/*
 * Copyright (c) 3/6/17 11:53 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public class EmpQueue<E> implements Queue<E> {
  public Queue<E> enq(E e) {
    return new NeQueue<E>(e,this);
  }
  public Queue<E> deq() {
    return this;
  }
  public E top() {
    return null;
  }
}
