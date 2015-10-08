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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    final static String Tag = "com.zqu.test";
    private EditText name;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_layout);

        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);

    }

    public void Login(View v) {

        String s1 = name.getText().toString();
        String s2 = password.getText().toString();
        Toast.makeText(getApplicationContext(), "帐号：" + s1 + "\n密码：" + s2,
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();

        intent.setClass(Login.this, Sliding_Main.class);
        intent.putExtra("name", s1);
        intent.putExtra("pwd", s2);
        startActivity(intent);
        finish();
    }

}
