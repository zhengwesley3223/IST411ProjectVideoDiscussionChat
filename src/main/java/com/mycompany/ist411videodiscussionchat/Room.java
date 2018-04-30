/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ist411videodiscussionchat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Owner
 */
public class Room {
    Database db = new Database("VideoDiscussionChatRoom.db");
    String room;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int roomID;

    public Room() {
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void addRoom() {
        db.addRoom(room);
    }
    
    public String turnList(){
        String rooms = "";
        for(int i = 0; i < db.getRoomList().size(); i++){
            if(i == 0){
                rooms += db.getRoomList().get(i);
            }
            else{
            rooms += ", " + db.getRoomList().get(i);
            }
        }
        return rooms;
    }
}
