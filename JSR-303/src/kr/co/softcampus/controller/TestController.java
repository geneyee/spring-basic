package kr.co.softcampus.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampu.beans.DataBean1;

@Controller
public class TestController {
	
	@GetMapping("/input_data")
	public String input_data(DataBean1 dataBean1) {//jsp에서 form태그에서 빈 주입 받아 사용할거라서 미리 주입받아놓음
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		
		if(result.hasErrors()) {
			return "input_data";
		}
		return "input_success";
	}

}
