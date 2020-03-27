package com.example.student_feedback;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete_records extends AppCompatActivity {
    Button delete;
    EditText delName;
    DBhelper myDB = new DBhelper(this);
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_records);
        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_black2));


        delete=(Button)findViewById(R.id.deleteBtn);
        delName=(EditText)findViewById(R.id.delnameEV);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = delName.getText().toString();
                if(name.length()==0){
                    delName.setError("Enter name");
                } else {
                    deletion(name);
                    delName.setText("");
                    Intent i = new Intent(delete_records.this,storage.class);
                    startActivity(i);
                }
            }
        });
    }
    public void deletion(String name){
        boolean isdeleted = myDB.delete_data(name);

        if (isdeleted) {
            Toast.makeText(this, "Successfully Deleted.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"No entry found named, "+name, Toast.LENGTH_LONG).show();
        }
    }

}
