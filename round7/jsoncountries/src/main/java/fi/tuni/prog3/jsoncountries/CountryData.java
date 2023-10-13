/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.jsoncountries;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author vudinhthi2304
 */
public class CountryData {
    public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) {
        List<Country> countries = new ArrayList<>(); // Initialize the list

        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode areaData = (ArrayNode) objectMapper.readTree(new File(areaFile));
            ArrayNode populationData = (ArrayNode) objectMapper.readTree(new File(populationFile));
            ArrayNode gdpData = (ArrayNode) objectMapper.readTree(new File(gdpFile));

            for (int i = 0; i < areaData.size(); i++) {
                // Extract data for the current country
                JsonNode areaNode = areaData.get(i);
                JsonNode populationNode = populationData.get(i);
                JsonNode gdpNode = gdpData.get(i);

                // Extract relevant attributes
                String name = areaNode.get("attributes").get("name").asText();
                double area = areaNode.get("attributes").get("value").asDouble();
                long population = populationNode.get("attributes").get("value").asLong();
                double gdp = gdpNode.get("attributes").get("value").asDouble();

                // Create a Country object and add it to the list
                Country country = new Country(name, area, population, gdp);
                countries.add(country);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception, you might want to log the error or re-throw a custom exception
        }

        return countries;
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
