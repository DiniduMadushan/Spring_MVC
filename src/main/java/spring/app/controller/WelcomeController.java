package spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import spring.app.entity.User;
import spring.app.service.UserService;
import spring.app.service.UserServiceImplement;

@Controller
public class WelcomeController {
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user,Model model) {
		if(userservice.register(user)) {
			model.addAttribute("msg","Successfully registered!!");
		}else {
			model.addAttribute("msg","error occured!!");
		}
		
		return "registration-successful";
	}
	
}
