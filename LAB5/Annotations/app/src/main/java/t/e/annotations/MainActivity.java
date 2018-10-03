package t.e.annotations;


import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringArrayRes;

import java.util.ArrayList;

@EActivity
public class MainActivity extends AppCompatActivity implements ImageLoader.ImageLoaderInterface {

    private ArrayList<Bitmap> mushroomImages;
    private int clicks = 0;
    private final int MAX_SIZE = 100;

    @ViewById(R.id.myUrlImage)
    ImageView mushroomImage;

    @ViewById(R.id.tvImageText)
    TextView mushroomName;

    @ViewById(R.id.buttonNext)
    Button buttonNext;

    @ViewById(R.id.determinateBar)
    ProgressBar progressBar;

    @AfterViews
    void setButtonInvisible (){
        buttonNext.setVisibility(View.GONE);
    }

    @StringArrayRes(R.array.urls)
    String[] urls;

    @StringArrayRes(R.array.mushroomNames)
    String[] mushroomNames;

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

        //create object from ImageLoader class and set listener
        ImageLoader myImageLoader = new ImageLoader(urls);
        myImageLoader.setListener(this);
        myImageLoader.loadImages();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getImages();


    }

    // set mushroom name to texview and image to imageviw from index of value "cliks"
    @Override
    @UiThread
    public void setImages(ArrayList<Bitmap> bitmapArray) {
        mushroomImages = new ArrayList<>();
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
        if(progress >= MAX_SIZE) {
            progressBar.setVisibility(View.GONE);
            buttonNext.setVisibility(View.VISIBLE);
        }

    }
}
