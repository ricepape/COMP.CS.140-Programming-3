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
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author vudinhthi2304
 */
public class CountryData {
    public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) {
        List<Country> countries = new ArrayList<>();

        List<JsonObject> areaData = readJsonFile(areaFile);
        List<JsonObject> populationData = readJsonFile(populationFile);
        List<JsonObject> gdpData = readJsonFile(gdpFile);

        // Assuming that the order of countries in all three files is the same
        for (int i = 0; i < areaData.size(); i++) {
            String name = areaData.get(i).get("attributes").getAsJsonObject().get("name").getAsString();
            double area = areaData.get(i).get("value").getAsDouble();
            long population = populationData.get(i).get("value").getAsLong();
            double gdp = gdpData.get(i).get("value").getAsDouble();

            countries.add(new Country(name, area, population, gdp));
        }

        return countries;
    }

    private static List<JsonObject> readJsonFile(String jsonFilePath) {
        List<JsonObject> data = new ArrayList<>();

        try (FileReader reader = new FileReader(jsonFilePath)) {
            Gson gson = new Gson();
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            data = gson.fromJson(root.getAsJsonArray("records"), new TypeToken<List<JsonObject>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
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
        }
    }
}
