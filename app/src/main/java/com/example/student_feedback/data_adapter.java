package com.example.student_feedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class data_adapter extends RecyclerView.Adapter<data_adapter.viewHolder> {

    ArrayList<data> ilist;

    public data_adapter(ArrayList<data> datalist) {
        ilist = datalist;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_blueprint,parent,false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        data dts = ilist.get(position);
        holder.name.setText(dts.name);
        holder.college.setText(dts.college);
        holder.year.setText(dts.year);
        holder.email.setText(dts.email);
        holder.mobile.setText("+91-"+dts.mobile);
        holder.feedback.setText(dts.feedback);
        holder.write.setText(dts.write);
        holder.rating.setText(dts.rating+"");
        holder.time.setText(dts.time);
    }

    @Override
    public int getItemCount() {
        return ilist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView name, college, year, email, mobile, feedback, write, rating, time;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.nameTV);
            college = (TextView)itemView.findViewById(R.id.collegeTV);
            year = (TextView)itemView.findViewById(R.id.yearTV);
            email = (TextView)itemView.findViewById(R.id.emailTV);
            mobile = (TextView)itemView.findViewById(R.id.mobTV);
            feedback = (TextView)itemView.findViewById(R.id.feedbackTV);
            write = (TextView)itemView.findViewById(R.id.writeTV);
            rating = (TextView)itemView.findViewById(R.id.ratingTV);
            time = (TextView)itemView.findViewById(R.id.timeTV);
        }
    }
}
