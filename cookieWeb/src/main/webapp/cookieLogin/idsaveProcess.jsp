<%@page import="kr.co.ezenac.utils.JSFunction"%>
<%@page import="kr.co.ezenac.utils.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//form 값 읽기
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String save_chk = request.getParameter("save_ck");
	
	if("ezenac".equals(user_id) && "0111".equals(user_pw)){
		//로그인 성공
		if(save_chk !=null && save_chk.equals("Y")){
			//쿠키저장
			CookieManager.makeCookie(response, "loginId", user_id, 86400);
		}
		else{	//쿠키삭제
			CookieManager.deleteCookie(response, "loginId");
		}
		JSFunction.alertLocation("로그인에 성공했습니다.", "idsaveMain.jsp", out);
	}
	else{
		JSFunction.alertBack("로그인에 실패했습니다.", out);
	}
%>