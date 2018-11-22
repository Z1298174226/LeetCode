package com.zhao.lex.microsoft;

/**
 * Created by qtfs on 2018/5/8.
 */
public class Triangle2D {

    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;



    public Triangle2D() {
        this.p1 = new MyPoint(0, 0);
        this.p2 = new MyPoint(2, 0);
        this.p3 = new MyPoint(2, 2);
    }

    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double getArea(){
        double distance_1 = Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX())
                + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
        double distance_2 = Math.sqrt((p1.getX() - p3.getX()) * (p1.getX() - p3.getX())
                + (p1.getY() - p3.getY()) * (p1.getY() - p3.getY()));
        double distance_3 = Math.sqrt((p3.getX() - p2.getX()) * (p3.getX() - p2.getX())
                + (p3.getY() - p2.getY()) * (p3.getY() - p2.getY()));

        double p = (distance_1 + distance_2 + distance_3) / 2;

        return Math.sqrt(p * (p - distance_1) * (p - distance_2) * (p - distance_3));

    }

    public double getPermiter() {
        double distance_1 = Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX())
                + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
        double distance_2 = Math.sqrt((p1.getX() - p3.getX()) * (p1.getX() - p3.getX())
                + (p1.getY() - p3.getY()) * (p1.getY() - p3.getY()));
        double distance_3 = Math.sqrt((p3.getX() - p2.getX()) * (p3.getX() - p2.getX())
                + (p3.getY() - p2.getY()) * (p3.getY() - p2.getY()));
        return distance_1 + distance_2 + distance_3;
    }

    public boolean contains(MyPoint p) {
        double signOfTrig = (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
        double singleAB = (p2.getX() - p1.getX()) * (p.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p.getX() - p1.getX());
        double singleCA = (p1.getX() - p3.getX()) * (p.getY() - p3.getY()) - (p1.getY() - p3.getY()) * (p.getX() - p3.getX());
        double singleBC = (p3.getX() - p2.getX()) * (p.getY() - p3.getY()) - (p3.getY() - p2.getY()) * (p.getX() - p3.getX());

        boolean b1 = singleAB * signOfTrig > 0;
        boolean b2 = singleCA * signOfTrig > 0;
        boolean b3 = singleBC * signOfTrig > 0;

        return b1 && b2 && b3;
    }

    public boolean contains(Triangle2D triangle) {
        boolean b1 = contains(triangle.p1);
        boolean b2 = contains(triangle.p1);
        boolean b3 = contains(triangle.p1);
        return b1 && b2 && b3;
    }

//    public boolean overlaps(Triangle2D triangle) {
//
//    }

    public static void main(String[] args) {
        Triangle2D triangle = new Triangle2D();
        System.out.println(triangle.getArea());
        System.out.println(triangle.getPermiter());

        MyPoint p1 = triangle.new MyPoint(-1, 0);
        MyPoint p2 = triangle.new MyPoint(3, 4);
        MyPoint p3 = triangle.new MyPoint(3, -1);

        MyPoint p = triangle.new MyPoint(1, 0.9);
        System.out.println(triangle.contains(p));

        Triangle2D triangle1 = new Triangle2D(p1, p2, p3);
        System.out.println(triangle1.contains(triangle) || triangle.contains(triangle1));

    }

    class MyPoint {
        double x;
        double y;
        double getX(){
            return x;
        }
        double getY() {
            return y;
        }
        void setX(double x) {
            this.x = x;
        }
        void setY(double y) {
            this.y = y;
        }

        MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}