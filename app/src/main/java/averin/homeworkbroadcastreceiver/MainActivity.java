package averin.homeworkbroadcastreceiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    final String fileName = "kitten.jpg";
    public final static String BROADCAST_NAME = "averin.homeworkbroadcastreceiver";
    public static String uri = "http://murkote.com/wp-content/uploads/2015/06/european-shorthair-cat-4.jpg.pagespeed.ce.TVNug3Lg3z.jpg";
    ImageView mainImage;
    TextView textError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainImage = (ImageView) findViewById(R.id.picture);
        textError = (TextView) findViewById(R.id.text_error);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
               showImage();
            }
        };
        showImage();
        IntentFilter filter = new IntentFilter(BROADCAST_NAME);
        registerReceiver(receiver, filter);
    }


    private void showImage(){
        File imageFile = new File(getFilesDir(), fileName);
        if (imageFile.exists()) {
            mainImage.setImageBitmap(BitmapFactory.decodeFile(imageFile.getPath()));
            mainImage.setVisibility(View.VISIBLE);
            textError.setVisibility(View.GONE);
        }
    }
}
