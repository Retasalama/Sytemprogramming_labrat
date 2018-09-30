package t.e.notepad;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = findViewById(R.id.myText);
        try{
            SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
            String text = sharedPref.getString("myFile", "Hello World");
            myText.setText(text);

        } catch (Exception e) {
            Log.d("TAG1", "File not found or other error");
            myText.setText(R.string.errorText);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("myFile", myText.getText().toString());
        editor.apply();
    }
}
