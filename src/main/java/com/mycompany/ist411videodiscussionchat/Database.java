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
    public void addRoom(String room, int roomID) {
        
        String sql = "INSERT INTO Room (RoomName, RoomID)"
                + "VALUES (?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, room);
            pstmt.setInt(2, roomID);
            
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public ArrayList<String> getRoomList() { 
        ArrayList<String> roomInfo = new ArrayList<String>();;
        String roomName = "";
        String roomID = "";

        
            String sql = "SELECT RoomName, RoomID FROM Room";//\n ID = " + 1;

            //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
            try (Connection conn = this.connect();
                  Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                  while(rs.next()) {

                      roomName = rs.getString("Name"); 
                      roomID = rs.getString("Street");

                      
                      roomInfo.add(roomName);
                      roomInfo.add(roomID);

                      
                  }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }           
            
        return roomInfo;
    }
}
