package com.ps.dealership;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseContractDAO {
    private final DataSource dataSource = DatabaseManager.getDataSource();

    public void save(LeaseContract contract){
        String sql = "INSERT INTO lease_contracts" +
                "(vin, customer_name, customer_email, lease_price, expected_end_value" +
                "lease_fee, total_price, monthly_payment)" +
                "VALUES (? + ? + ? + ? + ? + ? + ? + ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, contract.getVin());
            statement.setString(2, contract.getCustomerName());
            statement.setString(3, contract.getCustomerEmail());
            statement.setDouble(4, contract.getLeasePrice());
            statement.setDouble(5, contract.getExpectedEndValue());
            statement.setDouble(6, contract.getLeaseFee());
            statement.setDouble(7, contract.getTotalPrice());
            statement.setDouble(8, contract.getMonthlyPayment());

            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
