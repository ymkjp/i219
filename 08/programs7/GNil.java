/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class GNil<E> implements GList<E> {
  public GNil() {
  }

  public GList<E> cons(E element) {
    return new GNnList(element, this);
  }

  public GList<E> append(GList<E> list) {
    return list;
  }

  public String toString() {
    return "nil";
  }
}
