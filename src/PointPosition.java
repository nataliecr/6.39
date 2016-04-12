import java.util.Scanner;

public class PointPosition {
  public static void main(String[] args){
    System.out.print("Enter three points for p0, p1, and p2: ");
    Scanner input = new Scanner(System.in);
    double x0 = input.nextDouble();
    double y0 = input.nextDouble();
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();
    
    if (onTheLineSegment(x0, y0, x1, y1, x2, y2) == true)
      System.out.println("(" + x2 + ", " + y2 + ") is on the line segment from "
          + " (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
    else{
      if (onTheSameLine(x0, y0, x1, y1, x2, y2) == true)
        System.out.println("(" + x2 + ", " + y2 + ") is on the same line from "
            + " (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
    } // else
    
    if (leftOfTheLine(x0, y0, x1, y1, x2, y2) == true)
      System.out.println("(" + x2 + ", " + y2 + ") is on the left side of the "
          + "line from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
    
    if (rightOfTheLine(x0, y0, x1, y1, x2, y2) == true)
      System.out.println("(" + x2 + ", " + y2 + ") is on the right side of the "
          + "line from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
  } // main
    
  /** Return true if point (x2, y2) is on the left side of the
  * directed line from (x0, y0) to (x1, y1) */
  public static boolean leftOfTheLine(double x0, double y0,
             double x1, double y1, double x2, double y2)
  {
     if ((x1 - x0)*(y2 - y0) - (y1 - y0)*(x2 - x0) > 0)
       return true;
     return false;
  } // method leftOfTheLine
  
  public static boolean rightOfTheLine(double x0, double y0,
             double x1, double y1, double x2, double y2)
  {
      if ((x1 - x0)*(y2 - y0) - (y1 - y0)*(x2 - x0) < 0)
       return true;
     return false;
  } // method rightOfTheLine

        /** Return true if point (x2, y2) is on the same
        * line from (x0, y0) to (x1, y1) */
  public static boolean onTheSameLine(double x0, double y0,
              double x1, double y1, double x2, double y2)
  {
    if ((x1 - x0)*(y2 - y0) - (y1 - y0)*(x2 - x0) == 0)
       return true;
     return false;  
  } // onTheSameLine

        /** Return true if point (x2, y2) is on the
       * line segment from (x0, y0) to (x1, y1) */
  public static boolean onTheLineSegment(double x0, double y0,
                double x1, double y1, double x2, double y2)
  {
    if (onTheSameLine(x0, y0, x1, y1, x2, y2) == false)
      return false;  
      
    double dotproduct = (x2 - x0)*(x1 - x0) + (y2 - y0)*(y1 - y0);
    if (dotproduct < 0)
      return false;
    
    if ((x1 - x0)*(x1 - x0) + (y1 - y0)*(y1 - y0) < dotproduct)
      return false;
    
    return true;
  } // onTheLineSegment
}
