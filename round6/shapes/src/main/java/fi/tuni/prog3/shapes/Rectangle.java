/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.shapes;

/**
 *
 * @author vudinhthi2304
 */
public class Rectangle implements IShapeMetrics {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return String.format("Rectangle with height %.2f and width %.2f", height, width);
    }

    @Override
    public String name() {
        return "rectangle";
    }

    // Implement the area() method from the interface
    @Override
    public double area() {
        return height * width;
    }

    // Implement the circumference() method from the interface
    @Override
    public double circumference() {
        return 2 * (height+width);
    }
    
}
