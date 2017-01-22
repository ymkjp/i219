/*
 * Copyright (c) 2017-01-02 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class NzNat implements Nat {
  private Nat n;

  public NzNat(Nat y) {
    this.n = y;
  }

  public Nat pred() {
    return this.n;
  }

  public NzNat plus(Nat y) {
    return new NzNat(this.n.plus(y));
  }

  public int compareTo(Nat y) {
    return y instanceof Zero?1:this.n.compareTo(((NzNat)y).pred());
  }

  public String toString() {
    return "s(" + this.n + ")";
  }
}
