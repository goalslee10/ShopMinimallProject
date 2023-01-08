package com.controller;

import java.io.IOException;
import java.util.HashMap;

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


@WebServlet("/cartAdd")
public class CartAddController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
			?gImage=top1&
			gCode=T1&
			gName=앨리스+데님+탑&
			gPrice=12100&
			gSize=L&
			gColor=navy&
			gAmount=1
		 */
		
		// 로그인 이후의 작업들은 모두 세션이 존재여부 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String gCode = request.getParameter("gCode");
				
		String nextPage="";
		if(dto!=null) {
			
			String userid = dto.getUserid();
			String gName = request.getParameter("gName");
			String gPrice = request.getParameter("gPrice");
			String gSize = request.getParameter("gSize");
			String gColor = request.getParameter("gColor");
			String gAmount = request.getParameter("gAmount");
			String gImage = request.getParameter("gImage");
			
			CartDTO cartDTO = new CartDTO();
			cartDTO.setUserid(userid);
			cartDTO.setgCode(gCode);
			cartDTO.setgName(gName);
			cartDTO.setgPrice(Integer.parseInt(gPrice));
			cartDTO.setgSize(gSize);
			cartDTO.setgColor(gColor);
			cartDTO.setgAmount(Integer.parseInt(gAmount));
			cartDTO.setgImage(gImage);
			
			CartService service = new CartServiceImpl();
			try {
				int num = service.cartAdd(cartDTO);
				request.setAttribute("gCode", gCode);
				nextPage = "goods/cartAddSuccess.jsp";
			} catch (Exception e) {
				
				e.printStackTrace();
				nextPage="error/error.jsp";
			}
		}else {
			session.setAttribute("gCode", gCode);
			nextPage="member/logoutFail.jsp";
		}
				
		request.getRequestDispatcher(nextPage).forward(request, response);
		
	}//end doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
