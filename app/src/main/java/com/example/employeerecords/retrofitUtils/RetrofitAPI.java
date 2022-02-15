package com.example.employeerecords.retrofitUtils;

import com.example.employeerecords.database.EmployeeRecord;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    String Base_URL = "https://crudcrud.com/api/1bb450249d784f6fbf1d6d0661a1cf44/";

    @GET("employees")
    Call<List<EmployeeRecord>> getEmployees();
}
