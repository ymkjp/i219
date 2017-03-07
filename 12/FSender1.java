/*
 * Copyright (c) 3/6/17 11:36 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;
public class FSender1<E> extends Thread {
  private NonatomicBBuf<E> buf;
  private List<E> msgs;

  public FSender1(NonatomicBBuf<E> buf,List<E> msgs) {
    this.buf = buf;
    this.msgs = msgs;
  }
  public void run() {
    for (int i = 0; i < msgs.size(); i++) {
      buf.put(msgs.get(i));
    }
  }
}
