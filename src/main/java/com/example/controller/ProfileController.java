package com.example.controller;

import com.example.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zach on 4/30/2017.
 */
@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/profile/", method = RequestMethod.GET)
    public String profile() {
        profileService.profileTestAttempts();
        return "test";
    }
}
