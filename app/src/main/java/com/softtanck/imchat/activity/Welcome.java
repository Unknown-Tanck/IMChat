/**
 *
 */
package com.softtanck.imchat.activity;


import com.softtanck.imchat.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

/**
 * @author Administrator
 */
public class Welcome extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent();
                SharedPreferences share = getSharedPreferences("mydata", Context.MODE_PRIVATE);
                boolean isfirst = share.getBoolean(Guidance.IS_FIRST, true); //第一次进入的时候还没存值进入  所以默认返回true
                if (isfirst) {
                    intent.setClass(Welcome.this, Guidance.class);
                } else {
                    intent.setClass(Welcome.this, Login.class);
                }
                startActivity(intent);
                finish();
            }
        }, 500);
    }

}
