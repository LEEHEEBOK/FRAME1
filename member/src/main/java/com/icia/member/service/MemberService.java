package com.icia.member.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO mdao;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;
	

	public ModelAndView memberjoin(MemberDTO member) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		
		int insertResult =0;
		insertResult = mdao.memberjoin(member);
		if(insertResult>0) {
			mav.setViewName("memberjoin");
		} else {
			mav.setViewName("joinfail");
		}
		
		MultipartFile mfile = member.getBfile();
		String mfilename = mfile.getOriginalFilename();
		mfilename =System.currentTimeMillis() + "-" + mfilename;
		String savePath = "D:\\source_L\\spring\\FRAME-master\\Member\\src\\main\\webapp\\resources\\upload" +mfilename;
		if(!mfile.isEmpty()) {
			mfile.transferTo(new File(savePath));
		}
		member.setMfilename(mfilename);
		mdao.memberjoin(member);
		
		mav.setViewName("redirect:/memberlist");
		return mav;
	}


	public ModelAndView memberLogin(MemberDTO member) {
		mav = new ModelAndView();
		String loginId = mdao.memberLogin(member);
		if(loginId != null) {
			session.setAttribute("loginMember", loginId);
			mav.setViewName("membermain");
		}else {
			mav.setViewName("memberlogin");
		}
		return mav;
	}


	public ModelAndView update() {
		mav = new ModelAndView();
		String loginId = (String) session.getAttribute("loginMember");
		MemberDTO memberUpdate = mdao.update(loginId);
		mav.addObject("member123", memberUpdate);
		mav.setViewName("memberupdate");
		
		return mav;
	}


	public ModelAndView updateProcess(MemberDTO member) {
		mav = new ModelAndView();
		int updateResult = mdao.updateProcess(member);
		if(updateResult > 0) {
			mav.setViewName("membermain");
		} else {
			mav.setViewName("updatefail");
		}
		return mav;
	}


	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<MemberDTO> memberList = mdao.memberList();
		mav.addObject("memberList", memberList);
		mav.setViewName("memberlist");
		return mav;
	}
	public ModelAndView memberView(String mid) {
		mav = new ModelAndView();
		
		MemberDTO member = mdao.memberView(mid);
	
		mav.addObject("result", member);
		mav.setViewName("memberview");
		
		return mav;
	}
	public ModelAndView memberDelete(String mid) {
		mav = new ModelAndView();
		mdao.memberDelete(mid);
		mav.setViewName("redirect:/memberlist");
		return mav;
	}

	public String idCheck(String mid) {
		String checkResult = mdao.idCheck(mid);
		String result = "";
		if(checkResult == null) {
			result = "ok";
		} else {
			result = "no";
		}
		
		System.out.println("서비스클래스 체크결과"+result);
		return result;
	}

	public MemberDTO memberViewAjax(String mid) {
		MemberDTO member = mdao.memberView(mid);
		return member;
	}		
}
