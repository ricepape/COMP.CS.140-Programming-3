/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.jsoncountries;

/**
 *
 * @author vudinhthi2304
 */
public class Country implements Comparable<Country>{
    private final String country;
    private final double area;
    private final long population;
    private final double gdp;

    public Country(String country, double area, long population, double gdp) {
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
    }

    @Override
    public int compareTo(Country other) {
        return this.country.compareTo(other.country);
    }

    @Override
    public String toString() {
        return country + "\n" +
               "  Area: " + String.format("%.1f", area) + "km2\n" +
               "  Population: " + population + "\n" +
               "  GDP: " + String.format("%.1f", gdp)+ "2015 (USD)";
    }

    public String getName() {
        return country;
    }

    public double getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public double getGdp() {
        return gdp;
    }



}
