

package com.persteenolsen.springbootrestjpalogin.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// This Controller is saving a welcome message in the model to be used in the JSP View
// It is using GetMapping to get url request by both /home and /welcome
@Controller
public class ClientRestController {
	
	private String helloworld = "";
		
	//@GetMapping({"/", "/clientrest"})
	@GetMapping("/clientrest")
	public String clientrest(Map<String, Object> model) {

		helloworld = "A Java Spring Boot REST API!";

		model.put("messageclientrest", helloworld);
				
		return "client_rest";
	}
}