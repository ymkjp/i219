/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class BinarySearchTree<K extends Comparable<? super K>, V> {
  private BSTree<K, V> bst = new BSLeaf();

  public BinarySearchTree() {
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
