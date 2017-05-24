package rectangle;

import java.util.Scanner;

public class Rectangle {

    double width = 1;
    double height = 1;

    public Rectangle() {
        //this is default constractor of the class
    }

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Rectangle Objects do you want ? ");
        int n = sc.nextInt();

        double[] width = new double[n];
        double[] height = new double[n];
        Rectangle[] rec = new Rectangle[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the width of the rectangle");
            width[i] = sc.nextDouble();

            System.out.println("Enter the height of the  rectangle");
            height[i] = sc.nextDouble();
            rec[i] = new Rectangle(width[i], height[i]);

        }

        System.out.println("Rectangle               width" + "            height" + "            area" + "            perimeter");
        for (int i = 0; i < n; i++) {
            System.out.println("_____________________________________________________________________________________");
            System.out.println("Rectangle [" + (i + 1) + "]            " + width[i] + "            " + height[i] + "                 " + rec[i].getArea() + "              " + rec[i].getPerimeter());
        }

    }

    public double getArea(Rectangle... a) {
        return width * height;

    }
//this is setter method to the field height

    public double getPerimeter() {
        return 2 * (width + height);
    }

}
