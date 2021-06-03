package com.icia.board.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;

@Controller
public class BoardController {
	
		@Autowired
		private BoardService bs;
		
		private ModelAndView mav;
		
		@RequestMapping(value="/writepage")
		public String writePage() {
			return "boardwrite";
		}
		@RequestMapping(value="/boardwrite")
		public ModelAndView boardWrite(@ModelAttribute BoardDTO board) {
			mav = bs.boardWrite(board);
			return mav;
		}
		@RequestMapping(value="/boardwritefile")
		public ModelAndView boardWriteFile(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
			mav = bs.boardWriteFile(board);
			return mav;
		}
		@RequestMapping(value="/boardlist")
		public ModelAndView boardList() {
			mav = bs.boardList();
			return mav;
		}
		
		@RequestMapping(value="/boardview")
		public ModelAndView boardView(@RequestParam("bnumber") int bnumber) {
			mav = bs.boardView(bnumber);
			return mav;
		}
		
		@RequestMapping(value="/boardupdate")
		public ModelAndView boardUpdate(@RequestParam("bnumber") int bnumber) {
			mav = bs.boardUpdate(bnumber);
			return mav;
		}

		@RequestMapping(value="/updateprocess")
		public ModelAndView updateProcess(@ModelAttribute BoardDTO board) {
			mav = bs.updateProcess(board);
			return mav;
		}
		
		@RequestMapping(value="/boarddelete")
		public ModelAndView boardDelete(@RequestParam("bnumber") int bnumber) {
			mav = bs.boardDelete(bnumber);
			return mav;
		}
	

}
