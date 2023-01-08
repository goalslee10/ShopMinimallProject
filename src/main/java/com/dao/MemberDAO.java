package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	//회원 저장
	public int memberAdd(SqlSession session, MemberDTO dto) {
		return session.insert("com.mybatis.member.MemberMapper.memberAdd", dto);
	}
	
	//회원 로그인
	public MemberDTO memberLogin(SqlSession session, HashMap<String, String> map) {
		return session.selectOne("com.mybatis.member.MemberMapper.memberLogin",map);
	}
	
	//mypage
	public MemberDTO mypage(SqlSession session, String userid) {
		return session.selectOne("com.mybatis.member.MemberMapper.mypage", userid);
	}

}
