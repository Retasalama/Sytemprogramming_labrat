package t.e.lunchmenu;


import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonParser {

    private ArrayList<String> mealNames;

    public ArrayList<String> parseJSON(String jsonStr) {
        mealNames = new ArrayList<>();
        //HashMap<String, String> mealNames = new HashMap<>();

        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONObject lunchMenu = jsonObj.getJSONObject("LunchMenu");

            // Getting JSON Array node
            JSONArray setMenus = lunchMenu.getJSONArray("SetMenus");
            //

            // looping through All SetMenus
            for (int i = 0; i < setMenus.length(); i++) {
                JSONObject c = setMenus.getJSONObject(i);
                mealNames.add(c.getString("Name"));


                JSONArray meals = c.getJSONArray("Meals");
                for (int j = 0; j < meals.length(); j++) {
                    JSONObject d = meals.getJSONObject(j);
                    mealNames.add(d.getString("Name"));
                }
                Log.d("TAG", "Mealnames size = " + mealNames.size());

            }
        } catch (final JSONException e) {
            Log.e("TAG", "Json parsing error: " + e.getMessage());
        }
        for(String meal : mealNames){
            Log.d("TAG", "Mealname = " + meal);
        }
        return mealNames;
    }

}

/*
Iterator entries1 = mealNames.entrySet().iterator();
while (entries1.hasNext()) {
Map.Entry entry = (Map.Entry) entries1.next();
String key = (String) entry.getKey();
String value = (String) entry.getValue();
Log.d("TAG", "Key = " + key + ", Value = " + value);
}*/

