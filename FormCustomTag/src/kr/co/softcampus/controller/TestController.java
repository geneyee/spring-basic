package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.softcampus.beans.UserDataBean;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(UserDataBean bean) {
		
		bean.setUser_name("홍길동");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_postcode("12345");
		bean.setUser_address1("주소1번");
		bean.setUser_address2("주소2번");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(UserDataBean bean) {
		
		bean.setUser_name("홍길동");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_postcode("12345");
		bean.setUser_address1("주소1번");
		bean.setUser_address2("주소2번");
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(@ModelAttribute("testBean") UserDataBean bean) {
		
		bean.setUser_name("홍길동");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_postcode("12345");
		bean.setUser_address1("주소1번");
		bean.setUser_address2("주소2번");
		
		return "test3";
	}
	
	@GetMapping("/test4")
	public String test4(Model model) {//이거는 프로퍼티객체는 주입받지 않고 모델 주입받는 경우
		
		UserDataBean bean = new UserDataBean();//여기서 객체생성 따로 함
		
		bean.setUser_name("홍길동");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_postcode("12345");
		bean.setUser_address1("주소1번");
		bean.setUser_address2("주소2번");
		
		model.addAttribute("test_user2", bean);//데이터 담긴 bean객체를 test_user2라는 이름으로 저장
		
		return "test4";
	}
}
