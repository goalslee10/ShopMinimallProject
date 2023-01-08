package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public interface MemberService {
	
	public int memberAdd(MemberDTO dto) throws Exception;
	
	public MemberDTO memberLogin(HashMap<String, String> map) throws Exception;
	
	public MemberDTO mypage(String userid) throws Exception;

}
