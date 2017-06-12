package app.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import app.project.model.Employee;

@Controller
public class HomeController {

	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}
	
	@GetMapping("/view/{name}")
	public String getAllViews(Model model,@PathVariable("name") String name){
		Employee employee = new Employee(name);
		model.addAttribute("emp", employee);
		return "employees";
	}
}
