package com.mycompany.ist411videodiscussionchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Database db = new Database("VideoDiscussionChatRoom.db");
        db.connectToDatabase();
        SpringApplication.run(Application.class, args);
        
    }

}
