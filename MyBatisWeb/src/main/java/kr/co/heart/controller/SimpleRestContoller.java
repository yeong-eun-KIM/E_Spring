package kr.co.heart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.heart.domain.Person;

@Controller
//@RestController
public class SimpleRestContoller {

	@GetMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@ResponseBody
	@PostMapping("/send")
	public Person test(@RequestBody Person p) {
		System.out.println("p = "+p);
		p.setName("ezen0111");
		p.setAge(p.getAge()+2023);
		return p;
	}
}
