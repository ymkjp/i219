/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public interface BSTree<K extends Comparable<? super K>, V> {
  BSTree<K, V> put(K key, V value);

  V get(K key);
}
