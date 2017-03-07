/*
 * Copyright (c) 3/7/17 11:22 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class FReceiver3<E> extends Thread {
  private FAtomicBBuf<E> buf;
  private List<E> msgs;
  private int nom;
  public FReceiver3(FAtomicBBuf<E> buf,List<E> msgs,int nom) {
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
