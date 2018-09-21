package t.e.datafetchexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NetworkLoaderThread.ResultInterface {

    private TextView resultView;
    private EditText giveUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = (TextView) findViewById(R.id.tv_results);
        giveUrl = (EditText) findViewById(R.id.et_giveUrl);

    }

    @Override
    public void threadProgress(final String data) {
        Log.d("TAG3", "DATA = " + data);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultView.setText(data);
            }
        });

    }

    public void sendUrl(View view) {
        String Url = giveUrl.getText().toString();
        Log.d("TAG1", "URL= "+ Url);
        NetworkLoaderThread networkLoaderThread = new NetworkLoaderThread(Url);
        networkLoaderThread.listener = this;
        networkLoaderThread.start();

    }
}
