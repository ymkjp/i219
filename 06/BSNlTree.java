/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public class BSNlTree<K extends Comparable<? super K>, V> implements BSTree<K, V> {
  private K key;
  private V val;
  private BSTree<K, V> left;
  private BSTree<K, V> right;

  public BSNlTree(K key, V value, BSTree<K, V> left, BSTree<K, V> right) {
    this.key = key;
    this.val = value;
    this.left = left;
    this.right = right;
  }

  public BSNlTree<K, V> put(K key, V value) {
    int compared = key.compareTo(this.key);
    if(compared == 0) {
      this.val = value;
    } else if(compared < 0) {
      this.left = this.left.put(key, value);
    } else {
      this.right = this.right.put(key, value);
    }

    return this;
  }

  public V get(K key) {
    int compared = key.compareTo(this.key);
    return compared == 0?this.val:(compared < 0?this.left.get(key):this.right.get(key));
  }

  public String toString() {
    return "<" + this.key + "," + this.val + "," + this.left + "," + this.right + ">";
  }
}
