/*
 * Copyright (c) 3/7/17 11:26 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class Receiver2<E> extends Thread {
  private MonitorBBuf2<E> buf;
  private List<E> msgs;
  private int nom;
  public Receiver2(MonitorBBuf2<E> buf,List<E> msgs,int nom) {
    this.buf = buf;
    this.msgs = msgs;
    this.nom = nom;
  }
  public void run() {
    try {
      for (int i = 0; i < nom; i++) {
        msgs.add(buf.get());
      }
    } catch (InterruptedException e) {
      System.err.println(e);
    }
  }
}
