/*
 * Copyright (c) 2017-02-18 21:26, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class AddParseTree extends ExpParseTree {
  private ExpParseTree ept1, ept2;
  public AddParseTree(ExpParseTree e1, ExpParseTree e2) {
    ept1 = e1;
    ept2 = e2;
  }
  public List<Command> compile() {
    List<Command> cl;
    cl = ept1.compile();
    cl.addAll(ept2.compile());
    cl.add(new Command(CommandName.ADD));
    return cl;
  }
}
