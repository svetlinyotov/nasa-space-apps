package com.snsdevelop.nasa.disaster.Services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.snsdevelop.nasa.disaster.Utils.StoredData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DisasterCheckerService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

        Handler handler = new Handler();
        int delay = 1 * 1000; //milliseconds

        Log.d("COOL", "asdasdasd");
        handler.postDelayed(() -> {
            try {
                URL url = new URL("http://snsdevelop.com/app.php");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.connect();
                try (BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line = rd.readLine();
                    Log.d("COOL", line);
                    StoredData.saveString(this, StoredData.DISASTER, line);
                } catch (IOException e) {
                    e.printStackTrace();
                    //NOP
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, delay);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
