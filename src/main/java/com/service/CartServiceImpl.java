package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dto.CartDTO;

public class CartServiceImpl implements CartService {
	
	/*
 	SqlSession session = MySqlSessionFactory.getSession();
   try{
   
   }finally{
    session.close();
   }

 */

	@Override
	public int cartAdd(CartDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		   try{
			   CartDAO dao = new CartDAO();
			   num = dao.cartAdd(session, dto);
			   session.commit();
		   
		   }finally{
		    session.close();
		   }
		return num;
	}//end carAdd

	@Override
	public List<CartDTO> cartList(String userid) throws Exception {
		List<CartDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		   try{
			   CartDAO dao = new CartDAO();
			   list = dao.cartList(session, userid);
		   }finally{
		    session.close();
		   }
		return list;
	}//end carList

	@Override
	public int cartDel(int num) throws Exception {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		   try{
			   CartDAO dao = new CartDAO();
			   n = dao.cartDel(session, num);
			   session.commit();
		   
		   }finally{
		    session.close();
		   }
		return 0;
	}//end carDel

	@Override
	public int cartAllDel(List<String> list) throws Exception {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		   try{
			   CartDAO dao = new CartDAO();
			   n = dao.cartAllDel(session, list);
			   session.commit();
		   
		   }finally{
		    session.close();
		   }
		
		return n;
	}

}
