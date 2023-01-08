package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;
import com.service.MemberService;
import com.service.MemberServiceImpl;


@WebServlet("/goodsRetrieve")
public class GoodsRetrieveController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gCode = request.getParameter("gCode");
		
		GoodsService service = new GoodsServiceImpl();
		
		String nextPage = "";
		try {
			GoodsDTO dto = service.goodsRetrieve(gCode);
			request.setAttribute("goodsRetrieve", dto);
			nextPage = "goodsRetrieve.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			
			nextPage = "error/error.jsp";
		}
		
		// jsp 위임 : forward
		request.getRequestDispatcher(nextPage).forward(request, response);
		
	}//end doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
