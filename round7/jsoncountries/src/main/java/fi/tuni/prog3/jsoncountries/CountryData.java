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
                JsonObject attributes = data.getAsJsonArray("record").get(0).getAsJsonObject();
                String countryName = attributes.get("value").getAsString();
                double countryArea = Double.parseDouble(data.getAsJsonArray("record").get(2).getAsJsonObject().get("value").getAsString());
                long countryPopulation = findPopulationByCountryName(populationData, countryName);
                double countryGDP = findGDPByCountryName(gdpData, countryName);

                Country country = new Country(countryName, countryArea, countryPopulation, countryGDP);
                countries.add(country);
            }
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }

        return countries;
    }

    private static long findPopulationByCountryName(List<JsonObject> populationData, String countryName) {
        for (JsonObject populationRecord : populationData) {
            JsonObject populationData2 = populationRecord.getAsJsonObject("Root").getAsJsonObject("data");
            JsonObject populationAttributes = populationData2.getAsJsonArray("record").get(0).getAsJsonObject();
            if (countryName.equals(populationAttributes.get("value").getAsString())) {
                return Long.parseLong(populationData2.getAsJsonArray("record").get(2).getAsJsonObject().get("value").getAsString());
            }
        }
        return 0;
    }

    private static double findGDPByCountryName(List<JsonObject> gdpData, String countryName) {
        for (JsonObject gdpRecord : gdpData) {
            JsonObject gdpData2 = gdpRecord.getAsJsonObject("Root").getAsJsonObject("data");
            JsonObject gdpAttributes = gdpData2.getAsJsonArray("record").get(0).getAsJsonObject();
            if (countryName.equals(gdpAttributes.get("value").getAsString())) {
                return Double.parseDouble(gdpData2.getAsJsonArray("record").get(2).getAsJsonObject().get("value").getAsString());
            }
        }
        return 0.0;
    }

    private static List<JsonObject> readJsonFile(String filePath) throws IOException {
        List<JsonObject> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
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