package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;


@WebServlet("/main")
public class MainController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gCategory = request.getParameter("gCategory");
		if(gCategory==null) {
			gCategory = "top";
		}
		
		// 상품 목록
		GoodsService service = new GoodsServiceImpl();
		
		String nextPage = "";
		try {
			List<GoodsDTO> list = service.goodsList(gCategory);
			request.setAttribute("goodsList", list);
			
			nextPage = "main.jsp";
		} catch (Exception e) {
			
			e.printStackTrace();
			nextPage="error/error.jsp";
		}
		
		// main.jsp 위임 = forward
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
