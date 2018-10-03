package t.e.annotations;


import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


public class ImageLoader {

    ArrayList<Bitmap> bitmapArray;
    String[] urls;
    Bitmap bmImg;
    URL photoUrl;
    int progress = 20;
    protected ImageLoaderInterface listener = null;

    public ImageLoader(String[] aurls) {
        this.urls = aurls;
    }

    protected interface ImageLoaderInterface {
        void setImages(ArrayList<Bitmap> bitmapArray);
        void showProgress(int progress);
    }
    public void setListener(ImageLoaderInterface aListener) {
        this.listener = aListener;
    }


    public void loadImages(){
        bitmapArray = new ArrayList<Bitmap>();
        photoUrl =null;
        for(int i = 0 ; i < urls.length ; i++) {
            try {
                photoUrl= new URL(urls[i]);
                Log.d("URL", "Haettu url on " + photoUrl);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                HttpURLConnection connection = (HttpURLConnection)photoUrl.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                bmImg = BitmapFactory.decodeStream(input);
                bitmapArray.add(bmImg);
                Log.d("BITMAP", "bitmaparray size on " + bitmapArray.size());

            } catch (IOException e) {
                e.printStackTrace();
            }
            if(listener != null) {
                listener.showProgress(progress);
                progress = progress + 20;
            }

        }

        if(listener != null){
            listener.setImages(bitmapArray);
        }

    }
}
