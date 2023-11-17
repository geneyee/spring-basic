package kr.co.softcampus.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.softcampus.beans.DataBean1;

@Controller
@SessionAttributes({"sessionBean1", "sessionBean2"})//@ModelAttribute("sessionBean1")
public class TestController {
	
	//반환메서드 필수
	@ModelAttribute("sessionBean1")
	public DataBean1 sessionBean1() {
		return new DataBean1();//반환값인 DataBean1()객체를 "sessionBean1"이름으로 저장함
	}
	
	@ModelAttribute("sessionBean2")
	public DataBean1 sessionBean2() {
		return new DataBean1();
	}
	
	@GetMapping("/test1")
//	public String test1(HttpServletRequest request) {//서블릿에서는 이렇게
	public String test1(HttpSession session) {//스프링에서는 바로 session 주입받아 사용가능
		
		//session객체 추출(주입받은 request객체에서)
//		HttpSession session = request.getSession();
		session.setAttribute("data1", "문자열1");
			
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		
		session.setAttribute("data1", "문자열2");
		
		return "redirect:/result1";
	}
	
	@GetMapping("/test3")
	public String test3(HttpSession session) {
		
		session.setAttribute("data1", "문자열3");
		
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
//	public String result1(HttpServletRequest request) {//서블릿에서는 이렇게
	public String result1(HttpSession session) {//스프링에서는 바로 session 주입받아 사용가능
		
		//HttpSession session = request.getSession();
		//test1()에서 세션에 저장한 데이터 가져오기
		String data1 = (String)session.getAttribute("data1");
		System.out.println("data1 : "+data1);
		
		return "result1";
	}
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {
//	public String test4(@SessionAttribute("bean1") DataBean1 bean1) {
		
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");
		
		session.setAttribute("bean1", bean1);
		
		return "test4";
	}
	
	@GetMapping("/result4")
//	public String result4(HttpSession session) {
	public String result4(@SessionAttribute ("bean1") DataBean1 bean1) {
		
//		DataBean1 bean1 = (DataBean1) session.getAttribute("bean1");
		
		System.out.println("bean1.data1 : "+bean1.getData1());
		System.out.println("bean1.data2 : "+bean1.getData2());
		
		return "result4";
	}
	
	@GetMapping("/test5")
	public String test5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
						@ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		
		sessionBean1.setData1("문자열6");
		sessionBean1.setData2("문자열7");
		
		sessionBean2.setData1("문자열8");
		sessionBean2.setData2("문자열9");
		
		return "test5";
		
	}
	
	@GetMapping("/result5")
	public String result5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
							@ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		
		System.out.println("sessionBean1.data1 : "+sessionBean1.getData1());
		System.out.println("sessionBean1.data2 : "+sessionBean1.getData2());
		
		System.out.println("sessionBean2.data1 : "+sessionBean2.getData1());
		System.out.println("sessionBean2.data2 : "+sessionBean2.getData2());
		
		return "result5";
	}

}
