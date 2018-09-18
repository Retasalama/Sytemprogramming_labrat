package com.example.veikko.weathergetter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetThread extends Thread {

    private String givenURL;
    private String allData;
    protected OnRequestDoneInterface listener = null;

    public HTTPGetThread(String aURL, OnRequestDoneInterface aListener) {
        this.givenURL = aURL;
        this.listener = aListener;
    }

    public interface OnRequestDoneInterface {
        void onRequestDone(String data);

    }
    /*public void setListener(ResultInterface aListener) {
        this.listener = aListener;
    }*/

    @Override
    public void run() {
        try {
            loadStuff();
        }
        catch (Exception e) {
            System.out.println("Exception e");

        }

    }

    private void loadStuff() {
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(givenURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            allData = fromStream(in);
            if(listener != null){
                listener.onRequestDone(allData);
            }
            in.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }
        }
    }
    public static String fromStream(InputStream in) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }

}
