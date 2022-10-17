package kr.co.ezenac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class initParamServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 호출");
		super.doGet(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("destory 호출");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init 호출");
		super.init();
	}
	
}
