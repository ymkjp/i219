/*
 * Copyright (c) 2017-02-18 21:24, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public abstract class ExpParseTree {
  public abstract List<Command> compile();
  public List<Command> genCode() {
    List<Command> cl;
    cl = this.compile();
    cl.add(new Command(CommandName.QUIT));
    return cl;
  }
}
