package com.example.student_feedback;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import java.util.ArrayList;

public class storage extends AppCompatActivity {

    RecyclerView rcv;
    data_adapter dadapter;
    ArrayList<data> dlist;
    DBhelper myDB = new DBhelper(this);
    ImageButton delete;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_black2));

        delete = (ImageButton)findViewById(R.id.deleteRecordsBtn);
        rcv = (RecyclerView)findViewById(R.id.recycler);
        dlist = myDB.getData();
        dadapter = new data_adapter(dlist);
        rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcv.setAdapter(dadapter);
        dadapter.notifyDataSetChanged();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(storage.this, delete_records.class);
                startActivity(i);
            }
        });
    }

}
