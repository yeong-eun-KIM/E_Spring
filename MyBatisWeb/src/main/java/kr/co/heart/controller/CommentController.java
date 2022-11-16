package kr.co.heart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.heart.domain.CommentDto;
import kr.co.heart.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@GetMapping("/comments")
	@ResponseBody
	//public List<CommentDto> list(Integer bno)
	public ResponseEntity<List<CommentDto>> list(Integer bno){
		List<CommentDto> list = null;
		
		try {
			list = service.getList(bno);
			System.out.println("list = " + list);
			return new ResponseEntity<List<CommentDto>>(list,HttpStatus.OK); //200
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<CommentDto>>(HttpStatus.BAD_REQUEST);	//400
		}
		
		//return list;
	}
}
