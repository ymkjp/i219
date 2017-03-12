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

  public VirtualMachine(List<Command> cl, Integer pc, Stack<Integer> stk, Map<String,Integer> env) {
    comList = cl;
    reset(pc, stk, env);
  }

  public void reset(Integer pc, Stack<Integer> stk, Map<String,Integer> env) {
    this.pc = pc;
    this.stk = stk;
    this.env = env;
  }

  public List<Command> getComList() {
    return comList;
  }

  //  Add jump commands
  public Map<String,Integer> run() throws VMException {
    while (true) {
//      try {Thread.sleep(1000); } catch (InterruptedException e) {};
      debug("pc:" + pc);
      if (pc < 0 || pc >= comList.size()) {
        throw new VMException(pc,comList.size());
      }
      int x, x1, x2;
      Command com = comList.get(pc);
      switch (com.getName()) {
        case PUSH:
          debug("====PUSH===" + com.getNum());
          stk.push(com.getNum());
          pc++;
          break;
        case LOAD:
          debug("====LOAD===");
          if (!env.containsKey(com.getVar())) {
            throw new VMException(com.getVar());
          }
          x = env.get(com.getVar());
          stk.push(x);
          debug("Loaded (com.getVar(), x):" + com.getVar() + "," + x);
          pc++;
          break;
        case STORE:
          debug("====STORE===");
          if (stk.size() < 1) {
            throw new VMException(stk);
          }
          x = stk.pop();
          env.put(com.getVar(), x);
          debug("Stored: (com.getVar(), x)" + com.getVar() + "," + x);
          pc++;
          break;
        case ADD:
          debug("====ADD===");
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.top();
          stk.pop();
          x1 = stk.top();
          stk.pop();
          x = x1 + x2;
          stk.push(x);
          debug("Added: (x = x1 + x2)" + x + "," + x1 + "," + x2);
          pc++;
          break;
        case SUB:
          debug("====SUB===");
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.top();
          stk.pop();
          x1 = stk.top();
          stk.pop();
          x = x1 - x2;
          stk.push(x);
          debug("SUB: (x = x1 - x2)" + x + "," + x1 + "," + x2);
          pc++;
          break;
        case MUL:
          debug("====MUL===");
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.top();
          stk.pop();
          x1 = stk.top();
          stk.pop();
          x = x1 * x2;
          stk.push(x);
          debug("MUL: (x = x1 * x2)" + x + "," + x1 + "," + x2);
          pc++;
          break;
        case MONE:
          debug("====MONE===");
          if (stk.size() < 1) {
            throw new VMException(stk);
          }
          x1 = stk.top();
          stk.pop();
          x = -x1;
          stk.push(x);
          pc++;
          debug("MONE: (x = - x1)" + x + "," + x1);
          break;
        case REM:
          debug("====REM===");
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.top();
          stk.pop();
          x1 = stk.top();
          stk.pop();
          x = x1 % x2;
          stk.push(x);
          debug("REM: (x = x1 % x2)" + x + "," + x1 + "," + x2);
          pc++;
          break;
        case QUO:
          debug("====QUO===");
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
          debug("QUO: (x = x1 / x2)" + x + "," + x1 + "," + x2);
          break;
        case EQ:
          debug("====EQ===");
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.pop();
          x1 = stk.pop();
          x = x1 == x2 ? 1 : 0;
          stk.push(x);
          pc++;
          debug("EQ: (x = x1 == x2)" + x + "," + x1 + "," + x2);
          break;
        case NEQ:
          debug("====NEQ===");
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.pop();
          x1 = stk.pop();
          x = x1 != x2 ? 1 : 0;
          stk.push(x);
          pc++;
          debug("NEQ: (x = x1 !== x2)" + x + "," + x1 + "," + x2);
          break;
        case LT:
          debug("====LT===");
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.pop();
          x1 = stk.pop();
          x = x1 < x2 ? 1 : 0;
          stk.push(x);
          pc++;
          debug("LT: (x = x1 < x2)" + x + "," + x1 + "," + x2);
          break;
        case GT:
          debug("====GT===");
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.pop();
          x1 = stk.pop();
          x = x1 > x2 ? 1 : 0;
          stk.push(x);
          pc++;
          debug("GT: (x = x1 > x2)" + x + "," + x1 + "," + x2);
          break;
        case AND:
          debug("====AND===");
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.pop();
          x1 = stk.pop();
          x = x1 == 0 ? 0 : (x2 == 0 ? 0 : 1);
          stk.push(x);
          pc++;
          debug("AND: (x = x1 && x2)" + x + "," + x1 + "," + x2);
          break;
        case OR:
          debug("====OR===");
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.pop();
          x1 = stk.pop();
          x = x1 == 0 ? (x2 == 0 ? 0 : 1) : 1;
          stk.push(x);
          pc++;
          debug("OR: (x = x1 || x2)" + x + "," + x1 + "," + x2);
          break;
        case JMP:
          debug("====JMP===");
          pc = pc + com.getNum();
          debug("JMP: (pc, com.getNum())" + pc + "," + com.getNum());
          break;
        case CJMP:
          debug("====CJMP===");
          if (stk.size() < 1) {
            throw new VMException(stk);
          }
          x1 = stk.pop();
          if (x1 == 1) {
            pc = pc + com.getNum();
          } else {
            pc++;
          }
          debug("CJPM: (x1, pc, com.getNum())" + x1 + "," + pc + "," + com.getNum());
          break;
        case QUIT:
          debug("====QUIT===");
          if (stk.size() != 0) {
            throw new VMException(stk,stk.size());
          }
          return env;
        default:
          throw new IllegalStateException("pc1: " + pc + "cl1: " + comList);
      }
    }
  }

  public void debug(String msg) {
//    System.out.println(msg);
    return;
  }

  public String toString() {
    return "vm()";
  }
}
