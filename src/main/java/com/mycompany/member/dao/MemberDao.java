package com.mycompany.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycompany.member.dto.MemberDto;

@Repository
public class MemberDao {
	
	// 컨테이너에서 만든 객체(bean)를 자동으로 받아줌, DI 주입, 
	@Autowired
	JdbcTemplate jdbctemplate;
	
	// 회원 추가 (insert문 구현)
	public void insertMember(String memberid, String memberpw, String membername, int memberage) {
		String sql = "INSERT INTO membertbl VALUES (?, ?, ?, ?)";
		jdbctemplate.update(sql, memberid, memberpw, membername, memberage);
	}
	// 회원 삭제 (delete문 구현) - 결과 int 로 반환, 1 성공 0 실패
	public void deleteMember(String memberid) {
		String sql = "DELETE FROM membertbl WHERE memberid = ?";
		jdbctemplate.update(sql, memberid);
	}
	// 회원 수정 (update문 구현) - 결과 int 로 반환, 1 성공 0 실패
	public int updateMember(String memberid, String memberpw, String membername, int memberage) {
		String sql = "UPDATE membertbl SET memberpw = ?, membername = ?, memberage = ? WHERE memberid = ?";
		return jdbctemplate.update(sql, memberid, memberpw, membername, memberage);
	}
	// 회원 1명 가져오기 (select문 구현) - queryForObject
	public MemberDto searchMember(String memberid) {
		String sql = "SELECT * FROM membertbl WHERE memberid = ?";
		// select문은 queryForObject로 받아주고, 레코드 한 줄 온 걸 mapper로 받고.. ?값 넣어주기..
		// Dto 필드 값과 동일해야함, setter가 있어야 함, 바로 return 해도 됨 ...
		MemberDto memberDto = jdbctemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class), memberid);
		return memberDto;
	}
	// 전체 회원 가져오기 (select문 구현) - query
	public List<MemberDto> searchMembers() {
		String sql = "SELECT * FROM membertbl";
		return jdbctemplate.query(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class));
	}
	
	
}
