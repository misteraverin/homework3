package averin.homeworkbroadcastreceiver;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;



public class LoadService extends IntentService {

    public LoadService() {
        super("LoadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            URL url = new URL(intent.getStringExtra("uri"));
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            FileOutputStream imageFile = openFileOutput("kitten.jpg", Context.MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, imageFile);
            imageFile.close();
            sendBroadcast(new Intent(MainActivity.BROADCAST_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




