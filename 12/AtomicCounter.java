/*
 * Copyright (c) 3/6/17 11:21 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class AtomicCounter{
  private int count = 0;
  public synchronized void inc() {
    count++;
  }
  public synchronized int get() {
    return count;
  }
}
