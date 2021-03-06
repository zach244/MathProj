package com.example.controller;

import com.example.domain.TestAttempt;
import com.example.domain.User;
import com.example.service.ProfileService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by zach on 4/30/2017.
 */
@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String profile(Model model) {
        List<TestAttempt> testAttemptList = profileService.profileTestAttempts();
        User user = userService.getAuthenticatedUser();
        model.addAttribute("testAttempts", testAttemptList);
//        model.addAttribute("user",user);
        return "profile";
    }
}
