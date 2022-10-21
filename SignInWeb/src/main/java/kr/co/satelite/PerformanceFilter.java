package kr.co.satelite;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter
public class PerformanceFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 초기화 작업
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 전처리 작업
		long startTime = System.currentTimeMillis();
		
		// 서블릿 또는 다음 필터 호출
		chain.doFilter(request, response);
		
		// 후처리 작업
		HttpServletRequest req = (HttpServletRequest)request;
		String method = req.getMethod();
		System.out.println(method + ": [" + req.getRequestURI() + "]");
		System.out.println("소요시간 : "+(System.currentTimeMillis()-startTime)+"ms");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
