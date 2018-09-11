package t.e.threadexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Observable;
import java.util.Observer;


public class ThreadExample extends AppCompatActivity implements View.OnClickListener {

    private Button buttonStart;
    private Button buttonStop;
    private TextView tv;
    private MyThread thread;
    private boolean isInterrupted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example);

        buttonStart = (Button)findViewById(R.id.button_start);
        buttonStop = (Button)findViewById(R.id.button_stop);
        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        tv = (TextView)findViewById(R.id.tv_texts);
        isInterrupted = false;

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_start && !thread.isAlive()) {
            if(isInterrupted){
                thread = new MyThread();
            }
            tv.setText("Starting thread");
            thread.start();
        }
        else if(v.getId() == R.id.button_stop && thread.isAlive()){
            thread.interrupt();
            isInterrupted = true;
        }
    }
}
