package com.example.demo.controller;

import com.example.demo.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    private List<User> users;

    public HomeController() {
        this.users = new ArrayList<>();
    }

    // home.html - Get Request
    @GetMapping("/users/all")               // Get -> http://localhost:8080/users/all
    public String showUsers(Model model) {
        // TODO: return all users
        User user = new User("GoshoByClass", "user@softuni.bg", "userPassword");
        model.addAttribute("user", user);
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", "superPassword");
        return "home";
    }

    // about.html - Get Request
    @GetMapping("/about")
    public ModelAndView about(ModelAndView modelAndView) {

        List<String> names = new ArrayList<> (Arrays.asList("Peter", "Michael", "George", "Victor", "John"));

        modelAndView.setViewName("about");  // about.html
        modelAndView.addObject("about", "About Us."); // add  String variable
        modelAndView.addObject("names", names); // add List<String> variable
        return modelAndView;
    }

    // write text
    @GetMapping("/pesho")                   // Get -> http://localhost:8080/pesho
    public @ResponseBody                    // annotation: @ResponseBody; don't search html, return text
    String showPesho() {
        return "<h3 style='text-align:left;color:Green'>Pesho</h3>";
    }

//    @PostMapping("/register")
//    public ModelAndView register(ModelAndView modelAndView) {
//        return modelAndView;
//    }

    // error: Whitelabel Error Page. There was an unexpected error (type=Method Not Allowed, status=405). Request method 'GET' not supported.
    // Post Request
    @PostMapping("/user")
    public String createUser(User user) {
        this.users.add(user);
        return "redirect:/";
    }
}
