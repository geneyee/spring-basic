package kr.co.softcampus.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.beans.DataBean2;
import kr.co.softcampus.beans.DataBean3;
import kr.co.softcampus.beans.DataBean4;

@Controller
public class TestController {
	//타입을 통한 주입
	@Autowired
	@Lazy
	DataBean1 requestBean1;
	/*xml의 경우 새로운 요청이 발생하지 않더라도 bean을 주입하려는 시도를 한다.
	 *우리는 DataBean1을 scope="request"로 정의해놨기 때문에 요청이 발생하지 않았을 경우 bean의 주입을 시도하게 되면
	 *이를 거부하게 된다(에러) - 다양한 해결방안이 있는데 여기서는 @Lazy로 해결
	 *@Lazy - 서버가 가동이 될 때 자동으로 주입되지 않고 대기하고 있다가 실제 request요청이 발생했을 때 bean이 주입된다*/
	
	@Resource(name ="requestBean2")
	@Lazy
	DataBean2 requestBean2;
	
	//component 통한 주입(타입)
	@Autowired
	@Lazy
	DataBean3 requestBean3;
	
	//component 통한 주입(이름)
	@Resource(name = "requestBean4")
	@Lazy
	DataBean4 requestBean4;
	
	@GetMapping("/test1")
	public String test1() {
		
		requestBean1.setData1("문자열1");
		requestBean1.setData2("문자열2");

		requestBean2.setData3("문자열3");
		requestBean2.setData4("문자열4");
		
		requestBean3.setData5("문자열5");
		requestBean3.setData6("문자열6");
		
		requestBean4.setData7("문자열7");
		requestBean4.setData8("문자열8");
		
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		
		//bean이 주입만 되고 저장은 되지 않은것을 확인할 수 있다.
		System.out.println("requestBean1.data1 : "+requestBean1.getData1());
		System.out.println("requestBean1.data2 : "+requestBean1.getData2());
		
		System.out.println("requestBean2.data3 : "+requestBean2.getData3());
		System.out.println("requestBean2.data4 : "+requestBean2.getData4());
		
		System.out.println("requestBean3.data5 : "+requestBean3.getData5());
		System.out.println("requestBean3.data6 : "+requestBean3.getData6());
		
		System.out.println("requestBean4.data7 : "+requestBean4.getData7());
		System.out.println("requestBean4.data8 : "+requestBean4.getData8());
		
		//@Autowired
		model.addAttribute("requestBean1", requestBean1);//request영역에 저장
		
		//component 통한 주입은 자동으로 request영역에 저장되지 않으므로 
		model.addAttribute("requestBean3", requestBean3);
		model.addAttribute("requestBean4", requestBean4);
		
		
		return "result1";
	}

}
