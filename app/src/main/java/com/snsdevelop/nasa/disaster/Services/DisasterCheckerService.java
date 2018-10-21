package com.snsdevelop.nasa.disaster.Services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.snsdevelop.nasa.disaster.MainActivity;
import com.snsdevelop.nasa.disaster.R;
import com.snsdevelop.nasa.disaster.Utils.StoredData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisasterCheckerService extends Service {

    private final ExecutorService executors = Executors.newSingleThreadExecutor();
    private String CHANNEL_ID = "Chan_NASA_1";

    @Override
    public void onCreate() {
        super.onCreate();
        executors.submit(runnable(this));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private Runnable runnable(Context context) {
        return new Runnable() {

            private void makeConnection() throws InterruptedException {
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

                        JsonParser parser = new JsonParser();
                        JsonObject obj = parser.parse(line).getAsJsonObject();
                        String disaster = obj.get("disaster").getAsString();
                        Log.d("COOL", disaster);

                        if (!disaster.equals("null")) {
                            String name = "";
                            String expected = "";
                            if (disaster.equals("tornado")) {
                                name = "Tornado";
                                expected = "48 hours";
                            } else if (disaster.equals("flood")) {
                                name = "Flood";
                                expected = "24 hours";
                            }

                            String check = StoredData.getString(DisasterCheckerService.this, StoredData.DISASTER);
                            if ((check != null && check.equals("null")) || (check != null && !check.equals(disaster))) {
                                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                                        .setSmallIcon(R.drawable.ic_wb_sunny_black_24dp)
                                        .setContentTitle(name + " expected in your area")
                                        .setContentText("Please take necessary steps to be safe")
                                        .setStyle(new NotificationCompat.BigTextStyle()
                                                .bigText("The disaster is expected in " + expected))
                                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                if (mNotificationManager != null) {

                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        int importance = NotificationManager.IMPORTANCE_DEFAULT;
                                        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Disaster Notification", importance);
                                        mNotificationManager.createNotificationChannel(channel);
                                    }

                                    Intent notificationIntent = new Intent(context, MainActivity.class);

                                    notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                                            | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                                    PendingIntent intent = PendingIntent.getActivity(context, 0,
                                            notificationIntent, 0);

//                                    notification.setLatestEventInfo(context, title, message, intent);

                                    mNotificationManager.notify(1, mBuilder.build());
                                }
                            }
                        }

                        StoredData.saveString(DisasterCheckerService.this, StoredData.DISASTER, disaster);

                        Thread.sleep(5000);
                        makeConnection();
                    } catch (IOException e) {
                        e.printStackTrace();
                        //NOP
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void run() {
                try {
                    makeConnection();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
