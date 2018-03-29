package com.mycompany.ist411videodiscussionchat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class URLController {
    
    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("user", new User());
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
    
    @RequestMapping(value = "/video")
    public String video(){
        return "video";
    }
}
