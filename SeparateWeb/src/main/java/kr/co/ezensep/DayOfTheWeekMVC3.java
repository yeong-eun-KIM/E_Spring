package kr.co.ezensep;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 년월일을 입력하면 해당 요일을 알려주는 프로그램
@Controller
public class DayOfTheWeekMVC3 {
	@RequestMapping("/getDayMVC3")
	public ModelAndView main(int year, int month, int day) {
		// 1. 유효성 검사
//		if (!isValid(year, month, day))
//			return "dayOfWeekError";
		
		ModelAndView mv = new ModelAndView();
		
		char dayOfTheWeek = getDayOfWeek(year, month, day);
		
		//3. Model에 작업 결과 저장
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("dayOfTheWeek", dayOfTheWeek);
		
		mv.setViewName("dayOfWeek");
		
		return mv;
		
	}
	
	
	private boolean isValid(int year, int month, int day) {
		if(year==-1||month ==-1||day==-1)
			 return false;
		return (1<=month && month<=12) && (1<=day && day<=31);		//간단한 체크
	}


	private static char getDayOfWeek(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1, day); 	// 날짜 setting
		
		int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);		//요일 리턴 (sunday=1)
		
		/*
		 * "0일월화수목금토".charAt(1); => '일' 리턴
		 * "0일월화수목금토".charAt(2); => '월' 리턴
		 */
		
		char dayOfTheWeek = " 일월화수목금토".charAt(dayOfWeek);
		return dayOfTheWeek;
	}
}
