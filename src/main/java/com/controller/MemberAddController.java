package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;


@WebServlet("/memberAdd")
public class MemberAddController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * ?userid=aaa&
		 * passwd=1234&
		 * passwd2=1234&
		 * username=aaa&
		 * post=07376&
		 * addr1=
		 * addr2=
		 * phone1=010&
		 * phone2=1234&
		 * phone3=1234&
		 * email1=aaa
		 * email2=naver.com
		 */
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		//String passwd2 = request.getParameter("passwd2");
		String username = request.getParameter("username");
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		MemberDTO dto = new MemberDTO();
		dto.setUserid(userid);
		dto.setPasswd(passwd);
		dto.setUsername(username);
		dto.setPost(post);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		
		MemberService service = new MemberServiceImpl();
		String nextPage="";
		try {
			//성공
			int num = service.memberAdd(dto);
			nextPage="member/memberAddSuccess.jsp";
		}catch (Exception e) {
			//실패
			nextPage="error/error.jsp";
			e.printStackTrace();
		}
		
		response.sendRedirect(nextPage);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
