package com.icia.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public int memberjoin(MemberDTO member) {
		return sql.insert("mm.memberjoin", member);
	}
	public String memberLogin(MemberDTO member) {
		return sql.selectOne("mm.memberlogin", member);
	}
	public MemberDTO update(String loginId) {
		return sql.selectOne("mm.memberupdate", loginId);
	}
	public int updateProcess(MemberDTO member) {
		return sql.update("mm.updateprocess", member);
	}
	public List<MemberDTO> memberList() {
		return sql.selectList("mm.memberlist");
	}
	public MemberDTO memberView(String mid) {
		return sql.selectOne("mm.memberview", mid);
	}
	public void memberDelete(String mid) {
		sql.delete("mm.memberdelete", mid);
	}
	public String idCheck(String mid) {
		return sql.selectOne("mm.idcheck", mid);
	}
	
}
