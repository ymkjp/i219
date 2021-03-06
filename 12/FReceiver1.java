/*
 * Copyright (c) 3/6/17 11:36 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class FReceiver1<E> extends Thread {
  private NonatomicBBuf<E> buf;
  private List<E> msgs;
  private int nom;
  public FReceiver1(NonatomicBBuf<E> buf,List<E> msgs,int nom) {
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
