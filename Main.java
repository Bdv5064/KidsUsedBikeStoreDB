import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            // Establish a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KidsUsedBikeStore", "root", "SQLW@ta$h!#914");

            // Create a statement
            Statement stmt = conn.createStatement();

            // SQL statement for creating a new table
            String sql = "CREATE TABLE IF NOT EXISTS Customer (" +
                    "CustID INT PRIMARY KEY, " +
                    "FName VARCHAR(255), " +
                    "LName VARCHAR(255), " +
                    "EMail VARCHAR(255), " +
                    "Phone VARCHAR(255), " +
                    "Address VARCHAR(255)" +
                    ");";
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS BikeInventory (" +
                    "BikeID INT PRIMARY KEY, " +
                    "BikeMake VARCHAR(255), " +
                    "BikeModel VARCHAR(255), " +
                    "Price DECIMAL(10, 2)" +
                    ");";
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS Orders (" +
                    "OrderID INT PRIMARY KEY, " +
                    "BikeID INT, " +
                    "CustID INT, " +
                    "DateOfPurchase DATE, " +
                    "TotalPrice DECIMAL(10, 2), " +
                    "FOREIGN KEY (BikeID) REFERENCES BikeInventory(BikeID)" +
                    ");";
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS OrderDetails (" +
                    "OrderID INT PRIMARY KEY, " +
                    "CustID INT, " +
                    "FName VARCHAR(255), " +
                    "LName VARCHAR(255), " +
                    "DateOfPurchase DATE, " +
                    "BikeMake VARCHAR(255), " +
                    "BikeModel VARCHAR(255), " +
                    "Price DECIMAL(10, 2), " +
                    "TotalPrice DECIMAL(10, 2), " +
                    "FOREIGN KEY (CustID) REFERENCES Customer(CustID)" +
                    ");";
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS CustomerLogin (" +
                    "CustID INT PRIMARY KEY, " +
                    "Email VARCHAR(255), " +
                    "Password VARCHAR(24), " +
                    "FOREIGN KEY (CustID) REFERENCES Customer(CustID)" +
                    ");";
            stmt.execute(sql);

            System.out.println("Tables created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
