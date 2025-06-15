package com.ps.dealership;

public class LeaseContract {
    private int vehicleId;
    private String customerName;
    private String customerEmail;
    private double leasePrice;
    private double expectedEndValue;
    private double leaseFee;
    private double totalPrice;
    private double monthlyPayment;

    public LeaseContract() {
    }

    public LeaseContract(int vehicleId, String customerName, String customerEmail, double leasePrice, double expectedEndValue, double leaseFee, double totalPrice, double monthlyPayment) {
        this.vehicleId = vehicleId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.leasePrice = leasePrice;
        this.expectedEndValue = expectedEndValue;
        this.leaseFee = leaseFee;
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
                "vehicleId=" + vehicleId +
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
