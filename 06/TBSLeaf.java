/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class TBSLeaf<K extends Comparable<K>, V> implements TBSTree<K, V> {
  public TBSLeaf() {
  }

  public TBSNlTree<K, V> put(K key, V value) {
    return new TBSNlTree(key, value, this, this);
  }

  public V get(K key) {
    return null;
  }

  public String toString() {
    return "leaf";
  }
}
