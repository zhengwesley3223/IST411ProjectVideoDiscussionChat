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
    public String video2(Model model){
        model.addAttribute("videourl", new VideoURL());
        VideoURL v = new VideoURL();
        System.out.println(v.getVideoURL());
        return "video2";
    }
    
    @GetMapping("/CreateRoom")
    public String addressForm(Model model) {
        model.addAttribute("room", new Room());
        return "CreateRoom";
    }

    @PostMapping("/Room")
    public String addressSubmit(@ModelAttribute Room room) {
        room.addRoom();
        return "Room";
    }
    
    @GetMapping("/testURL")
    public String addVideo(Model model){
        model.addAttribute("videourl", new VideoURL());
    return "AddVideo";
    }
    
        @PostMapping("/testURL2")
    public String addressSubmit(@ModelAttribute VideoURL vidURL) {
        vidURL.setVideoURL();
        System.out.println("VIDEO URL: " + vidURL.getVideoURL());
        System.out.println("VIDEO LINK: " + vidURL.getVideoLink());
        System.out.println("VIDEO ID: " + vidURL.getVideoID(vidURL.getVideoLink()));
        return "thankyou";
    }
}
