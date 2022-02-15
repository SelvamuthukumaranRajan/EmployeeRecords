package com.example.employeerecords.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.employeerecords.EmployeeRecords;

import java.util.List;

@Dao
public interface RoomDatabaseDAO {
    @Insert
    void insert(EmployeeRecord model);

    @Delete
    void delete(EmployeeRecord model);

    @Query("SELECT * FROM EmployeeRecord")
    List<EmployeeRecord> getAllEmployeeRecord();

    @Query("DELETE FROM EmployeeRecord")
    void deleteAllRecords();
}
