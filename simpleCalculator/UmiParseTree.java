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
