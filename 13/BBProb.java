/*
 * Copyright (c) 3/7/17 11:33 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;

public class BBProb {
  public static void main(String[] args) throws InterruptedException {
    MonitorBBuf<Integer> buf = new MonitorBBuf<Integer>(3);
    List<Integer> msgsSent = new ArrayList<Integer>();

    for (int i=0; i < 2; i++) {
      msgsSent.add(i);
    }

    List<Integer> msgsReceived = new ArrayList<Integer>();

    int nom = msgsSent.size();

    Sender<Integer> sender = new Sender<Integer>(buf,msgsSent);
    Receiver<Integer> receiver = new Receiver<Integer>(buf,msgsReceived,nom);
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
    assert msgsReceived.equals(msgsSent);
  }
}
