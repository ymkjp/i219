/*
 * Copyright (c) 3/6/17 11:51 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;

public class FBBProb1 {
  public static void main(String[] args) throws InterruptedException {
    List<Integer> log = new ArrayList<Integer>();
    FMonitorBBuf1<Integer> buf = new FMonitorBBuf1<Integer>(2,log);
    List<Integer> msgsSent = new ArrayList<Integer>();

    for (int i=0; i < 2; i++) {
      msgsSent.add(i);
    }

    List<Integer> msgsReceived = new ArrayList<Integer>();

    int nom = msgsSent.size() + msgsSent.size();
    FSender1<Integer> sender = new FSender1<Integer>(buf,msgsSent);
    FReceiver1<Integer> receiver = new FReceiver1<Integer>(buf,msgsReceived,nom);
    FSender1<Integer> sender2 = new FSender1<Integer>(buf,msgsSent);

    sender.start();
    receiver.start();
    sender2.start();

    sender.join();
    receiver.join();
    sender2.join();

    System.out.println("msgsSent: " + msgsSent);
    System.out.println("msgsReceived: " + msgsReceived);

    if (msgsReceived.equals(msgsSent)) {
      System.out.println("Success!");
    } else {
      System.out.println("Failure!");
    }
    assert msgsReceived.equals(log);
  }
}
