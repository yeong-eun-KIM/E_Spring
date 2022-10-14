package kr.co.ezenstation;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("LoginController")
public class LoginController {
	
	@RequestMapping(value= {"/req/loginForm.do","/req/loginForm2.do"}, method = {RequestMethod.GET})
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/loginForm");
		return mav;
	}
	
	@RequestMapping(value="/req/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		

			//Request line
			String requestLine = request.getMethod();
			requestLine += " " +request.getRequestURI();
			
			String queryString = request.getQueryString();
			requestLine += queryString == null ? "" : "?" + queryString;
			requestLine += request.getProtocol();
			System.out.println(requestLine);
			
			//Request header
			Enumeration<String> e = request.getHeaderNames();
			while(e.hasMoreElements()) {
				String name = e.nextElement();
				System.out.println(name+" : "+request.getHeader(name));
			}
			
		//Request Body
			final int CONTENT_LENGTH = request.getContentLength();
			System.out.println("CONTENT_LENGTH : "+ CONTENT_LENGTH);
			
			if(CONTENT_LENGTH > 0) {
				try {
					request.setCharacterEncoding("utf-8");
					mav.setViewName("/result");
					
					String userId = request.getParameter("userId");
					String userName = request.getParameter("userName");
					
					mav.addObject("userId", userId);
					mav.addObject("userName", userName);
					
					System.out.println();
					System.out.println("userId : "+userId + " userName : " + userName);
					
				} catch (UnsupportedEncodingException e1) {e1.printStackTrace();}
				
			}
			
			
		return mav;
	}
}
