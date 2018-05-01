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

    String videoURL = "https://www.youtube.com/embed/eiXwaP7zSRk?playlist=Xmbym_G3rAI&version;=3";
    String videoLink;
    ArrayList<String> videoArray;
    String roomName;
    String nickName;
    Database db = new Database("VideoDiscussionChatRoom.db");

    public VideoURL() {

    }

    public void setVideoURL() {
        String videos = "";
        if (db.getVideoList(roomName).size() == 0) {
            this.videoURL = videoURL;
        } else {
            for (int i = 0; i < db.getVideoList(roomName).size(); i++) {
                videos += "," + db.getVideoList(roomName).get(i);
            }
            this.videoURL = videoURL.substring(0, videoURL.length() - 11) + videos + videoURL.substring(videoURL.length() - 11, videoURL.length());
        }
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
            return matcher.group();
        }
        return "";
    }

    public void setRoomName(String roomIn) {
        this.roomName = roomIn;
    }

    public String getRoomName() {
        return roomName;
    }

    public void addVid() {
        db.addVideo(roomName, getVideoID(videoLink));
    }

    public void turnVidList() {
        String videos = db.getVideoList(roomName).get(0);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nameIn) {
        this.nickName = nameIn;
    }
}
