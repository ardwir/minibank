package my.minibank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(path="/home", method=RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(path="/list-customer", method=RequestMethod.GET)
	public String list(Model model) {
		return "list";
	}

}
