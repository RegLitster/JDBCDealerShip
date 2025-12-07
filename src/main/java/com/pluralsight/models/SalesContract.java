package com.pluralsight.models;

import java.time.LocalDate;

public class SalesContract {

    private int id;
    private int vin;
    private String customerName;
    private String customerEmail;
    private double totalPrice;
    private double processingFee;
    private double salesTax;
    private LocalDate date;

    public SalesContract() {}

    public SalesContract(int id, int vin, String customerName, String customerEmail,
                         double totalPrice, double processingFee, double salesTax,
                         LocalDate date) {

        this.id = id;
        this.vin = vin;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.totalPrice = totalPrice;
        this.processingFee = processingFee;
        this.salesTax = salesTax;
        this.date = date;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getVin() { return vin; }

    public void setVin(int vin) { this.vin = vin; }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }

    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public double getProcessingFee() { return processingFee; }

    public void setProcessingFee(double processingFee) { this.processingFee = processingFee; }

    public double getSalesTax() { return salesTax; }

    public void setSalesTax(double salesTax) { this.salesTax = salesTax; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    @Override
    public String toString() {
        return "SaleContract #" + id + " | VIN: " + vin +
                " | Customer: " + customerName +
                " | Total: $" + totalPrice + " | Date: " + date;
    }
}
