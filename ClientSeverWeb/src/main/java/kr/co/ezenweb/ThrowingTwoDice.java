package kr.co.ezenweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThrowingTwoDice {
	@RequestMapping("/rollDice")
	public void ezen(HttpServletResponse response){
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out;
		
		int dice1 = (int)(Math.random()*6)+1;
		int dice2 = (int)(Math.random()*6)+1;
		
		try {
			out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<body>");
			out.println("<img src='resources/img/dice"+dice1+".jpg'>");
			out.println("<img src='resources/img/dice"+dice2+".jpg'>");	//dice 변수를 만들지 않고 메서드를 바로 넣어도 됨 => 이경우에는 메모리를 덜 먹음
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
		} catch (IOException e) {e.printStackTrace();}
	}
}
