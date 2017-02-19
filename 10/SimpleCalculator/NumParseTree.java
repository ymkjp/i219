/*
 * Copyright (c) 2017-02-18 21:24, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class NumParseTree extends ExpParseTree {
  private int val;
  public NumParseTree(int x) { val = x; }
  public List<Command> compile() {
    List<Command> cl = new ArrayList<Command>();
    cl.add(new Command(CommandName.PUSH,val));
    return cl;
  }
}
