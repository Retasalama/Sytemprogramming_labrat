package t.e.threadsandobservers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ExampleInterface {

    private TextView tv;
    private ArrayList<MyThreads> threads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv_texts);
        threads = new ArrayList<MyThreads>();
        Button button = findViewById(R.id.button_start_thread);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MyThreads thread = new MyThreads(threads.size() + 1);
        threads.add(thread);
        Log.d("TAG0", "THREADSIZE = " + threads.size());
        thread.notifier = this;
        thread.start();
    }

    @Override
    public void printProgress(final int progress, final int threadCounter) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv.append("Thread " + threadCounter + " progress " + progress + "\n");
            }
        });

    }
}
