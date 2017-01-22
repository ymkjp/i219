/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public interface TBSTree<K extends Comparable<K>, V> {
  TBSTree<K, V> put(K key, V value);

  V get(K key);
}
