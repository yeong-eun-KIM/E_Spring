package kr.co.ezen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 호출가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 10; //인스턴스 변수
	static int cv = 20; //static 변수
	
	//2. URL과 메서드
	@RequestMapping("/Hello")
	private void main1() {
		System.out.println("Hello - private");
		System.out.println(iv);
		System.out.println(cv);
	}
}
