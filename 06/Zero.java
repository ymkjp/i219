/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class Zero implements Nat {
  public Zero() {
  }

  public Nat plus(Nat y) {
    return y;
  }

  public int compareTo(Nat y) {
    return y instanceof Zero?0:-1;
  }

  public String toString() {
    return "0";
  }
}
