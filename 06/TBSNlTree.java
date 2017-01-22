/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

public class TBSNlTree<K extends Comparable<K>, V> implements TBSTree<K, V> {
  private K key;
  private V val;
  private TBSTree<K, V> left;
  private TBSTree<K, V> right;

  public TBSNlTree(K key, V value, TBSTree<K, V> left, TBSTree<K, V> right) {
    this.key = key;
    this.val = value;
    this.left = left;
    this.right = right;
  }

  public TBSNlTree<K, V> put(K key, V value) {
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
