/*
 * Copyright (c) 3/7/17 11:26 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class FReceiver2<E> extends Thread {
  private FMonitorBBuf2<E> buf;
  private List<E> msgs;
  private int nom;
  public FReceiver2(FMonitorBBuf2<E> buf,List<E> msgs,int nom) {
    this.buf = buf;
    this.msgs = msgs;
    this.nom = nom;
  }
  public void run() {
    try {
      for (int i = 0; i < nom; i++) {
        msgs.add(buf.get());
        Thread.sleep(100);
      }
    } catch (InterruptedException e) {
      System.err.println(e);
    }
  }
}
