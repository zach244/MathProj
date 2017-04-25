package com.example.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Test;

@Controller
public class ProfileController {
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value ="/profile")
	public String profile(Model model)
	{
		String user = request.getUserPrincipal() == null ? "NO USER" : request.getUserPrincipal().getName();
        model.addAttribute("user", user);
		return "profile";
	}

}
