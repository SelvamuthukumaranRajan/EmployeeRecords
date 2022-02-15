package com.example.employeerecords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.employeerecords.adapter.EmployeeRecordsAdapter;
import com.example.employeerecords.database.DatabaseClient;
import com.example.employeerecords.database.EmployeeRecord;
import com.example.employeerecords.databinding.ActivityMainBinding;
import com.example.employeerecords.retrofitUtils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Contract.View {

    ActivityMainBinding activityMainBinding;
    Contract.Presenter presenter;
    List<EmployeeRecord> employeeRecords = new ArrayList<>();

    public static Context applicationContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        activityMainBinding.layoutRecords.setVisibility(View.GONE);

        presenter = new Presenter(this, new Model());
        applicationContext = getApplicationContext();

        activityMainBinding.btLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLoadClick();
                Toast.makeText(MainActivity.this, "Employee Record Populated", Toast.LENGTH_SHORT).show();
            }
        });

        activityMainBinding.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeeRecords = presenter.onDeleteClick();
                prepareListForRecyclerView(employeeRecords);
                activityMainBinding.layoutRecords.setVisibility(View.GONE);
            }
        });

        activityMainBinding.btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeeRecords = presenter.onViewClick();
                if(employeeRecords != null) {
                    if (employeeRecords.size() != 0)
                        prepareListForRecyclerView(employeeRecords);
                    else
                        Toast.makeText(MainActivity.this, "Employee Record is empty", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Employee Record is empty", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void prepareListForRecyclerView(List<EmployeeRecord> employeeRecords) {
        activityMainBinding.layoutRecords.setVisibility(View.VISIBLE);
        EmployeeRecordsAdapter employeeRecordsAdapter = new EmployeeRecordsAdapter(employeeRecords, this);
        activityMainBinding.rvEmployeeList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        activityMainBinding.rvEmployeeList.setAdapter(employeeRecordsAdapter);
    }
}