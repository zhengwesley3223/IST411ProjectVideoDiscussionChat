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
    
    public void addRoom(String room) {
        
        String sql = "INSERT INTO Room (RoomName) VALUES (?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, room);
            
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public void addVideo(String room, String videoID) {
        
        String sql = "INSERT INTO VideoURL (RoomName, URL)"
                + "VALUES (?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, room);
            pstmt.setString(2, videoID);
            
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public ArrayList<String> getRoomList() { 
        ArrayList<String> roomInfo = new ArrayList<String>();;
        String roomName = "";
        String roomID = "";

        
            String sql = "SELECT RoomName FROM Room";//\n ID = " + 1;

            //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
            try (Connection conn = this.connect();
                  Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                  while(rs.next()) {

                      roomName = rs.getString("RoomName"); 
                      
                      roomInfo.add(roomName);
                      
                  }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }           
            
        return roomInfo;
    }
        
        public ArrayList<String> getVideoList(String RoomName) { 
        ArrayList<String> videoArray = new ArrayList<String>();;
        String roomName = "";
        String videoIDs = "";

        
            String sql = "SELECT URL FROM VideoURL WHERE RoomName = \"" + RoomName + "\"";//\n ID = " + 1;

            //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
            try (Connection conn = this.connect();
                  Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                  while(rs.next()) {

                      videoIDs = rs.getString("URL"); 
                      
                      videoArray.add(videoIDs);
                      
                  }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }           
            
        return videoArray;
    }
}
