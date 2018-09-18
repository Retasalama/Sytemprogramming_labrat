package t.e.datafetchexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultView;
    private EditText giveUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = (TextView)findViewById(R.id.tv_results);
        giveUrl = (EditText)findViewById(R.id.et_giveUrl);

    }
}
