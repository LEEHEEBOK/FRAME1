package com.icia.member.dto;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {
	private String mid;
	private String mpassword;
	private String mname;
	private String memail;
	private String mfilename;
	private MultipartFile mfile;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMfilename() {
		return mfilename;
	}
	public void setMfilename(String mfilename) {
		this.mfilename = mfilename;
	}
	public MultipartFile getBfile() {
		return mfile;
	}
	public void setBfile(MultipartFile mfile) {
		this.mfile = mfile;
	}
	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", memail=" + memail
				+ ", mfilename=" + mfilename + ", mfile=" + mfile + "]";
	}
	
	
}
