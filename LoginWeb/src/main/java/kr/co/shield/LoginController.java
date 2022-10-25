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
	public String login(String id, String pwd, boolean rememberId,String toURL ,HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		//1. id와 pw를 확인
		if(!loginCheck(id, pwd)) {
			//2-1. 일치하지 않으면, loginForm으로 이동		
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		
		if(rememberId == true) {
			//2-2-1. 쿠키를 생성
			//2-2-2. 응답 헤더에 저장
			makeCookie(response, id);
		}
		else {
			//2-3-1. 쿠키를 삭제
			//2-3-2. 응답 헤더에 저장
			deleteCookie(response, id);
		}
		
		//3. 세션 객체 얻어오기.
		HttpSession session =  request.getSession();
		//세션 객체에 id를 저장
		session.setAttribute("id", id);
		
		//4. toUrl이 있을시에는 toUrl로 이동
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
				
		//일치하면 로그인 후 화면 (홈화면)으로 이동		
		return "redirect:"+toURL;
		
		
	}
	
	public static void makeCookie(HttpServletResponse response, String id) {
		Cookie cookieid = new Cookie("id", id); 
		response.addCookie(cookieid);		
	}
	public static void deleteCookie(HttpServletResponse response, String id) {
		Cookie cookieid = new Cookie("id", id); 
		cookieid.setMaxAge(0);
		response.addCookie(cookieid);	
	}
	

	private boolean loginCheck(String id, String pwd) {
		// TODO Auto-generated method stub
		return "ezen".equals(id) && "0111".equals(pwd);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}	