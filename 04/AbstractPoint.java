/*
 * Copyright (c) 12/25/16 9:03 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public abstract class AbstractPoint implements PointInterface {
  public AbstractPoint() {
  }

  public abstract double distance();

  public double distance(PointInterface pointInterface) {
    double x = this.getX() - pointInterface.getX();
    double y = this.getY() - pointInterface.getY();
    return Math.sqrt(x * x + y * y);
  }

}
