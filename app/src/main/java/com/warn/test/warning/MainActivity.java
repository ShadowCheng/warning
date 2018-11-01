package com.warn.test.warning;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.warn.test.utils.MyApplication;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openWarning(View view){
        TextView textView = findViewById(R.id.textView);
        //启动后台监听服务
        Intent intent = new Intent();
        intent.setAction("myService");
        intent.setPackage(getPackageName());
        MyApplication.getContext().startService(intent);
        textView.setText("服务已经启动！");
    }

    public void closeWarning(View view){
        TextView textView = findViewById(R.id.textView);
        //关闭后台监听服务
        Intent intent = new Intent();
        intent.setAction("myService");
        intent.setPackage(getPackageName());
        MyApplication.getContext().stopService(intent);
        textView.setText("服务关闭");
    }
}
