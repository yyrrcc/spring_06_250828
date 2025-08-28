package com.mycompany.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.member.dao.MemberDao;
import com.mycompany.member.dto.MemberDto;

@Controller
public class MemberController {
	
	// memberDao를 주입 받겠다
	@Autowired
	private MemberDao memberDao;
	
	
	@RequestMapping (value = "/join")
	public String join() {
		return "join";
	}
	@RequestMapping (value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("memberpw");
		String mname = request.getParameter("membername");
		int mage = Integer.parseInt(request.getParameter("memberage"));	
//		MemberDao memberDao = new MemberDao();
//		memberDao.insertMember(mid, mpw, mname, mage);
		memberDao.insertMember(mid, mpw, mname, mage);
		return "redirect:memberlist";
	}
	@RequestMapping (value = "/memberlist")
	public String memberlist(Model model) {
		List<MemberDto> memberDtos = memberDao.searchMembers();
		model.addAttribute("memberDtos", memberDtos);
		return "memberlist";
	}
	@RequestMapping (value = "/delete")
	public String delete() {
		return "delete";
	}
	@RequestMapping (value = "/deleteOk")
	public String deleteOk(HttpServletRequest request, Model model) {
		String mid = request.getParameter("memberid");
		memberDao.deleteMember(mid);
		return "deleteOk";
	}
	@RequestMapping (value = "/search")
	public String search() {
		return "search";
	}
	@RequestMapping (value = "/searchOk")
	public String searchOk(HttpServletRequest request, Model model) {
		String mid = request.getParameter("memberid");
		MemberDto memberDto = memberDao.searchMember(mid);
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("result", "회원 찾기 검색");
		return "search";
	}
}
