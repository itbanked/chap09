package com.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

//	로깅을 예쁘게 나오게 하는 라이브러리
	static Log log = LogFactory.getLog(LoginServlet.class);
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("#######");
		log.info("doGet()");
		log.info("#######");
		
		String error = request.getParameter("error");
		log.info("error = [" + error + "]");
		if(error != null)
			request.setAttribute("errorMessage", "ID, PW를 확인하세요.");
		else
			request.removeAttribute("errorMessage");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginform.jsp");
		dispatcher.forward(request, response);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("########");
		log.info("doPost()");
		log.info("########");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		log.info("id = " + id ); log.info("pw = " + pw);
		
		/*
		 * 인증처리
		 */
		
		if("hong".equals(id) && "1234".equals(pw)){
			//인증성공
			response.sendRedirect("/index.jsp");
		}
		else{
			//인증실패
			response.sendRedirect("/login?error");
			
		}
		
	}
	
}
