package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public interface CartService {
	
	public int cartAdd(CartDTO dto) throws Exception;
	
	public List<CartDTO> cartList(String userid)throws Exception;
	
	public int cartDel(int num)throws Exception;
	
	public int cartAllDel(List<String> list)throws Exception; 
	
}
