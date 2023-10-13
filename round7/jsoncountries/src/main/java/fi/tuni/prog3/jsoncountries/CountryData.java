package fi.tuni.prog3.jsoncountries;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryData {
    public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) {
        List<Country> countries = new ArrayList<>();

        // Read data from the three JSON files.
        JsonObject areaData = readJsonFromFile(areaFile);
        JsonObject populationData = readJsonFromFile(populationFile);
        JsonObject gdpData = readJsonFromFile(gdpFile);

        // Iterate over the country records in one of the JSON files (assuming they have the same countries).
        for (String countryName : areaData.keySet()) {
            double area = areaData.get(countryName).getAsJsonObject().get("attributes").getAsJsonObject().get("area").getAsDouble();
            int population = populationData.get(countryName).getAsJsonObject().get("attributes").getAsJsonObject().get("population").getAsInt();
            double gdp = gdpData.get(countryName).getAsJsonObject().get("attributes").getAsJsonObject().get("gdp").getAsDouble();

            // Create a Country object and add it to the list.
            Country country = new Country(countryName, area, population, gdp);
            countries.add(country);
        }

        return countries;
    }

    public static void writeToJson(List<Country> countries, String countryFile) {
        // Create a JSON array of JSON objects for each country.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        StringBuilder jsonOutput = new StringBuilder();
        jsonOutput.append("[\n");

        for (Country country : countries) {
            JsonObject countryObject = new JsonObject();
            countryObject.addProperty("name", country.getName());
            countryObject.addProperty("area", country.getArea());
            countryObject.addProperty("population", country.getPopulation());
            countryObject.addProperty("gdp", country.getGdp());

            String countryJson = gson.toJson(countryObject);
            jsonOutput.append(countryJson);
            jsonOutput.append(",\n");
        }

        jsonOutput.deleteCharAt(jsonOutput.length() - 2);  // Remove the trailing comma and newline.
        jsonOutput.append("]");

        // Write the JSON data to the specified file.
        try (Writer writer = new FileWriter(countryFile)) {
            writer.write(jsonOutput.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JsonObject readJsonFromFile(String filename) {
    try {
        // Create a FileReader to read the JSON file
        FileReader fileReader = new FileReader(filename);

        // Parse the JSON using GSON's JsonParser
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(fileReader).getAsJsonObject();

        // Close the file reader
        fileReader.close();

        return jsonObject;
    } catch (JsonIOException | JsonSyntaxException | IOException e) {
        e.printStackTrace();
        return null; // Handle the exception as needed
    }
}
}