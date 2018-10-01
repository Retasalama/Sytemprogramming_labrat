package t.e.annotations;


import android.content.res.Resources;
import android.graphics.Bitmap;

import java.util.ArrayList;


public class ImageLoader {

    ArrayList<Bitmap> bitmapArray;
    String[] urls;

    public ImageLoader(String[] aurls) {
        this.urls = aurls;
    }


    public void loadImages(){
        bitmapArray = new ArrayList<Bitmap>();


    }
}
