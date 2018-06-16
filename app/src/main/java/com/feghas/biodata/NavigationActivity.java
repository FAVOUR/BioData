
package com.feghas.biodata;


import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.feghas.biodata.R;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
    }

    public void userlogin(View view) {

        Intent userlogin= new Intent(NavigationActivity.this,UserLoginActivity.class);

        startActivity(userlogin);
    }

    public void upload(View view) {

        Intent upload= new Intent(NavigationActivity.this,NavigationActivity.class);

        startActivity(upload);
    }

    public void download(View view) {

        Intent download= new Intent(NavigationActivity.this,NavigationActivity.class);

        startActivity(download);
    }

    public void identification(View view) {

        Intent identification= new Intent(NavigationActivity.this,NavigationActivity.class);

        startActivity(identification);
    }

    public void about(View view) {

        Intent about= new Intent(NavigationActivity.this,NavigationActivity.class);

        startActivity(about);
    }

    public void settings(View view) {


        Intent settings= new Intent(NavigationActivity.this,NavigationActivity.class);

        startActivity(settings);
    }

    public void logout(View view) {


        Intent logout= new Intent(NavigationActivity.this,NavigationActivity.class);

        startActivity(logout);
    }
}
