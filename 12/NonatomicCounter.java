/*
 * Copyright (c) 3/6/17 11:20 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class NonatomicCounter
{
  private int count = 0;
  public void inc() {
    count++;
  }
  public int get() {
    return count;
  }
}
