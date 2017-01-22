/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class GNnList<E> implements GList<E> {
  private E head;
  private GList<E> tail;

  public GNnList(E element, GList<E> list) {
    this.head = element;
    this.tail = list;
  }

  public GNnList<E> cons(E element) {
    return new GNnList(element, this);
  }

  public GNnList<E> append(GList<E> list) {
    return (GNnList)this.tail.append(list).cons(this.head);
  }

  public String toString() {
    return this.head.toString() + "," + this.tail.toString();
  }
}
