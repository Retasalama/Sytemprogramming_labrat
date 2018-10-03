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

    private ArrayList<HashMap<String, String>> lunchList;

    public ArrayList<HashMap<String, String>> parseJSON(String jsonStr) {
        lunchList = new ArrayList<>();

        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONObject lunchMenu = jsonObj.getJSONObject("LunchMenu");

            // Getting JSON Array node
            JSONArray setMenus = lunchMenu.getJSONArray("SetMenus");

            // looping through All SetMenus
            for (int i = 0; i < setMenus.length(); i++) {
                JSONObject c = setMenus.getJSONObject(i);

                JSONArray meals = c.getJSONArray("Meals");
                HashMap<String, String> mealNames = new HashMap<>();
                for (int j = 0; j < meals.length(); j++) {
                    JSONObject d = meals.getJSONObject(j);
                    mealNames.put("Name", d.getString("Name"));
                    Iterator entries = mealNames.entrySet().iterator();
                    while (entries.hasNext()) {
                        Map.Entry entry = (Map.Entry) entries.next();
                        String key = (String) entry.getKey();
                        String value = (String) entry.getValue();
                        Log.d("TAG", "Key = " + key + ", Value = " + value);
                    }
                }

                lunchList.add(mealNames);
            }
        } catch (final JSONException e) {
            Log.e("TAG", "Json parsing error: " + e.getMessage());
        }
        return lunchList;
    }

}

