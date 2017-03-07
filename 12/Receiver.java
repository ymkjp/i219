/*
 * Copyright (c) 3/7/17 11:26 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class Receiver<E> extends Thread {
  private MonitorBBuf<E> buf;
  private List<E> msgs;
  private int nom;
  public Receiver(MonitorBBuf<E> buf,List<E> msgs,int nom) {
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
