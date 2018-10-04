package t.e.lunchmenu;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    private List<Lunches> lunches;

    public List<Lunches> parseJSON(String jsonStr) {
        lunches = new ArrayList<>();

        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONObject lunchMenu = jsonObj.getJSONObject("LunchMenu");

            // Getting JSON Array node
            JSONArray setMenus = lunchMenu.getJSONArray("SetMenus");
            //

            // looping through All SetMenus
            for (int i = 0; i < setMenus.length(); i++) {
                Lunches lunch = new Lunches();
                JSONObject c = setMenus.getJSONObject(i);
                lunch.setLunchGategory(c.getString("Name"));
                switch (c.getString("Name")){
                    case("VEGETABLE LUNCH"):
                        lunch.setIconId(R.drawable.vegetable);
                        break;
                    case("LUNCH"):
                        lunch.setIconId(R.drawable.lunch);
                        break;
                    case("LUNCH SALAD"):
                        lunch.setIconId(R.drawable.vegetable);
                        break;
                    case("SPECIAL LUNCH"):
                        lunch.setIconId(R.drawable.special);
                        break;
                    default:
                        lunch.setIconId(R.drawable.lunch);
                        break;
                }


                JSONArray meals = c.getJSONArray("Meals");
                for (int j = 0; j < meals.length(); j++) {
                    Log.d("TAG", "meals lenght = " + meals.length());
                    JSONObject d = meals.getJSONObject(j);
                    if(j == 0) {
                        lunch.setHeadCourse(d.getString("Name"));
                    }
                    if(j == 1) {
                        lunch.setSideDish(d.getString("Name"));
                    }
                    if(j >= 2) {
                        lunch.setSecondSideDish(d.getString("Name"));
                    }
                }
                lunches.add(lunch);
            }
        } catch (final JSONException e) {
            Log.e("TAG", "Json parsing error: " + e.getMessage());
        }

        return lunches;
    }

}


