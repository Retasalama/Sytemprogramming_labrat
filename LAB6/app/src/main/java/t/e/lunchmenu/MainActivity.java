package t.e.lunchmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;
import java.util.HashMap;

@EActivity
public class MainActivity extends AppCompatActivity {

    private ArrayList<Lunches> lunchList;

    @Background
    void connect () {
        HTTPHandler httpHandler = new HTTPHandler();
        String result = httpHandler.makeServiceCall("https://www.amica.fi/api/restaurant/menu/day?date=2018-10-4&language=en&restaurantPageId=66287");
        if(result != null){
            JsonParser jsonParser = new JsonParser();
            lunchList = jsonParser.parseJSON(result);
        }
        for(Lunches lunch : lunchList) {
            String gatecory = lunch.getLunchGategory();
            String headCourse = lunch.getHeadCourse();
            String sideCourse = lunch.getSideDish();
            String sedondSideDish = lunch.getSecondSideDish();
            Log.d("TAG", "MEALS: " + gatecory + " ," + headCourse + " ," + sideCourse + " ," + sedondSideDish);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
    }
}
