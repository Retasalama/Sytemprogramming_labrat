package t.e.runnable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {
    private Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button = new Button(this);
        button.setText("Do Time Consuming task!");
        setContentView(button);
        button.setOnClickListener(this);
    }

    @Override
    public void run() {
        try { Thread.sleep(5000);
        } catch (InterruptedException e) { e.printStackTrace();
        }
        button.post(new Update()); }

    @Override
    public void onClick(View v) {

    }

    class Update implements Runnable {
        public void run() {
        button.setText("Finished!"); }
    } }
