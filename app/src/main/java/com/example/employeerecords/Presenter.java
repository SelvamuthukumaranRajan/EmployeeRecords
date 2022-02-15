package com.example.employeerecords;

import com.example.employeerecords.database.EmployeeRecord;

import java.util.ArrayList;
import java.util.List;

public class Presenter implements Contract.Presenter{

    private Contract.View view;
    private Contract.Model model;
    List<EmployeeRecord> employeeRecords = new ArrayList<>();

    public Presenter(Contract.View view, Contract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onLoadClick() {
        model.getAllDetails();
    }

    @Override
    public List<EmployeeRecord> onDeleteClick() {
        employeeRecords = model.removeAllDetails();
        return employeeRecords;
    }

    @Override
    public List<EmployeeRecord> onViewClick() {
        employeeRecords = model.prepareListForRecyclerView();
        return employeeRecords;
    }
}
