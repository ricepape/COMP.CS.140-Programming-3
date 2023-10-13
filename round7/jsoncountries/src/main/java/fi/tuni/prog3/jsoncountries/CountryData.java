/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.jsoncountries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author vudinhthi2304
 */
public class CountryData {
    public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) {
        List<Country> countries = new ArrayList<>();

        try {
            // Read data from the area file
            List<JsonObject> areaData = readJsonFile(areaFile);

            // Read data from the population file
            List<JsonObject> populationData = readJsonFile(populationFile);

            // Read data from the GDP file
            List<JsonObject> gdpData = readJsonFile(gdpFile);

            // Combine data from the three files into Country objects
            for (JsonObject areaObject : areaData) {
                String countryName = areaObject.get("name").getAsString();
                double countryArea = areaObject.get("value").getAsDouble();
                long countryPopulation = 0; // Initialize to 0
                double countryGDP = 0; // Initialize to 0

                // Find corresponding population and GDP data for the country
                for (JsonObject populationObject : populationData) {
                    if (countryName.equals(populationObject.get("name").getAsString())) {
                        countryPopulation = populationObject.get("value").getAsLong();
                        break;
                    }
                }

                for (JsonObject gdpObject : gdpData) {
                    if (countryName.equals(gdpObject.get("name").getAsString())) {
                        countryGDP = gdpObject.get("value").getAsDouble();
                        break;
                    }
                }

                // Create a Country object and add it to the list
                Country country = new Country(countryName, countryArea, countryPopulation, countryGDP);
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }

    // Helper method to read JSON data from a file
    private static List<JsonObject> readJsonFile(String filename) throws Exception {
        Gson gson = new Gson();
        List<JsonObject> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                JsonObject jsonObject = JsonParser.parseString(line).getAsJsonObject();
                data.add(jsonObject);
            }
        }

        return data;
    }

    public static void writeToJson(List<Country> countries, String countryFile) {
        // Create a Gson instance with pretty printing enabled
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter fileWriter = new FileWriter(countryFile)) {
            // Convert the list of Country objects to a JSON array
            String jsonArray = gson.toJson(countries);

            // Write the JSON array to the file
            fileWriter.write(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
