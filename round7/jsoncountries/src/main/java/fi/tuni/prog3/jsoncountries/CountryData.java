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
import com.google.gson.JsonSyntaxException;

public class CountryData {
    public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) {
        List<Country> countries = new ArrayList<>();

        try {
            List<JsonObject> areaData = readJsonFile(areaFile);
            List<JsonObject> populationData = readJsonFile(populationFile);
            List<JsonObject> gdpData = readJsonFile(gdpFile);

            for (JsonObject record : areaData) {
                JsonObject data = record.getAsJsonObject("Root").getAsJsonObject("data");
                JsonObject attributes = data.getAsJsonObject("record").getAsJsonArray("field").get(0).getAsJsonObject();
                String countryName = attributes.get("value").getAsString();
                double countryArea = Double.parseDouble(data.getAsJsonObject("record").getAsJsonArray("field").get(2).getAsJsonObject().get("value").getAsString());
                long countryPopulation = 0;
                double countryGDP = 0;

                for (JsonObject populationRecord : populationData) {
                    JsonObject populationData2 = populationRecord.getAsJsonObject("Root").getAsJsonObject("data");
                    JsonObject populationAttributes = populationData2.getAsJsonObject("record").getAsJsonArray("field").get(0).getAsJsonObject();
                    if (countryName.equals(populationAttributes.get("value").getAsString())) {
                        countryPopulation = Long.parseLong(populationData2.getAsJsonObject("record").getAsJsonArray("field").get(2).getAsJsonObject().get("value").getAsString());
                        break;
                    }
                }

                for (JsonObject gdpRecord : gdpData) {
                    JsonObject gdpData2 = gdpRecord.getAsJsonObject("Root").getAsJsonObject("data");
                    JsonObject gdpAttributes = gdpData2.getAsJsonObject("record").getAsJsonArray("field").get(0).getAsJsonObject();
                    if (countryName.equals(gdpAttributes.get("value").getAsString())) {
                        countryGDP = Double.parseDouble(gdpData2.getAsJsonObject("record").getAsJsonArray("field").get(2).getAsJsonObject().get("value").getAsString());
                        break;
                    }
                }

                Country country = new Country(countryName, countryArea, countryPopulation, countryGDP);
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }

    private static List<JsonObject> readJsonFile(String filename) {
        List<JsonObject> data = new ArrayList<>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    JsonObject jsonObject = JsonParser.parseString(line).getAsJsonObject();
                    data.add(jsonObject);
                } catch (JsonSyntaxException e) {
                    System.err.println("Error parsing JSON: " + e.getMessage());
                }
            }
        } catch (IOException e) {
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
            e.printStackTrace();
        }
    }
}