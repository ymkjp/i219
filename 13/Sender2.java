/*
 * Copyright (c) 3/7/17 11:22 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;
public class Sender2<E> extends Thread {
  private MonitorBBuf2<E> buf;
  private List<E> msgs;

  public Sender2(MonitorBBuf2<E> buf,List<E> msgs) {
    this.buf = buf;
    this.msgs = msgs;
  }
  public void run() {
    try {
      for (int i = 0; i < msgs.size(); i++) {
        buf.put(msgs.get(i));
      }
    } catch (InterruptedException e) {
      System.err.println(e);
    }
  }
}
