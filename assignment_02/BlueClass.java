/*
 * Copyright (c) 12/19/16 9:57 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.util.ArrayList;

public class BlueClass {
  private ArrayList<KeyValPair> list;

  public BlueClass() {
    list = new ArrayList<KeyValPair>();
  }

  public ArrayList<KeyValPair> getList() {
    return list;
  }

  public void setList(ArrayList<KeyValPair> list) {
    this.list = list;
  }

  public void put(String k, int v) {
    for (int i = 0; i < list.size(); i++) {
      if (k.equals(list.get(i).getKey())) {

        list.get(i).setVal(v);
        return;
      }
    }
    list.add(0,new KeyValPair(k, v));
  }

  public Integer get(String k) {
    for (int i = 0; i < list.size(); i++) {
      if (k.equals(list.get(i).getKey())) {
        return list.get(i).getVal();
      }
    }
    return null;
  }
  public boolean isRegistered(String k) {
    for (int i = 0; i < list.size(); i++) {
      if (k.equals(list.get(i).getKey())) {
        return true;
      }
    }
    return false;
  }

  public void delete(String k) {
    for (int i = 0; i < list.size(); i++) {
      if (k.equals(list.get(i).getKey())) {
        list.remove(i);
        return;
      }
    }
  }

}
