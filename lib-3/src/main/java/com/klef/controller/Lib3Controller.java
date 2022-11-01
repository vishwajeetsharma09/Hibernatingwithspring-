package com.klef.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Lib3Controller {
	@ResponseBody
	@GetMapping("/login")
	public String fun1() {
		return "Fun1 Calling";
	}
}
