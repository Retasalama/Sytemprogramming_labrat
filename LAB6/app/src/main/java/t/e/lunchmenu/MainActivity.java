package t.e.lunchmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;
import java.util.HashMap;

@EActivity
public class MainActivity extends AppCompatActivity {

    private ArrayList<String> lunchList;

    @Background
    void connect () {
        HTTPHandler httpHandler = new HTTPHandler();
        String result = httpHandler.makeServiceCall("https://www.amica.fi/api/restaurant/menu/day?date=2018-10-4&language=en&restaurantPageId=66287");
        if(result != null){
            JsonParser jsonParser = new JsonParser();
            lunchList = jsonParser.parseJSON(result);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
    }
}
