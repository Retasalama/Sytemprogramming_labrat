package t.e.annotations;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

@EActivity
public class MainActivity extends AppCompatActivity implements ImageLoader.ImageLoaderInterface {

    private ArrayList<Bitmap> mushroomImages;
    private String[] mushroomNames;
    private String[] urls;
    private ImageLoader myImageLoader;
    private int clicks = 0;

    @ViewById(R.id.myUrlImage)
    ImageView mushroomImage;

    @ViewById(R.id.tvImageText)
    TextView mushroomName;

    @ViewById(R.id.buttonNext)
    Button buttonNext;

    @ViewById(R.id.determinateBar)
    ProgressBar progressBar;

    @Click
    void buttonNext() {
        if(clicks < mushroomNames.length && clicks < mushroomImages.size()) {
            buttonNext.setText(R.string.buttonNext);
            mushroomName.setText(mushroomNames[clicks]);
            mushroomImage.setImageBitmap(mushroomImages.get(clicks));
            clicks++;
        }
        if(clicks == mushroomNames.length){
            buttonNext.setText(R.string.startAgain);
            clicks = 0;

        }
    }

    @Background
    public void getImages() {
        myImageLoader.loadImages();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mushroomImages = new ArrayList<Bitmap>();

        //set the next-button invisible (waiting for imageloading)
        buttonNext.setVisibility(View.GONE);

        //get the url- and mushroomNames -arrays from resources
        Resources res = getResources();
        urls = res.getStringArray(R.array.urls);
        mushroomNames = res.getStringArray(R.array.mushroomNames);

        //create object from ImageLoader class and set listener
        myImageLoader = new ImageLoader(urls);
        myImageLoader.setListener(this);
        getImages();


    }

    // set mushroom name to texview and image to imageviw from index of value "cliks"
    @Override
    @UiThread
    public void setImages(ArrayList<Bitmap> bitmapArray) {
        mushroomImages = bitmapArray;
        mushroomName.setText(mushroomNames[clicks]);
        mushroomImage.setImageBitmap(mushroomImages.get(clicks));
        clicks++;

    }

    //shows progress and sets button visible when loading is done
    @Override
    @UiThread
    public void showProgress(int progress) {
        progressBar.setProgress(progress);
        if(progress >= 100) {
            progressBar.setVisibility(View.GONE);
            buttonNext.setVisibility(View.VISIBLE);
        }

    }
}
