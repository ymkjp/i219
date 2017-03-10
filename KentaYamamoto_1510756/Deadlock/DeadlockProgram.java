/*
 * Copyright (c) 3/6/17 11:30 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class DeadlockProgram {
  public static Object lock1 = new Lock1();
  public static Object lock2 = new Lock2();

  public static void main(String args[]) {
    ThreadDemo1 t1 = new ThreadDemo1();
    ThreadDemo2 t2 = new ThreadDemo2();
    t1.start();
    t2.start();
  }

  private static class Lock1 {}
  private static class Lock2 {}

  private static class ThreadDemo0 extends Thread {
    public synchronized void take1and2() {
      System.out.println("Thread 1: Holding lock 1...");
      synchronized (lock1) {
        System.out.println("Thread 1: Waiting for lock 2...");
        synchronized (lock2) {
          System.out.println("Thread 1: Holding lock 1 & 2...");
        }
      }
    }
    public synchronized void take2and1() {
      System.out.println("Thread 2: Holding lock 2...");
      synchronized (lock2) {
        System.out.println("Thread 2: Waiting for lock 1...");
        synchronized (lock1) {
          System.out.println("Thread 2: Holding lock 1 & 2...");
        }
      }
    }
  }

  private static class ThreadDemo1 extends ThreadDemo0 {
    public void run() {
      take1and2();
    }

  }

  private static class ThreadDemo2 extends ThreadDemo0 {
    public void run() {
      take2and1();
    }
  }
}
