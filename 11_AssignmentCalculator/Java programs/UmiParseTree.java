/*
 * Copyright (c) 2017-02-13 23:31, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class UmiParseTree
  implements ExpParseTree
{
  private ExpParseTree ept1;

  public UmiParseTree(ExpParseTree e1) {
    ept1 = e1;
  }

  public int interpret(Map<String,Integer> env)
    throws InterpreterException
  {
    int n1 = ept1.interpret(env);
    return - n1;
  }

  public List<Command> compile() {
    List<Command> cl;
    cl = ept1.compile();
    cl.add(new Command(CommandName.MONE));
    return cl;
  }

  public String toString() {
    return "umi(" + ept1 + ")";
  }
}
