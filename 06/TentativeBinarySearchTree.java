/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class TentativeBinarySearchTree<K extends Comparable<K>, V> {
  private TBSTree<K, V> bst = new TBSLeaf();

  public TentativeBinarySearchTree() {
  }

  public void put(K key, V value) {
    this.bst = this.bst.put(key, value);
  }

  public V get(K key) {
    return this.bst.get(key);
  }

  public String toString() {
    return this.bst.toString();
  }
}
