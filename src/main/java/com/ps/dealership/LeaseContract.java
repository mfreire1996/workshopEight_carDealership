package com.ps.dealership;

public class LeaseContract {
    private String vin;
    private String customerName;
    private String customerEmail;
    private double leasePrice;
    private double expectedEndValue;
    private double leaseFee;
    private double totalPrice;
    private double monthlyPayment;

    public LeaseContract() {
    }

    public LeaseContract(String vin, String customerName, String customerEmail, double leasePrice, double expectedEndValue, double leaseFee, double totalPrice, double monthlyPayment) {
        this.vin = vin;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.leasePrice = leasePrice;
        this.expectedEndValue = expectedEndValue;
        this.leaseFee = leaseFee;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public double getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(double leasePrice) {
        this.leasePrice = leasePrice;
    }

    public double getExpectedEndValue() {
        return expectedEndValue;
    }

    public void setExpectedEndValue(double expectedEndValue) {
        this.expectedEndValue = expectedEndValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
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
        return "LeaseContract{" +
                "vin=" + vin +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", leasePrice=" + leasePrice +
                ", expectedEndValue=" + expectedEndValue +
                ", leaseFee=" + leaseFee +
                ", totalPrice=" + totalPrice +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
