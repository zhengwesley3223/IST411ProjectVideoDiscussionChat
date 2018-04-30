package com.mycompany.ist411videodiscussionchat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class URLController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/CreateRoom")
    public String addressForm(Model model) {
        model.addAttribute("room", new Room());
        return "CreateRoom";
    }

    @PostMapping("/Room")
    @ResponseBody
    public String addressSubmit(@ModelAttribute Room room) {
        room.addRoom();
        StringBuilder responseBuffer = new StringBuilder();
        responseBuffer.append("<html><body><h1>Room Names: " + room.turnList() + "</h1>")
                .append("<br></br><b><a href=\"http://localhost:8080/AddVideo\">Add Videos</a></b><br></br>")
                .append("<b><a href=\"http://localhost:8080/JoinRoom\">Join Room</a></b></body></html>");
        return responseBuffer.toString();
    }

    @GetMapping("/AddVideo")
    public String addVideo(Model model) {
        model.addAttribute("videourl", new VideoURL());
        return "AddVideo";
    }

    @PostMapping("/VideoAdded")
    public String addressSubmit(@ModelAttribute VideoURL vidURL) {
        vidURL.addVid();
        return "thankyou";
    }

    @GetMapping("/JoinRoom")
    public String joinRoom(Model model) {
        model.addAttribute("videourl", new VideoURL());

        return "JoinRoom";
    }

    @PostMapping("/video")
    @ResponseBody
    public String video3(@ModelAttribute VideoURL videourl) {
        videourl.setVideoURL();
        System.out.println("VIDEO URL: " + videourl.getVideoURL());
        StringBuilder responseBuffer = new StringBuilder();
        responseBuffer
                .append("<html><body><h1>Input Youtube Video URL</h1>")
                .append("<iframe id=\"ytplayer\" type=\"text/html\" width=\"720\" height=\"405\" async=\"async\" src=\"" + videourl.getVideoURL() + "\" frameborder=\"0\" allowfullscreen=\"0\"> </iframe>")
                .append("<iframe src=\"http://webchat.freenode.net?nick=" + videourl.getNickName() + "&amp;channels=YTD_" + videourl.getRoomName() + "&amp;uio=d4\" width=\"647\" height=\"400\"></iframe>")
                .append("<br></br><b><a href=\"http://localhost:8080/AddVideo\">Add Videos</a></b><br></br>")
                .append("<b><a href=\"http://localhost:8080/JoinRoom\">Leave Room</a></b></body></html>");

        return responseBuffer.toString();
    }
}
