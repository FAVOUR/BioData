package com.feghas.biodata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.feghas.biodata.R;

public class LoginActivity extends AppCompatActivity {
    EditText userName;
    EditText editTextPassword;

    String user_name;

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Window window = this.getWindow();
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        userName=(EditText)findViewById(R.id.username);
        editTextPassword=(EditText)findViewById(R.id.password);


    }

    public void getStarted(View view) {

        Intent getStarted= new Intent(LoginActivity.this,NavigationActivity.class);

        startActivity(getStarted);

//        user_name= userName.getText().toString().trim();
//        password=  editTextPassword.getText().toString().trim();
//        editTextPassword.setHint("Password");
//        editTextPassword.setHintTextColor(getResources().getColor(R.color.hinttext));
//        if (!user_name.isEmpty() && !password.isEmpty()){
//
//            if(user_name.equals("Admin") && password.equals("1010") ){
//
//                Toast.makeText(LoginActivity.this, "Authentication failed." ,Toast.LENGTH_SHORT).show();
//
//
//                Intent getStarted= new Intent(LoginActivity.this,NavigationActivity.class);
//
//               startActivity(getStarted);
//
//
//            }
//            else if (!user_name.equals("Admin") && password.equals("1010")){
//
//                userName.setText("");
//
//                userName.setHint("Wrong UserName");
//
//            }
//
//            else {
//                editTextPassword.setText("");
//
//                editTextPassword.setHint("Wrong Password");
//                editTextPassword.setHintTextColor(getResources().getColor(R.color.colorAccent));
//            }

//        }

//        Intent createAccount= new Intent(this,RegistrationActivity.class);
//        startActivity(createAccount);
    }

    public void createAccount(View view) {
//        Intent createAccount= new Intent(this,RegistrationActivity.class);
//        startActivity(createAccount);
    }
}
