package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            //JSONObject creation
            JSONObject obj = new JSONObject(json);
            JSONObject name = obj.getJSONObject("name");

            //Getting JSON String name and ArrayList values
            String mainName = name.getString("mainName");

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            ArrayList<String> akaList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                akaList.add(alsoKnownAs.getString(i));
            }

            String placeOfOrigin = obj.getString("placeOfOrigin");
            String description = obj.getString("description");
            String imagePath = obj.getString("image");

            JSONArray ingredients = obj.getJSONArray("ingredients");
            ArrayList<String> ingList = new ArrayList<>();
            for (int i = 0; i < ingredients.length(); i++) {
                ingList.add(ingredients.getString(i));
            }

            Sandwich currentSandwich = new Sandwich(mainName, akaList, placeOfOrigin, description, imagePath, ingList);

            return currentSandwich;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}