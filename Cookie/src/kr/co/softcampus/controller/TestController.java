package kr.co.softcampus.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/save_cookie")
	public String save_cookie(HttpServletResponse response) {
		
		try {
			String data1 = URLEncoder.encode("문자열1", "UTF-8");
			String data2 = URLEncoder.encode("문자열2", "UTF-8");
			
			Cookie cookie1 = new Cookie("cookie1", data1);
			Cookie cookie2 = new Cookie("cookie2", data2);
			
			cookie1.setMaxAge(365 * 24 * 60 * 60);//초단위
			cookie2.setMaxAge(365 * 24 * 60 * 60);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "save_cookie";
	}
	
	@GetMapping("load_cookie")
	public String load_cookie(HttpServletRequest request) {
		
		//servlet에서는 원하는 쿠키정보만 가져올 수 없다. 
		//그래서 모든 쿠키정보 가져온 다음 반복문 돌려서 쿠키 이름 다 추출하고 원하는 쿠키 이름으로 정보 가져온다.
		try {
			
			Cookie[] cookies = request.getCookies();
			
			for(Cookie cookie : cookies) {
				String str = URLDecoder.decode(cookie.getValue(), "UTF-8");
				
				if(cookie.getName().equals("cookie1")) {
					System.out.println("cookie1 : " + str);
				}else if(cookie.getName().equals("cookie2")) {
					System.out.println("cookie2 : " + str);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "load_cookie";
	}
	
	@GetMapping("/load_cookie_spring")
	public String load_cookie_spring(@CookieValue("cookie1") String cookie1,
									@CookieValue("cookie2") String cookie2) {
		
		System.out.println("cookie1 : " + cookie1);
		System.out.println("cookie2 : " + cookie2);
		
		return "load_cookie_spring";
		
		/*스프링에서는 쿠키 인코딩 디코딩 자동으로 되고, 원하는 쿠키만 따로 가져올 수 있다.*/
		
	}

}
