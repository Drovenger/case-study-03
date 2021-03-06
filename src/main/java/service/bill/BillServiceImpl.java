package main.java.service.bill;

import main.java.model.Bill;
import main.java.util.DBHandle;
import main.java.util.Query;

import javax.jms.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillServiceImpl implements BillService {

    public BillServiceImpl() {
    }

    public Bill selectBill(int id) {
        Bill bill = null;
        try (
                PreparedStatement preparedStatement = DBHandle.getConnection().prepareStatement(Query.SELECT_BILL_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String message = rs.getString("message");
                double discount = rs.getDouble("discount");
                double shipping_fee = rs.getDouble("shipping_fee");
                String payment = rs.getString("payment");
                Date date_of_payment = rs.getDate("date_of_payment");
                int status = rs.getInt("status");
                Date create_date = rs.getDate("create_date");
                Date update_date = rs.getDate("update_date");
                bill = new Bill(id, user_id, message, discount, shipping_fee, payment, date_of_payment, status, create_date, update_date);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bill;
    }


    public List<Bill> selectAllBills(int offset, int noOfRecords) {
        List<Bill> bills = new ArrayList<>();
        String query = "select SQL_CALC_FOUND_ROWS * from bill limit "
                + offset + ", " + noOfRecords;

        try (
                PreparedStatement preparedStatement = DBHandle.getConnection().prepareStatement(Query.SELECT_ALL_BILLS);
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String message = rs.getString("message");
                double discount = rs.getDouble("discount");
                double shipping_fee = rs.getDouble("shipping_fee");
                String payment = rs.getString("payment");
                Date date_of_payment = rs.getDate("date_of_payment");
                int status = rs.getInt("status");
                Date create_date = rs.getDate("create_date");
                Date update_date = rs.getDate("update_date");
                bills.add(new Bill(id, user_id, message, discount, shipping_fee, payment, date_of_payment, status, create_date, update_date));
            }
            rs.close();

            rs = preparedStatement.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next())
                this.noOfRecords = rs.getInt(1);

        } catch (SQLException e) {
            printSQLException(e);
        }
        return bills;
    }

    private int noOfRecords;

    public int getNoOfRecords() {
        return noOfRecords;
    }

    public boolean updateBill(Bill bill) throws SQLException {
        boolean rowUpdated;
        try (
                PreparedStatement statement = DBHandle.getConnection().prepareStatement(Query.UPDATE_BILLS_SQL);) {
            statement.setInt(2, bill.getId());
            statement.setDouble(1, bill.getStatus());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}