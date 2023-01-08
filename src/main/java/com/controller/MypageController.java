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


@WebServlet("/mypage")
public class MypageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String nextPage="";
		if(dto!=null) {
			// 사용자 id 얻기
			String userid = dto.getUserid();
			//userid 이용해서 DB에서 새로운 MemberDTO 얻고 다시 세션에 저장.
			MemberService service = new MemberServiceImpl();
			try {
				dto = service.mypage(userid);
				session.setAttribute("login", dto);
			} catch (Exception e) {
				e.printStackTrace();
				nextPage = "error/error.jsp";
			}
			nextPage="mypage.jsp";
		}else {
			nextPage="member/logoutFail.jsp";
		}
		
		response.sendRedirect(nextPage);
		
	}// end doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
