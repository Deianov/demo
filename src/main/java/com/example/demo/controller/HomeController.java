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
    private List<User> userList;

    public HomeController() {
        this.userList = new ArrayList<>();
    }

    // Get Request to localhost:8080/users
    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userList);
        return "users";
    }

    // Get Request to localhost:8080/about
    @GetMapping("/about")
    public ModelAndView about(ModelAndView modelAndView) {

        List<String> names = new ArrayList<> (Arrays.asList("Peter", "Michael", "George", "Victor", "John"));

        modelAndView.setViewName("about");  // about.html
        modelAndView.addObject("about", "About Us."); // add  String variable
        modelAndView.addObject("names", names); // add List<String> variable
        return modelAndView;
    }

    // Send text to <localhost:8080/about> with annotation: @ResponseBody
    @GetMapping("/pesho")
    public @ResponseBody
    String showPesho() {
        return "<h3 style='text-align:left;color:Green'>Pesho</h3>";
    }

    // Get Request to localhost:8080/users
    @GetMapping("/user")
    public Model userForm(Model model) {
        model.addAttribute("count", "0");
        model.addAttribute("user", new User());

        return model;
    }

    // Post Request to localhost:8080/users
    @PostMapping("/user")
    public ModelAndView register(ModelAndView modelAndView, User user) {
        this.userList.add(user);
        modelAndView.addObject("count", userList.size());
        return modelAndView;
    }
}
