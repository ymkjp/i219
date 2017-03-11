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
      debug("pc:" + pc);
      if (pc < 0 || pc >= comList.size()) {
        throw new VMException(pc,comList.size());
      }
      Integer x, x1, x2;
      Command com = comList.get(pc);
      switch (com.getName()) {
        case PUSH:
          debug("====PUSH===");
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
          pc++;
          break;
        case STORE:
          debug("====STORE===");
          if (stk.size() < 1) {
            throw new VMException(stk);
          }
          x = stk.pop();
          env.put(com.getVar(), x);
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
          break;
        case JMP:
          debug("====JMP===");
          pc = pc + com.getNum();
          break;
        case CJMP:
          debug("====CJMP===");
          debug("stk.size():" + stk.size());
          debug("stk.top():" + stk.top());
          debug("com.getVar():" + com.getVar() + ", com.getNum():" + com.getNum());
          if (stk.size() < 1) {
            throw new VMException(stk);
          }
          x1 = stk.pop();
          if (x1 == 1) {
            pc = pc + com.getNum();
          } else {
            pc++;
          }
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
    return;
//    System.out.println(msg);
  }

  public String toString() {
    return "vm()";
  }
}
