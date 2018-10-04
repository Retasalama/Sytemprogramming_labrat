package t.e.lunchmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@EActivity
public class MainActivity extends AppCompatActivity {

    private List<Lunches> lunchList;

    @ViewById(R.id.my_recycler_view)
    RecyclerView recyclerView;

    @Background
    void connect () {
        HTTPHandler httpHandler = new HTTPHandler();
        String result = httpHandler.makeServiceCall("https://www.amica.fi/api/restaurant/menu/day?date=2018-10-4&language=en&restaurantPageId=66287");
        if(result != null){
            JsonParser jsonParser = new JsonParser();
            lunchList = jsonParser.parseJSON(result);
        }
        //DEBUGGAUS VARTEN, POISTA
        for(Lunches lunch : lunchList) {
            String gatecory = lunch.getLunchGategory();
            String headCourse = lunch.getHeadCourse();
            String sideCourse = lunch.getSideDish();
            String sedondSideDish = lunch.getSecondSideDish();
            int iconId = lunch.getIconId();
            Log.d("TAG", "MEALS: " + gatecory + " ," + headCourse + " ," + sideCourse + " ," + sedondSideDish + " ," + iconId);
        }
        setLunchList();

    }
    @UiThread
    void setLunchList() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(lunchList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
       /* LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(lunchList);
        recyclerView.setAdapter(adapter);*/
    }
}
