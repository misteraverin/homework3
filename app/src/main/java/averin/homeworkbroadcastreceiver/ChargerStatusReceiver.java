package averin.homeworkbroadcastreceiver;

import android.support.annotation.MainThread;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;



public class ChargerStatusReceiver extends BroadcastReceiver{
    @Override
    @MainThread
    public void onReceive(Context context, Intent intent) {
        Intent mainIntent = new Intent(context, LoadService.class).putExtra("uri", MainActivity.uri);
        context.startService(mainIntent);
    }
}
