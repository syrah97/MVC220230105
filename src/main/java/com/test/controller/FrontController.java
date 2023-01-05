package com.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{

	private Map<String,SubController> list;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path=config.getServletContext().getContextPath(); // /02Mvc2 경로 저장
		System.out.println("[FC] CONTEXT PATH : " + path);
		list = new HashMap();
		
		//URL ,SubController 저장
		//Member
		list.put(path+"/member/join.do", new MemberJoinController());
		
		//Board
		list.put(path+"/board/list.do", new BoardListController());
		
		//Notice
		list.put(path+"/notice/list.do", new NoticeListController());

		//Auth
		list.put(path+"/auth/login.do", new LoginController());
		
		//Main
		list.put(path+"/main.do", new MainController());
		
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//문자셋 설정(Filter 이동예정)
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//SubController실행
		String uri = req.getRequestURI();
		System.out.println("[FC] URI : " + uri);
		SubController sub = list.get(uri);
		sub.execute(req, resp);
		 
	}

	
 
	
}
