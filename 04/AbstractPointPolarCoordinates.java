/*
 * Copyright (c) 12/25/16 9:03 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public abstract class AbstractPointPolarCoordinates extends AbstractPoint {
  private double r;
  private double theta;

  public AbstractPointPolarCoordinates() {
  }

  public double distance() {
    return this.r;
  }

  public final double getR() {
    return this.r;
  }

  public final double getTheta() {
    return this.theta;
  }

  public final void setR(Double r) {
    this.r = r.doubleValue();
  }

  public final void setTheta(Double theta) {
    this.theta = theta.doubleValue();
  }

  public PointRectangularCoordinates convertToRectangularCoordinates() {
    double x = this.getX();
    double y = this.getY();
    return new PointRectangularCoordinates(x, y);
  }
}
