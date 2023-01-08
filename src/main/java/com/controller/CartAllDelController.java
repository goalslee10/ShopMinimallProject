package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.CartServiceImpl;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;
import com.service.MemberService;
import com.service.MemberServiceImpl;


@WebServlet("/cartAllDel")
public class CartAllDelController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 로그인 이후의 작업들은 모두 세션이 존재여부 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
				
		String nextPage="";
		if(dto!=null) {
			
			String [] check_list = request.getParameterValues("check");
			List<String> del_cart_list =
					Arrays.asList(check_list);
			
			CartService service = new CartServiceImpl();
			try {
				int n = service.cartAllDel(del_cart_list);
				nextPage="cartList";
			} catch (Exception e) {
				
				e.printStackTrace();
				nextPage="error/error.jsp";
			}
			
		}else {
			nextPage="member/logoutFail.jsp";
		}
				
		response.sendRedirect(nextPage);
		
	}//end doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
