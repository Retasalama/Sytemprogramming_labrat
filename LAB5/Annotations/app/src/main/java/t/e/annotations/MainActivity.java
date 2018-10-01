package t.e.annotations;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.myUrlImage)
    ImageView mushroomImage;

    @Background
    public void getImages() {
        Resources res = getResources();
        String[] urls = res.getStringArray(R.array.urls);
        ImageLoader myImageLoader = new ImageLoader(urls);
        myImageLoader.loadImages();

    }

    @UiThread
    public void showImages() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getImages();
    }

}
