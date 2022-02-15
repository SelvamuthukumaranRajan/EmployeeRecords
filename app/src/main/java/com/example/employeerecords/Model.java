package com.example.employeerecords;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.employeerecords.database.DatabaseClient;
import com.example.employeerecords.database.EmployeeRecord;
import com.example.employeerecords.retrofitUtils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.employeerecords.MainActivity.applicationContext;

public class Model implements Contract.Model {

    List<EmployeeRecord> employeeRecords = new ArrayList<>();

    @Override
    public void getAllDetails() {
        Call<List<EmployeeRecord>> employeeRecordsCall = RetrofitClient.getInstance().getMyAPI().getEmployees();
        employeeRecordsCall.enqueue(new Callback<List<EmployeeRecord>>() {
            @Override
            public void onResponse(Call<List<EmployeeRecord>> call, Response<List<EmployeeRecord>> response) {
                employeeRecords = response.body();
                DatabaseClient
                        .getInstance(applicationContext)
                        .getAppDatabase()
                        .roomDatabaseDAO()
                        .deleteAllRecords();
                for(EmployeeRecord employeeRecord : employeeRecords){
                    DatabaseClient.getInstance(applicationContext).getAppDatabase()
                            .roomDatabaseDAO()
                            .insert(employeeRecord);
                }
            }
            @Override
            public void onFailure(Call<List<EmployeeRecord>> call, Throwable t) {

            }
        });
    }

    @Override
    public List<EmployeeRecord>  prepareListForRecyclerView() {
        employeeRecords = DatabaseClient
                .getInstance(applicationContext)
                .getAppDatabase()
                .roomDatabaseDAO()
                .getAllEmployeeRecord();
        return employeeRecords;
    }

    @Override
    public List<EmployeeRecord>  removeAllDetails() {
//        for(EmployeeRecord employeeRecord : employeeRecords){
//            DatabaseClient.getInstance(applicationContext).getAppDatabase()
//                    .roomDatabaseDAO()
//                    .delete(employeeRecord);
//        }
        DatabaseClient
                .getInstance(applicationContext)
                .getAppDatabase()
                .roomDatabaseDAO()
                .deleteAllRecords();
        employeeRecords.clear();
        return employeeRecords;
    }


}
