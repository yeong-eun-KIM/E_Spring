package kr.co.ezenac.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	
	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {
		//쿠키 생성
		Cookie cookie = new Cookie(cName,cValue);
		
		//쿠키 생성 경로
		cookie.setPath("/");
		//쿠키 유지기간 설정
		cookie.setMaxAge(cTime);
		//응답 객체에 추가
		response.addCookie(cookie);
	}
	
}
