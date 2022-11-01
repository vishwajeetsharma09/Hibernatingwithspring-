package com.klef.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Lib3Controller1 {
	@ResponseBody
	@GetMapping("/login1")
	public String fun1() {
		return "Fun1 Calling";
	}
}

