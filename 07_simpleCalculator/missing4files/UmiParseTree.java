/*
 * Copyright (c) 2017-02-11 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class UmiParseTree
  implements ExpParseTree
{
  private ExpParseTree ept1;

  public UmiParseTree(ExpParseTree e1) {
    ept1 = e1;
  }

  public int calculate()
    throws CalculatorException
  {
    int n1 = ept1.calculate();
    return -n1;
  }

  public String toString() {
    return "umi(" + ept1 + ")";
  }
}
