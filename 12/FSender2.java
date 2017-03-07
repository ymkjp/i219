/*
 * Copyright (c) 3/7/17 11:07 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;
public class FSender2<E> extends Thread {
  private AtomicBBuf<E> buf;
  private List<E> msgs;

  public FSender2(AtomicBBuf<E> buf,List<E> msgs) {
    this.buf = buf;
    this.msgs = msgs;
  }
  public void run() {
    for (int i = 0; i < msgs.size(); i++) {
      buf.put(msgs.get(i));
    }
  }
}
