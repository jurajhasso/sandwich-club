package com.udacity.sandwichclub.utils;

import android.os.Build;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {

            JSONObject jObj = new JSONObject(json);

            JSONObject name = jObj.getJSONObject("name");

            String mainName = name.getString("mainName");

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsArrayList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                alsoKnownAsArrayList.add(alsoKnownAs.getString(i));
            }

            String placeOfOrigin = jObj.getString("placeOfOrigin");

            String description = jObj.getString("description");

            String image = jObj.getString("image");


            JSONArray ingredients = jObj.getJSONArray("ingredients");
            ArrayList<String> ingredientsArrayList = new ArrayList<>();
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsArrayList.add(ingredients.getString(i));
            }

            return new Sandwich(mainName, alsoKnownAsArrayList, placeOfOrigin, description, image, ingredientsArrayList);


        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
