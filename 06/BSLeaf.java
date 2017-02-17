/**
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class BSLeaf<K extends Comparable<? super K>, V> implements BSTree<K, V> {
  public BSLeaf() {
  }

  public BSNlTree<K, V> put(K key, V value) {
    return new BSNlTree(key, value, this, this);
  }

  public V get(K key) {
    return null;
  }

  public String toString() {
    return "leaf";
  }
}
