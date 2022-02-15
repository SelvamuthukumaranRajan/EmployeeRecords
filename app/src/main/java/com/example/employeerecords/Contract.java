package com.example.employeerecords;

import com.example.employeerecords.database.EmployeeRecord;

import java.util.List;

public interface Contract {
    interface View {
        void prepareListForRecyclerView(List<EmployeeRecord> employeeRecords);
    }

    interface Model {
        void getAllDetails();

        List<EmployeeRecord> prepareListForRecyclerView();

        List<EmployeeRecord> removeAllDetails();
    }

    interface Presenter {
        void onLoadClick();

        List<EmployeeRecord> onDeleteClick();

        List<EmployeeRecord> onViewClick();
    }
}
