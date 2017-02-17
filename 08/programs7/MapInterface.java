/**
 * Copyright (c) 2017-02-13 23:18, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public interface MapInterface<K,V> {
  public void put(K k,V v);
  public V get(K k);
}
