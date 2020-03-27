package com.example.student_feedback;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText fnameEV, lnameEV, collegeEV, writeEV, emailEV, mobEV;
    RadioButton RB1, RB2, RB3, RB4, FD1, FD2, FD3, FD4;
    RatingBar ratingR;
    Button smtBtn;
    DBhelper myDB = new DBhelper(this);
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_black2));

        fnameEV = (EditText)findViewById(R.id.fnameEV);
        lnameEV = (EditText)findViewById(R.id.lnameEV);
        collegeEV = (EditText)findViewById(R.id.collegeEV);
        RB1 = (RadioButton)findViewById(R.id.yearRB_1);
        RB2 = (RadioButton)findViewById(R.id.yearRB_2);
        RB3 = (RadioButton)findViewById(R.id.yearRB_3);
        RB4 = (RadioButton)findViewById(R.id.yearRB_4);
        emailEV = (EditText)findViewById(R.id.emailEV);
        mobEV = (EditText)findViewById(R.id.mobEV);
        FD1 = (RadioButton)findViewById(R.id.feed_1);
        FD2 = (RadioButton)findViewById(R.id.feed_2);
        FD3 = (RadioButton)findViewById(R.id.feed_3);
        FD4 = (RadioButton)findViewById(R.id.feed_4);
        writeEV =(EditText)findViewById(R.id.writeEV);
        ratingR = (RatingBar)findViewById(R.id.ratingR);
        smtBtn = (Button)findViewById(R.id.submitBtn);


        smtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fnameEV.getText().toString()+" "+lnameEV.getText().toString() ;
                String college = collegeEV.getText().toString();

                String year = null;
                if(RB1.isChecked()){
                    year = RB1.getText().toString();
                } else if(RB2.isChecked()){
                    year = RB2.getText().toString();
                } else if(RB3.isChecked()){
                    year = RB3.getText().toString();
                } else if(RB4.isChecked()){
                    year = RB4.getText().toString();
                }

                String email = emailEV.getText().toString();
                String mobile = mobEV.getText().toString();

                String feedback = null;
                if(FD1.isChecked()){
                    feedback = FD1.getText().toString();
                } else if(FD2.isChecked()){
                    feedback = FD2.getText().toString();
                } else if(FD3.isChecked()){
                    feedback = FD3.getText().toString();
                } else if(FD4.isChecked()){
                    feedback = FD4.getText().toString();
                }


                String write = writeEV.getText().toString();
                int rating = ratingR.getProgress();
                String time = getCurrentTimeStamp();

                if(name.length()==0||college.length()==0||email.length()==0||write.length()==0||rating==0) {
                    Toast.makeText(MainActivity.this, "Fields can't be empty", Toast.LENGTH_LONG).show();
                } else if(year==null) {
                    Toast.makeText(MainActivity.this, "Please Select Year of Study..!", Toast.LENGTH_LONG).show();
                } else if(feedback==null) {
                    Toast.makeText(MainActivity.this, "Please Enter Feedback..!", Toast.LENGTH_LONG).show();
                } else if(mobile.length()!=10) {
                    Toast.makeText(MainActivity.this, "Please Enter a 10-digit Mobile number..!", Toast.LENGTH_LONG).show();
                } else {
                    data dts = new data(name, college, year, email, mobile, feedback, write, rating, time);
                    boolean inserted = myDB.insert(dts);

                    if (inserted) {
                        Toast.makeText(MainActivity.this, "DATA INSERTED SUCCESSFULLY", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(MainActivity.this, front.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(MainActivity.this, "ERROR IN SUBMISSION", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static String getCurrentTimeStamp(){
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
