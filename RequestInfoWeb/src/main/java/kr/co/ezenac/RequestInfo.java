package kr.co.ezenac;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestInfo
 */
@WebServlet("/req")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트가 요청한 파라미터 값들을 인코딩해주는 코드
		request.setCharacterEncoding("utf-8");
		
		System.out.println("request.getCharacterEncoding()"+request.getCharacterEncoding());
		System.out.println("request.getMethod() : "+request.getMethod());
		System.out.println("request.getProtocol() : "+request.getProtocol());
		System.out.println("request.getServerName() : "+request.getServerName());
		System.out.println("request.getServerPort() : "+request.getServerPort());
		System.out.println("request.getRequestURL() : "+request.getRequestURL());
		System.out.println("request.getRequestURI() : "+request.getRequestURI());
		System.out.println("request.getContextPath() : "+request.getContextPath());
		System.out.println("request.getServletPath() : "+request.getServletPath());
		System.out.println("자바 웹 애플리케이션");
	}

}
