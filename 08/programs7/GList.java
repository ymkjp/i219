/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public interface GList<E> {
  GList<E> cons(E element);

  GList<E> append(GList<E> list);
}
