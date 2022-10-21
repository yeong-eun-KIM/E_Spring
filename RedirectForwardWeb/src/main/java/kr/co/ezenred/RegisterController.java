package kr.co.ezenred;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@RequestMapping(value="/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm";
		
	}
	
	@RequestMapping(value="/save",method = {RequestMethod.GET, RequestMethod.POST} )
	public String save(User user,Model m) throws UnsupportedEncodingException {
		if(isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "uft-8");
			m.addAttribute("msg",msg);
			//return "redirect:/register/add?msg="+msg;	//URL 재작성
			return "forward:/register/add";
		}
		return "registerInfo";
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
