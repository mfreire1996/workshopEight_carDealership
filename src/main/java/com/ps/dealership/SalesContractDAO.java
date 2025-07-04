package com.ps.dealership;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesContractDAO {
    private final DataSource dataSource = DatabaseManager.getDataSource();

    public void save(SalesContract contract){
        String sql = "INSERT INTO sales_contracts " +
                "(vin, customer_name, customer_email, sales_price, sales_tax, processing_fee, total_price, monthly_payment) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, contract.getVin());
            statement.setString(2, contract.getCustomerName());
            statement.setString(3, contract.getCustomerEmail());
            statement.setDouble(4, contract.getSalesPrice());
            statement.setDouble(5, contract.getSalesTax());
            statement.setDouble(6, contract.getProcessingFee());
            statement.setDouble(7, contract.getTotalPrice());
            statement.setDouble(8, contract.getMonthlyPayment());

            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
