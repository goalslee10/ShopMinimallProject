package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {

	/*
	 	SqlSession session = MySqlSessionFactory.getSession();
	   try{
	   
	   }finally{
	    session.close();
	   }

	 */
	
	@Override
	public int memberAdd(MemberDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		   try{
			   MemberDAO dao = new MemberDAO();
			   num = dao.memberAdd(session, dto);
			   session.commit();
		   }finally{
		    session.close();
		   }

		return num;
	}// end memberAdd

	@Override
	public MemberDTO memberLogin(HashMap<String, String> map) throws Exception {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		   try{
			   MemberDAO dao = new MemberDAO();
			   dto = dao.memberLogin(session, map);
		   }finally{
		    session.close();
		   }
		return dto;
	}

	@Override
	public MemberDTO mypage(String userid) throws Exception {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		   try{
			   MemberDAO dao = new MemberDAO();
			   dto = dao.mypage(session, userid);
		   }finally{
		    session.close();
		   }
		
		return dto;
	}
	
}//end class
