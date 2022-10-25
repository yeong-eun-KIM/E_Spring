package kr.co.hugeleap;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
//@ControllerAdvice("kr.co.hugeleap.sub")	//지정된 패키지에서만 발생한 예외 처리
public class SharedCatcher {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String catcher(Exception ex, Model m) {	
		System.out.println("catcher () in ExceptionController2 ");
		System.out.println("m ="+ m.getAttribute("msg"));	//다른 모델을 사용하고 있음
		
		m.addAttribute("ex",ex);	//예외 정보가 모델에 담겨서 뷰에 전달 된 것임
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	}
}
