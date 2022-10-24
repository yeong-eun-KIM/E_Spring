package kr.co.shield;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
		
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, String toURL, boolean rememberId,
					HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("id= "+ id);
		System.out.println("pwd= " +pwd);
		System.out.println("rememberId= "+ rememberId);
		//1. id와 pw를 확인
		if(!loginCheck(id, pwd)) {
			//2-1. 일치하지 않으면, loginForm으로 이동		
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
	
		//2-2 일치하면 로그인 후 화면(홈화면)으로 이동
		
		if(rememberId == true) {
			Cookie cookie   = new Cookie("id",id);		//2-2-1 쿠키생성
			response.addCookie(cookie);		//2-2-2 응답헤더에 저장
		} else {
			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(0);		//2-2-3 쿠키를 삭제	
			response.addCookie(cookie);		//2-2-4 응답헤더에 저장
		}
			
		
		//3. 세션 
		//3-1 객체 얻어오기
		HttpSession session =  request.getSession();
		
		//3-2 세션 객체에 id를 저장
		session.setAttribute("id", id);
		
		
		//4. view 페이지로 이동
		toURL = (toURL == null || toURL.equals(""))? "/" : toURL;
		
		
		return "redirect:" + toURL;
		
	}
		
	private boolean loginCheck(String id, String pwd) {
		// TODO Auto-generated method stub
		return "ezen".equals(id) && "0111".equals(pwd);
	}
	
}
