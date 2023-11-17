package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.softcampus.beans.DataBean1;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		request.setAttribute("data1", "문자열1");
		
		return "redirect:/result1"; //request.setAttribute("data1", "문자열1");>이 request객체 소멸
	}
	
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {//브라우저에 의해 result1 요청되고 이 메소드에 의해 request객체 새롭게 생성
		
		String data1 = (String)request.getAttribute("data1");
		System.out.println("data1 : " + data1);//출력하면 data1 : null
		
		return "result1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpServletRequest request) {
		
		request.setAttribute("data1", "문자열1");
		
		return "forward:/result2";//forward는 응답결과가 브라우저로 전달되지 않고 result2로 서버흐름이 이동된다
		
	}
	
	@GetMapping("/result2")
	public String result2(HttpServletRequest request) {//forward에서 응답결과가 브라우저르 전달되지 않았기 때문에 위에 쓰인 request객체가 여기로 그대로 주입된다
		
		String data1 = (String)request.getAttribute("data1");
		System.out.println("data1 : " + data1);
		
		return "result2";
	}
	
	@GetMapping("/test3")
	public String test3(Model model) {
		
		model.addAttribute("data2", "문자열2");//request 영역에  model객체 저장
		
		return "forward:/result3";
	}
	
	@GetMapping("/result3")
	public String result3(Model model, HttpServletRequest request) {
		
		String data2 = (String)model.getAttribute("data2");
		System.out.println("data2 : " + data2);//model은 전달되지 않는다
		
		String data3 = (String)request.getAttribute("data2");
		System.out.println("data2 : " + data3);
		
		return "result3";
	}
	
	@GetMapping("/test4")
	public ModelAndView test4(ModelAndView mv) {
		
		mv.addObject("data4", "문자열4");
		mv.setViewName("forward:/result4");
		
		return mv;
	}
	
	@GetMapping("/result4")
	public String result4(HttpServletRequest request) {
		String data4 = (String)request.getAttribute("data4");
		System.out.println("data4 : " + data4 );
		
		return "result4";
	}
	
	@GetMapping("/test5")
	public String test5(Model model) {
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("문자열5");
		bean1.setData2("문자열6");
		
		model.addAttribute("bean1", bean1);
		
		return "forward:/result5";
	}
	
	@GetMapping("/result5")
	public String result5(HttpServletRequest request) {
		
		DataBean1 bean1 = (DataBean1)request.getAttribute("bean1");
		System.out.println("bean1.data1 : " + bean1.getData1());
		System.out.println("bean1.data2 : " + bean1.getData2());
		
		return "result5";
	}
	
	@GetMapping("/test6")
	public String test6(@ModelAttribute("bean") DataBean1 bean1) {
		bean1.setData1("문자열7");
		bean1.setData2("문자열8");
		
		return "forward:/result6";
	}
	
	@GetMapping("/result6")
//	public String result6(@ModelAttribute("bean") DataBean1 bean1) {
	public String result6(HttpServletRequest request) {	
		
		DataBean1 bean1 = (DataBean1)request.getAttribute("bean");
		
		System.out.println("bean.data1 : "+ bean1.getData1());
		System.out.println("bean.data2 : " +bean1.getData2());
		
		return "result6";
	}

}
