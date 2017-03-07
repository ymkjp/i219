/*
 * Copyright (c) 3/7/17 11:22 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;
public class FSender3<E> extends Thread {
  private FAtomicBBuf<E> buf;
  private List<E> msgs;

  public FSender3(FAtomicBBuf<E> buf,List<E> msgs) {
    this.buf = buf;
    this.msgs = msgs;
  }
  public void run() {
    for (int i = 0; i < msgs.size(); i++) {
      buf.put(msgs.get(i));
    }
  }
}
