package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("x", userid);
		map.put("y", passwd);
		
		MemberService service = new MemberServiceImpl();
		String nextPage = "";
		try {
			MemberDTO dto = service.memberLogin(map);
			if(dto != null) {
				nextPage = "member/loginSuccess.jsp";
				
				//세션에 저장
				HttpSession session = request.getSession();
				session.setAttribute("login", dto);
				
			}else {
				nextPage = "member/loginFail.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			nextPage = "error/error.jsp";
		}
		
		response.sendRedirect(nextPage);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
