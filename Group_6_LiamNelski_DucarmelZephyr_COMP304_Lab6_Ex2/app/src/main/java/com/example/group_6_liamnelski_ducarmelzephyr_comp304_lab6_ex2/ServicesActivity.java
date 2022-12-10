package com.example.group_6_liamnelski_ducarmelzephyr_comp304_lab6_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class ServicesActivity extends AppCompatActivity {
    private TextView textView;
    //replace with your package name
    public static final String INFO_INTENT = "com.example.group_6_liamnelski_ducarmelzephyr_comp304_lab6_ex2";

    //This will handle the broadcast
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(SimpleService.INFO_INTENT)) {
//                String stringInfo = intent.getStringExtra(INFO_INTENT);
                int intInfo = intent.getIntExtra(SimpleService.INFO_INTENT, -1);
//                float floatInfo = intent.getFloatExtra(SimpleService.INFO_INTENT, -1);
//                textView.setText(stringInfo);
                textView.setText(Integer.toString(intInfo));
//                textView.setText(Float.toString(floatInfo));
          }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void onResume()
    {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(INFO_INTENT));
    }
    public void startService(View view) {
        startService(new Intent(getBaseContext(), SimpleService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(),
                SimpleService.class));
    }
}
