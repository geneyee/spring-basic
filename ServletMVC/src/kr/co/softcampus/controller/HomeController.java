package kr.co.softcampus.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.softcampus.model.Test2Service;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//요청한 주소 가져온다.
		String url = request.getRequestURI();
		
		//View로 사용할 jsp
		String viewName = null;
		
		//contains : 문자열에 특정문자 포함하고 있는지 확인하는 함수
		if(url.contains("main.mvc")) {
			//System.out.println("main 요청");
			viewName = "main.jsp";
		}else if(url.contains("test1.mvc")) {
			//System.out.println("test1 요청");
			
			//파라미터 데이터 추출
			//파라미터는 문자열로 저장되니까 
			String str1 = request.getParameter("data1");
			String str2 = request.getParameter("data2");
			
			//문자->정수로 바꿔줌
			int number1 = Integer.parseInt(str1);
			int number2 = Integer.parseInt(str2);
			
			int result = number1 + number2;
			
			//위에 더한 값 result 변수를 "result"에 담는다
			request.setAttribute("result", result);
		
			viewName = "test1.jsp";
			
		}else if(url.contains("test2.mvc")) {
			//System.out.println("test2 요청");
			
			//모델 요청
			int result = Test2Service.minus(request);
			request.setAttribute("result", result);
			
			viewName = "test2.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewName);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
