/*
 * Copyright (c) 3/10/17 12:59 AM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */

import java.util.*;
import java.util.concurrent.Semaphore;

public class Waiter extends Semaphore {
  public Waiter(Integer th) {
    super(th);
  }
}
