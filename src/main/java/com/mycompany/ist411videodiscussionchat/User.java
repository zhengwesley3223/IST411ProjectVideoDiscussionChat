package com.mycompany.ist411videodiscussionchat;

import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {
    
    public String id;
    private String username;
    private String password;
    
    public void setID(String idIn){
        id = idIn;
    }
    
    public String getID(){
        return id;   
    }
    
    public void setUsername(String usernameIn){
        username = usernameIn;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String passwordIn){
        password = passwordIn;
    }
    
    public String getPassword(){
        return password;
    }
}
