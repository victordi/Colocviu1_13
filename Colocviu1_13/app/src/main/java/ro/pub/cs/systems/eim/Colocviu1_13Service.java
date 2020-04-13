package ro.pub.cs.systems.eim;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Date;

public class Colocviu1_13Service extends Service {
    private int startMode;

    @Override
    public void onCreate() {
        super.onCreate();
        // ...
    }

    @Override
    public int onStartCommand(Intent intent,
                              int flags,
                              int startId) {
        // ...
        String text = intent.getStringExtra("coordinates");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        Intent broadcast = new Intent();
        broadcast.setAction("bcast");
        broadcast.putExtra("time", new Date(System.currentTimeMillis())+ " " + text);
        Log.d("servicebcast", "sent broadcast with text: " + new Date(System.currentTimeMillis())+ " " + text);
        this.sendBroadcast(broadcast);
        return startMode;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // ...
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // ...
    }
}
