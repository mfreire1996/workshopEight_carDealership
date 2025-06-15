package com.ps.dealership;

public class SalesContract {
    private int vehicleId;
    private String customerName;
    private String customerEmail;
    private double salesPrice;
    private double salesTax;
    private double processingFee;
    private double totalPrice;
    private double monthlyPayment;

    public SalesContract() {
    }

    public SalesContract(int vehicleId, String customerName, String customerEmail, double salesPrice, double salesTax, double processingFee, double totalPrice, double monthlyPayment) {
        this.vehicleId = vehicleId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.salesPrice = salesPrice;
        this.salesTax = salesTax;
        this.processingFee = processingFee;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "vehicleId=" + vehicleId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", salesPrice=" + salesPrice +
                ", salesTax=" + salesTax +
                ", processingFee=" + processingFee +
                ", totalPrice=" + totalPrice +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
