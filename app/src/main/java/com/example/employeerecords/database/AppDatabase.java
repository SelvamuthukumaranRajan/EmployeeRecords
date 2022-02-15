package com.example.employeerecords.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EmployeeRecord.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RoomDatabaseDAO roomDatabaseDAO();
}