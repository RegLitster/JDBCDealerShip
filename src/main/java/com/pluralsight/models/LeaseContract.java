package com.pluralsight.models;

import java.time.LocalDate;

public class LeaseContract {

    private int id;
    private int vin;
    private String customerName;
    private String customerEmail;
    private LocalDate startDate;
    private LocalDate endDate;
    private double monthlyPayment;

    public LeaseContract() {}

    public LeaseContract(int id, int vin, String customerName, String customerEmail,
                         LocalDate startDate, LocalDate endDate, double monthlyPayment) {

        this.id = id;
        this.vin = vin;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyPayment = monthlyPayment;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getVin() { return vin; }

    public void setVin(int vin) { this.vin = vin; }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }

    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public LocalDate getStartDate() { return startDate; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public double getMonthlyPayment() { return monthlyPayment; }

    public void setMonthlyPayment(double monthlyPayment) { this.monthlyPayment = monthlyPayment; }

    @Override
    public String toString() {
        return "LeaseContract #" + id + " | VIN: " + vin +
                " | Customer: " + customerName +
                " | Monthly: $" + monthlyPayment +
                " | " + startDate + " to " + endDate;
    }
}
