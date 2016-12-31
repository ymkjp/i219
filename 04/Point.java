/*
 * Copyright (c) 12/25/16 9:03 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class Point {
  private double x = -0.5D;
  private double y;
  private static int n = 0;

  public Point() {
    ++n;
  }

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
    ++n;
  }

  public static int howManyPoints() {
    return n;
  }

  public final double getX() {
    return this.x;
  }

  public final double getY() {
    return this.y;
  }

  public final void setX(double x) {
    this.x = x;
  }

  public final void setY(double x) {
    this.y = x;
  }

  public double distance() {
    return Math.sqrt(this.x * this.x + this.y * this.y);
  }

  public double distance(Point x) {
    double distanceX = x.getX() - this.x;
    double distanceY = x.getY() - this.y;
    return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
  }

  public void move(double x, double y) {
    this.x += x;
    this.y += y;
  }

  public String toString() {
    return "(" + this.x + "," + this.y + ")";
  }
}

