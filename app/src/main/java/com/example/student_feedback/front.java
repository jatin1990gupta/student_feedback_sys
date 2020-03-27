package com.example.student_feedback;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Window;
import android.widget.Button;

public class front extends AppCompatActivity {

    Button fill, login;
    Window window;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_black2));

        fill = (Button)findViewById(R.id.fillBtn);
        login = (Button)findViewById(R.id.loginBtn);

        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(front.this,MainActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(front.this,login.class);
                startActivity(i);
            }
        });


    }

}
