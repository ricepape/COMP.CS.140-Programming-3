/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.shapes;

/**
 *
 * @author vudinhthi2304
 */
public class Circle implements IShapeMetrics{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Circle with radius: %.2f", radius);
    }

    @Override
    public String name() {
        return "circle";
    }

    // Implement the area() method from the interface
    @Override
    public double area() {
        return PI * radius * radius;
    }

    // Implement the circumference() method from the interface
    @Override
    public double circumference() {
        return 2 * PI * radius;
    }
    
}
