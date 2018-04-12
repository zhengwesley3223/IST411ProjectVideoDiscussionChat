package com.mycompany.ist411videodiscussionchat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class URLController {
    
    @GetMapping("/")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
    
//    @PostMapping("/login")
//    public String loginSubmit(@ModelAttribute User user){
//        return "thankyou";
//    }
    
//    @GetMapping("/createlogin")
//    public String createLogin(Model model) {
//        User user = new User();
//        model.addAttribute("id", user.id);
//        return "createlogin";
//    }
    
//    @PostMapping("/createlogin")
//    public String createLoginSubmit(@ModelAttribute User user) {
//        address.addAddress();
//        return "thankyou";
//    }
    
    @RequestMapping("/video")
    public String video(){
        return "video";
    }
    
    @RequestMapping("/video2")
    public String video2(){
        return "video2";
    }
}
