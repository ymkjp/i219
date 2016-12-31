/*
 * Copyright (c) 12/25/16 9:03 PM, Kenta Yamamoto <ymkjp@jaist.ac.jp>, s1510756.
 */
public final class RandomWalking {
  private final Point goal;
  private final int maxSteps;
  private Point walker;

  public RandomWalking(double gx, double gy, double wx, double wy, int max) {
    this.goal = new Point(gx, gy);
    this.walker = new Point(wx, wy);
    this.maxSteps = max;
  }

  public void startWalking() {
    int steps = 0;

    while(true) {
      System.out.println("walker: " + this.walker);
      if(this.goal.distance(this.walker) < 1.0D) {
        System.out.println("********************");
        System.out.println("got to the goal!");
        System.out.println("walker: " + this.walker);
        System.out.println("goal: " + this.goal);
        System.out.println("steps: " + steps);
        break;
      }

      if(steps >= this.maxSteps) {
        System.out.println("********************");
        System.out.println("did not get to the goal!");
        System.out.println("walker: " + this.walker);
        System.out.println("goal: " + this.goal);
        System.out.println("steps: " + steps);
        break;
      }

      double dx = Math.random();
      double dy = Math.random();
      dx = Math.random() > 0.2D ? -dx : dx;
      dy = Math.random() > 0.2D ? -dy : dy;
      this.walker.move(dx, dy);
      ++steps;
    }

  }
}
