package com.example.employeerecords.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeerecords.EmployeeRecords;
import com.example.employeerecords.R;
import com.example.employeerecords.database.EmployeeRecord;

import java.util.List;

public class EmployeeRecordsAdapter extends RecyclerView.Adapter<EmployeeRecordsAdapter.MyViewHolder> {

    private LayoutInflater layoutInflater;
    List<EmployeeRecord> employeeRecordsList;
    Context context;

    public EmployeeRecordsAdapter(List<EmployeeRecord> employeeRecordsList, Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.employeeRecordsList = employeeRecordsList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.rv_employeedetails, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EmployeeRecordsAdapter.MyViewHolder holder, int position) {
        EmployeeRecord employeeRecord = employeeRecordsList.get(position);

        holder.name.setText(employeeRecord.getName());
        holder.email.setText(employeeRecord.getEmail());
        holder.mobile.setText(employeeRecord.getMobile());
        holder.gender.setText(employeeRecord.getGender());

    }

    @Override
    public int getItemCount() {
        return employeeRecordsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, email, mobile, gender;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            email = itemView.findViewById(R.id.tv_email);
            mobile = itemView.findViewById(R.id.tv_mobile);
            gender = itemView.findViewById(R.id.tv_gender);
        }
    }
}
