package com.xnyu.mymaizi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.xnyu.mymaizi.utils.ShreadUtils;

/**
 * Created by Administrator on 2015/9/15 0015.
 */
public class Welcome extends AppCompatActivity {

    private boolean isFirst;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        isFirst = ShreadUtils.getWelcomBoolean(this);
        if (isFirst) {
            new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    startActivity(new Intent(Welcome.this, WelcomeGuideAct.class));
                    isFirst = false;
                    ShreadUtils.setWelcomeBoolean(getBaseContext(), false);
                    return false;
                }
            }).sendEmptyMessageDelayed(0, 3000);
        } else {

            new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    startActivity(new Intent(Welcome.this,MainActivity.class));
                    return false;
                }
            }).sendEmptyMessageDelayed(0,3000);
        }


        //        new Handler() {
        //            @Override
        //            public void handleMessage(Message msg) {
        //                super.handleMessage(msg);
        //                startActivity(new Intent(Welcome.this, MainActivity.class));
        //
        //            }
        //        }.sendEmptyMessageDelayed(0,3000);

        //        Timer timer = new Timer();
        //        timer.schedule(new TimerTask() {
        //            @Override
        //            public void run() {
        //                startActivity(new Intent(Welcome.this, MainActivity.class));
        //                finish();
        //            }
        //        },3000);
    }
}
