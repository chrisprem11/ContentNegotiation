package app.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import app.project.model.Employee;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getRestHomePage() {
		String message = "Spring Rest content Negotiation";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping( value = "/emp/{name}", produces = MediaType.ALL_VALUE )
	public ResponseEntity<Employee> getOneEmployee(Model model,@PathVariable("name") String name) {
		Employee employee = new Employee(name);
		model.addAttribute("emp", employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}
