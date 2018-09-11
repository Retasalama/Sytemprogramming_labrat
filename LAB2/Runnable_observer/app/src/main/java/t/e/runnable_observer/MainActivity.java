package t.e.runnable_observer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String texts = "";
    private Button buttonStart;
    private Button buttonStop;
    private TextView tv;
    private MyThread myThread;
    private Thread thread;
    private boolean isInterrupted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.tv_texts);
        tv.setMovementMethod(new ScrollingMovementMethod());
        buttonStart = (Button)findViewById(R.id.button_start);
        buttonStop = (Button)findViewById(R.id.button_stop);
        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        isInterrupted = false;
        myThread = new MyThread();
        thread = new Thread(myThread);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button_start && !thread.isAlive()) {
            if(isInterrupted){
                myThread = new MyThread();
                thread = new Thread(myThread);
            }

            // To add the observer and start a thread

            myThread.addObserver(new Observer() {
                @Override
                public void update(Observable o, Object arg) {
                    texts = texts + (arg) + "\n";
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            tv.setText(texts);

                        }
                    });

                }
            });

            thread.start();
            texts = texts + "Starting a thread" + "\n";
        }
        else if(v.getId() == R.id.button_stop && thread.isAlive()){
            //interrupt thread
            thread.interrupt();
            isInterrupted = true;
            texts = texts + "Interrupting a thread \n";
            tv.setText(texts);
        }

    }
}

