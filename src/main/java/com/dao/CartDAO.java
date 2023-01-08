package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.GoodsDTO;

public class CartDAO {
	
	public int cartAdd(SqlSession session, CartDTO dto) {
		return session.insert("com.mybatis.cart.CartMapper.cartAdd", dto);
	}
	public List<CartDTO> cartList(SqlSession session, String userid){
		return session.selectList("com.mybatis.cart.CartMapper.cartList", userid);
	}
	
	public int cartDel(SqlSession session, int num) {
		return session.delete("com.mybatis.cart.CartMapper.cartDel", num);
	}
	public int cartAllDel(SqlSession session, List<String> list) {
		return session.delete("com.mybatis.cart.CartMapper.cartAllDel", list);
	}


}
