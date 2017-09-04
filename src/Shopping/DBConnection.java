/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shopping;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kamil
 */
public class DBConnection {

    private Connection conn;
    private Frame parent;
    

    public Connection connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connected");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Connection failed");
        }
        String url1 = "jdbc:mysql://localhost:3306/shoppinglistdb";
        String user = "root";
        String password = "";

        try {

            conn = DriverManager.getConnection(url1, user, password);
            System.out.println("Connected to the database shoppinglistdb");
           

        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            new DBFailed(parent, true).setVisible(true);
            ex.printStackTrace();
        }
        return conn;
    }
}
