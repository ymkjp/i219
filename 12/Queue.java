/*
 * Copyright (c) 3/6/17 11:53 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public interface Queue<E> {
  Queue<E> enq(E e);
  Queue<E> deq();
  E top();
}
