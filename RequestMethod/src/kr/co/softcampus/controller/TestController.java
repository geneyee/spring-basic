package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1_get() {
		return "test1";
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public String test1_post() {
		return "test1";
	}
	
	@PostMapping("/test2")
	public String test2Post() {
		return "test2Post";
	}
	
	@GetMapping("/test2")
	public String test2Get() {
		return "test2Get";
	}
	
	@RequestMapping(value="/test3", method = {RequestMethod.GET, RequestMethod.POST})
	public String test3() {
		return "test3";
	}
	
	@GetMapping("/test4")
	public String test4_get() {
		return test4_post();
	}
	
	@PostMapping("/test4")
	public String test4_post() {
		return "test4";
	}

}
