/*
 * Copyright (c) 2017-02-25 14:28, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class IfParseTree
  extends StmParseTree
{
  private ExpParseTree ept;
  private StmParseTree stm1;
  private StmParseTree stm2;

  public IfParseTree(ExpParseTree e1, StmParseTree s1, StmParseTree s2) {
    ept = e1;
    stm1 = s1;
    stm2 = s2;
  }

  public Map<String,Integer> interpret(Map<String,Integer> env)
    throws InterpreterException
  {
    int n1 = ept.interpret(env);
    if (n1 != 0) {
      return stm1.interpret(env);
    } else {
      return stm2.interpret(env);
    }
  }

  public List<Command> compile() {
    List<Command> cl1, cl2, cl3;
    int size2, size3;
    Command cmd1, cmd2, cmd3;

    cl1 = ept.compile();
    cl2 = stm1.compile();
    cl3 = stm2.compile();

    size2 = cl2.size();
    size3 = cl3.size();

    cmd1 = new Command(CommandName.CJMP, 2);
    cmd2 = new Command(CommandName.JMP, size2 + 2);
    cmd3 = new Command(CommandName.JMP, size3 + 1);

    cl1.add(cmd1);
    cl1.add(cmd2);
    cl1.addAll(cl2);
    cl1.add(cmd3);
    cl1.addAll(cl3);
    return cl1;
  }

  public String toString() {
    return "if (" + ept + ") {" + stm1 + "} else {" + stm2 + "}";
  }
}
