/*
 * Copyright (c) 12/25/16 9:03 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public final class PointIn3D extends Point {
  private double z;

  public PointIn3D(double x, double y, double z) {
    super(x, y);
    this.z = z;
  }

  public double getZ() {
    return this.z;
  }

  public void setZ(double z) {
    this.z = z;
  }

  public double distance() {
    double distance2d = super.distance();
    return Math.sqrt(distance2d * distance2d + this.z * this.z);
  }

  public double distance(PointIn3D pt) {
    double distance2d = super.distance(pt);
    double distance3rd = pt.getZ() - this.z;
    return Math.sqrt(distance2d * distance2d + distance3rd * distance3rd);
  }

  public String toString() {
    return "(" + super.getX() + "," + super.getY() + "," + this.z + ")";
  }
}
