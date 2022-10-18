package kr.co.ezensignup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController2 {
	//@RequestMapping(value ="/register/add2", method = {RequestMethod.GET, RequestMethod.POST})
	//@RequestMapping(value ="/register/add2")
	
//	@GetMapping("/register/add2")
//	public String register () {
//		return "registerForm";			//WEB-INF/views/registerForm.jsp
//	}
	
	//@RequestMapping(value ="/register/save2")
	@PostMapping("/register/save2")
	public String save(User user) throws UnsupportedEncodingException {
		
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력했습니다.","utf-8");
			return "rediredct:/register/add2?msg="+msg;
			
			
		}
		
		return "registerInfo";			//WEB-INF/views/registerInfo.jsp
	}

	private boolean isValid(User user) {
		// 현재 유효하지 못하게 false로 설정함
		return false;
	}
}
