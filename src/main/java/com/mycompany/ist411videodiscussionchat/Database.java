/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ist411videodiscussionchat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class Database {

    private String dbName;
    private final String url;

    public Database(String dbName) {
        this.dbName = dbName;
        url = "jdbc:sqlite:" + dbName; //dbName name of the .db file
    }

    public Connection connectToDatabase() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to db " + dbName + " is established");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return conn;
    }

    private Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return conn;
    }
    
        /**
     * @param name
     * @param street
     * @param state
     * @param zip
     * @param country
     */
    public void addAddress(String name, String street, String state, String zip, String country) {
        
        String sql = "INSERT INTO IST411Lab (Name, Street, State, Zip)"
                + "VALUES (?,?,?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, street);
            pstmt.setString(3, state);
            pstmt.setString(4, zip);
            
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public ArrayList<String> getAddressList() { 
        ArrayList<String> addressInfo = new ArrayList<String>();;
        String name = "";
        String street = "";
        String state = "";
        String zip  = "";

        
            String sql = "SELECT Name, Street, "
                        + "State, Zip FROM IST411Lab";//\n ID = " + 1;

            //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
            try (Connection conn = this.connect();
                  Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                  while(rs.next()) {

                      name = rs.getString("Name"); 
                      street = rs.getString("Street");
                      state = rs.getString("State");
                      zip = rs.getString("Zip");
                      
                      addressInfo.add(name);
                      addressInfo.add(street);
                      addressInfo.add(state); 
                      addressInfo.add(zip);
                      
                  }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }           
            
        return addressInfo;
    }
}
