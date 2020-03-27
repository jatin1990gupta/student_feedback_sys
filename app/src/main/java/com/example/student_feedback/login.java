package com.example.student_feedback;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class login extends AppCompatActivity {

    EditText username, password;
    Button login;
    Window window;
    CheckBox showpass;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_black2));

        username = (EditText)findViewById(R.id.userEV);
        password = (EditText)findViewById(R.id.passEV);
        login = (Button)findViewById(R.id.logBtn);

        showpass = (CheckBox) findViewById(R.id.show_adminPassCB);

        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("abc")){

                    if(pass.equals("abc123")){

                        username.setText("");
                        password.setText("");

                        Intent i = new Intent(login.this,storage.class);
                        i.putExtra("admin_name", user);
                        startActivity(i);

                    } else {
                        password.setError("Password didn't match");
                    }
                } else {
                    username.setError("Check Username");
                }

            }
        });
    }

}
