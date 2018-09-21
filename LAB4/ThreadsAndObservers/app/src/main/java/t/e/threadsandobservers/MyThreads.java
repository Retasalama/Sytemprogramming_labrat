package t.e.threadsandobservers;

import android.util.Log;

public class MyThreads extends Thread {

    private int progressCounter = 0;
    private int progress = 0;
    private int threadIdentifier = 0;
    protected ExampleInterface notifier = null;

    public MyThreads(int identifier){
        this.threadIdentifier = identifier;
    }

    public void setNotifier(ExampleInterface notifier) {
        this.notifier = notifier;
    }

    public void run(){
        while(progressCounter < 10){
            try{
                sleep(3000);
                progress = progress + 10;
                if(notifier != null){
                    notifier.printProgress(progress, threadIdentifier);
                    Log.d("TAG1", "progress = " + progress + "threadIdentifier = " + threadIdentifier);
                }
                progressCounter++;
            }
            catch (Exception e) {
                //System.out.println("Keskeytys");
                return;
            }
        }
    }

}
