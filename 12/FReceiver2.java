/*
 * Copyright (c) 3/7/17 11:06 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class FReceiver2<E> extends Thread {
  private AtomicBBuf<E> buf;
  private List<E> msgs;
  private int nom;
  public FReceiver2(AtomicBBuf<E> buf,List<E> msgs,int nom) {
    this.buf = buf;
    this.msgs = msgs;
    this.nom = nom;
  }
  public void run() {
    for (int i = 0; i < nom; i++) {
      msgs.add(buf.get());
    }
  }
}
