/*
 * Copyright (c) 12/25/16 9:03 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistanceBetweenTwoPoints {
  public DistanceBetweenTwoPoints() {
  }

  public static void main(String[] args) throws IOException {
    int i = 0;
    double[] r = new double[2];
    double[] theta = new double[2];
    AbstractPoint[] points = new AbstractPoint[2];
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(reader);
    System.out.println("Input two points in polar coordinate system");

    while(i < 2) {
      try {
        System.out.print("r" + i + ": ");
        String line = bufferedReader.readLine().trim();
        r[i] = Double.parseDouble(line);
        System.out.print("theta" + i + ": ");
        line = bufferedReader.readLine().trim();
        theta[i] = Double.parseDouble(line);
        points[i] = new PointPolarCoordinatesRadian(r[i], theta[i]);
        ++i;
      } catch (PointException e1) {
        System.err.println(e1);
      } catch (NumberFormatException e2) {
        System.err.println(e2);
      }
    }

    double distance = points[0].distance(points[1]);
    AbstractPoint[] abstractPoints = new AbstractPoint[2];

    for(int j = 0; j < 2; ++j) {
      AbstractPointPolarCoordinates coordinates = (AbstractPointPolarCoordinates)points[j];
      abstractPoints[j] = coordinates.convertToRectangularCoordinates();
    }

    System.out.println(points[0] + "-->" + points[1] + ": " + distance);
    System.out.println(points[0] + ": " + abstractPoints[0]);
    System.out.println(points[1] + ": " + abstractPoints[1]);
  }
}
