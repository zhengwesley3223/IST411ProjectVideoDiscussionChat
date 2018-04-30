/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ist411videodiscussionchat;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Owner
 */
public class VideoURL {

    Database db = new Database("VideoDiscussionChatRoom.db");
    String videoURL = "https://www.youtube.com/embed/eiXwaP7zSRk?playlist=yBDd5HO_t3M&version;=3";
    String videoLink;
    String roomName;
    ArrayList<String> videoArray;

    public VideoURL() {

    }

    public void setVideoURL() {

        this.videoURL = videoURL.substring(0, videoURL.length() - 11) + getVideoID(videoLink) + videoURL.substring(videoURL.length() - 11, videoURL.length());
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getVideoID(String videoLink) {
        
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(videoLink); //url is youtube url for which you want to extract the id.
        if (matcher.find()) {
             return "," + matcher.group();
        }
        return "";
    }
    
    public void setRoomName(String roomname){
        this.roomName = roomname;
    }
    
    public String getRoomName(){
        return roomName;
    }
    
    public void addURLDB(){
        db.addVideo(roomName, getVideoID(videoLink));
    }
}
