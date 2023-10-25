package fi.tuni.prog3.jsoncountries;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CountryData {
    public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) throws IOException {
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

    private static List<JsonObject> readJsonFile(String fileName) throws IOException {
        List<JsonObject> jsonObjects = new ArrayList<>();
        Gson gson = new Gson();
    
        try (FileReader reader = new FileReader(fileName)) {
            JsonObject rootObject = gson.fromJson(reader, JsonObject.class);
    
            if (rootObject != null) {
                JsonObject dataObject = rootObject.getAsJsonObject("Root")
                        .getAsJsonObject("data");
    
                if (dataObject != null) {
                    JsonArray records = dataObject.getAsJsonArray("record");
    
                    if (records != null) {
                        for (JsonElement recordElement : records) {
                            JsonObject record = recordElement.getAsJsonObject();
    
                            JsonArray fields = record.getAsJsonArray("field");
    
                            if (fields != null && fields.size() == 3) {
                                JsonObject nameObj = fields.get(0).getAsJsonObject();
                                JsonObject itemObj = fields.get(1).getAsJsonObject();
                                JsonObject valueObj = fields.get(2).getAsJsonObject();
    
                                if (nameObj.has("value") && itemObj.has("value") && valueObj.has("value")) {
                                    String name = nameObj.get("value").getAsString();
                                    String item = itemObj.get("value").getAsString();
                                    double value = valueObj.get("value").getAsDouble();
    
                                    JsonObject jsonObject = new JsonObject();
                                    jsonObject.addProperty("name", name);
                                    jsonObject.addProperty("item", item);
                                    jsonObject.addProperty("value", value);
    
                                    jsonObjects.add(jsonObject);
                                }
                            }
                        }
                    }
                }
            }
        }
    
        return jsonObjects;
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
            e.printStackTrace(); // Handle the exception properly, e.g., log it
        }
    }
}