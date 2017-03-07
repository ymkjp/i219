/*
 * Copyright (c) 3/7/17 11:17 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;

public class FBBProb3 {
  public static void main(String[] args) throws InterruptedException {
    FAtomicBBuf<Integer> buf = new FAtomicBBuf<Integer>(3);
    List<Integer> msgsSent = new ArrayList<Integer>();

    for (int i=0; i < 10000; i++) {
      msgsSent.add(i);
    }

    List<Integer> msgsReceived = new ArrayList<Integer>();

    int nom = msgsSent.size();

    FSender3<Integer> sender = new FSender3<Integer>(buf,msgsSent);
    FReceiver3<Integer> receiver = new FReceiver3<Integer>(buf,msgsReceived,nom);
    sender.start();
    receiver.start();

    sender.join();
    receiver.join();

    System.out.println("msgsSent: " + msgsSent);
    System.out.println("msgsReceived: " + msgsReceived);

    if (msgsReceived.equals(msgsSent)) {
      System.out.println("Success!");
    } else {
      System.out.println("Failure!");
    }
  }
}
