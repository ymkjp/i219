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
      System.out.println("pc:" + pc);
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
        case LOAD:
          if (!env.containsKey(com.getVar())) {
            throw new VMException(com.getVar());
          }
          x = env.get(com.getVar());
          stk.push(x);
          pc++;
          break;
        case STORE:
          if (stk.size() < 1) {
            throw new VMException(stk);
          }
          x = stk.pop();
          env.put(com.getVar(), x);
          pc++;
          break;
        case ADD:
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
          if (stk.size() < 1) {
            throw new VMException(stk);
          }
          pc = pc + stk.pop() + 1;
          System.out.println("[JMP] pc:" + pc);
          break;
        case CJMP:
          if (stk.size() < 2) {
            throw new VMException(stk);
          }
          x2 = stk.pop();
          x1 = stk.pop();
          if (x1 == 1) {
            pc = pc + x2 + 1;
          } else {
            pc++;
          }
          System.out.println("[CJMP] pc:" + pc);
          break;
        case QUIT:
          if (stk.size() != 0) {
            System.out.println("====waaaaa===");
            throw new VMException(stk,stk.size());
          }
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
