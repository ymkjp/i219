/**
 * Copyright (c) 2017-02-13 23:13, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class BSTMap<K extends Comparable<? super K>,V> implements MapInterface<K,V> {
  private BSTree<K, V> bst;

  public BSTMap() {
    bst = new BSLeaf<K, V>();
  }

  public void put(K k, V v) {
    bst = bst.put(k, v);
  }

  public V get(K k) {
    return bst.get(k);
  }
}
