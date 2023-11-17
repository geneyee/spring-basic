package kr.co.softcampus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.softcampus.beans.DataBean;
import kr.co.softcampus.beans.DataBean2;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map, 
						@RequestParam List<String> data3) {
		
		String data1 = map.get("data1");
		String data2 = map.get("data2");
//		String data3 = map.get("data3");
		String data = map.get("data3");
		
		System.out.printf("data1 : %s\n", data1);
		System.out.printf("data2 : %s\n", data2);
		System.out.printf("data : %s\n", data);
		
		for(String str : data3) {
			System.out.printf("data3 : %s\n", str);
		}
		
/*		for (int i=0; i<data3.size(); i++) {
			String str = data3.get(i);
			System.out.println("data3 : " + str);
		}*/
		
		return "result";
		
	}
	
	@GetMapping("/test2")
//	public String test2(@ModelAttribute DataBean bean1, @ModelAttribute DataBean2 bean2) {
	public String test2(DataBean bean1, DataBean2 bean2) {
		
		System.out.printf("data1 : %d\n", bean1.getData1());
		System.out.printf("data2 : %d\n", bean1.getData2());
		
		for(int number : bean1.getData3()) {
			System.out.printf("data3 : %d\n", number);	
		}
		
		System.out.printf("data1 : %d\n", bean2.getData1());
		System.out.printf("data2 : %d\n", bean2.getData2());
		
		return "result";
	}

}
