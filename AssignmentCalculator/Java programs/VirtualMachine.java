/*
 * Copyright (c) 2017-02-13 14:28, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.*;

public class VirtualMachine
{
  private List<Command> comList;
  private int pc; // Integer?
  private Stack<Integer> stk;
  private Map<String,Integer> env;

  public VirtualMachine(List<Command> cl) {
    comList = cl;
  }

  public void reset(Integer pc, Stack<Integer> stk, Map<String,Integer> env) {
    this.pc = pc;
    this.stk = stk;
    this.env = env;
  }

  public List<Command> getComList() {
    return comList;
  }

  //  int
  public Map<String,Integer> run() throws VMException {
    while (true) {
      if (pc < 0 || pc >= comList.size()) {
        throw new VMException(pc,comList.size());
      }
      Integer x, x1, x2;
      Command com = comList.get(pc);
      switch (com.getName()) {
        case PUSH:
          stk.push(com.getNum());
          pc++;
          break;
        case MUL:
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.top();
          stk.pop();
          x1 = stk.top();
          stk.pop();
          x = x1 * x2;
          stk.push(x);
          pc++;
          break;
        case QUO:
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.top();
          stk.pop();
          x1 = stk.top();
          stk.pop();
          if (x2 == 0) {
            throw new VMException();
          }
          x = x1 / x2;
          stk.push(x);
          pc++;
          break;
        case QUIT:
          if (stk.size() != 1) {
            throw new VMException(stk,stk.size());
          }
          x = stk.top();
          stk.pop();
          return env;
        default:
          throw new IllegalStateException("pc1: " + pc + "cl1: " + comList);
      }
    }
  }

  public String toString() {
    return "vm()";
  }
}
