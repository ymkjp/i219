/*
 * Copyright (c) 2017-02-11 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class MulParseTree
  implements ExpParseTree
{
  private ExpParseTree ept1, ept2;

  public MulParseTree(ExpParseTree e1, ExpParseTree e2) {
    ept1 = e1;
    ept2 = e2;
  }

  public int calculate()
    throws CalculatorException
  {
    int n1 = ept1.calculate();
    int n2 = ept2.calculate();
    return n1 * n2;
  }

  public String toString() {
    return "mul(" + ept1 + "," + ept2 + ")";
  }
}
