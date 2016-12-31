/*
 * Copyright (c) 12/25/16 9:03 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public class PointPolarCoordinatesRadian extends AbstractPointPolarCoordinates {
  public PointPolarCoordinatesRadian(double r, double theta) throws PointException {
    if(r < 0.0D) {
      throw new PointException("r should not be negative!");
    } else if(theta >= 0.0D && theta <= 6.283185307179586D) {
      this.setR(Double.valueOf(r));
      this.setTheta(Double.valueOf(theta));
    } else {
      throw new PointException("theta should satify ineqality: 0.0 <= theta <= 6.283185307179586");
    }
  }

  public final double getX() {
    return Math.cos(this.getTheta()) * this.getR();
  }

  public final double getY() {
    return Math.sin(this.getTheta()) * this.getR();
  }

  public String toString() {
    return "<r: " + this.getR() + ",theta(in radian): " + this.getTheta() + ">";
  }
}
