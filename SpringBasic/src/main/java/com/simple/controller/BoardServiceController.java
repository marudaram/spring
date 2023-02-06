package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.board.BoardService;
import com.simple.board.BoardServiceImpl;
import com.simple.command.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardServiceController {

	//인터페이스 타입 선언
	@Autowired
	@Qualifier("boardService")
	private BoardService service;
	
	//화면 띄우기
	@RequestMapping("/boardRegister")
	public String registView() {
		return "board/boardRegister";
	}
	
	//폼요청
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(BoardVO vo) {
//		System.out.println(vo.toString());
		service.boardRegist(vo);
		
		return "board/boardResult";
	}
	
	//목록화면
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		ArrayList<BoardVO> list = service.getList();
		model.addAttribute("list", list);
		
		return "board/boardList";
		
	}
	
	//삭제요청
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		service.boardDelete(num);
		
		return "redirect:/board/boardList";
	}
	
	
	
}
