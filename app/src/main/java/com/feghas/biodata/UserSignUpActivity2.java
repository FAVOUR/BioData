package com.feghas.biodata;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.feghas.biodata.R;

public class UserSignUpActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up2);
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.signup_actionbar);
    }

    public void secondStep(View view) {

        Intent nextStep = new Intent (UserSignUpActivity2.this ,UserSignUpActivity3.class);
        startActivity(nextStep);
    }
}
