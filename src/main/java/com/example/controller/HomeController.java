package com.example.controller;

import com.example.domain.Role;
import com.example.domain.User;
import com.example.domain.UserRole;
import com.example.service.TestService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 2/7/2017.
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/tests")
    public String tests() {
        return "tests";
    }

    @RequestMapping("/registration")
    public String registration() {
        return "registration";
    }

//

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm) {

        //need user checking logic, if username is already chosen, prompt
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setName("ADMIN");
        userRoles.add(new UserRole(userForm, role));
        userService.createUser(userForm, userRoles);

        return "redirect:/tests";
    }


}

