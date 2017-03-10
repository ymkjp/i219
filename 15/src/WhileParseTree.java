/*
 * Copyright (c) 2017-02-25 14:28, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class WhileParseTree
  extends StmParseTree
{
  private ExpParseTree ept;
  private StmParseTree stm;

  public WhileParseTree(ExpParseTree e1, StmParseTree s1) {
    ept = e1;
    stm = s1;
  }

  public Map<String,Integer> interpret(Map<String,Integer> env)
    throws InterpreterException
  {
    int n1 = ept.interpret(env);
    Map<String,Integer> env1;
    if (n1 == 0) {
      return env;
    } else {
      env1 = stm.interpret(env);
      return this.interpret(env1);
    }
  }

  public List<Command> compile() {
    List<Command> cl1, cl2;
    int size1, size2;
    Command cmd1, cmd2, cmd3;

    cl1 = ept.compile();
    cl2 = stm.compile();
    size1 = cl1.size();
    size2 = cl2.size();

    cmd1 = new Command(CommandName.CJMP, 2);
    cmd2 = new Command(CommandName.JMP, size2 + 2);
    cmd3 = new Command(CommandName.JMP, -1*(size1+size2+2));

    cl1.add(cmd1);
    cl1.add(cmd2);
    cl1.addAll(cl2);
    cl1.add(cmd3);
    return cl1;
  }

  public String toString() {
    return "while (" + ept + ") {" + stm + "}";
  }
}
