package com.controller;

import java.io.IOException;
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


@WebServlet("/cartList")
public class CartListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
				
		String nextPage="";
		if(dto!=null) {
			
			String userid = dto.getUserid();
			CartService service = new CartServiceImpl();
			try {
				List<CartDTO> list = service.cartList(userid);
				request.setAttribute("cartList", list);
				nextPage="cartList.jsp";
				
			} catch (Exception e) {
				
				nextPage="error/error.jsp";
			}
		}else {
			nextPage="member/logoutFail.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request, response);
		
	}//end doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
