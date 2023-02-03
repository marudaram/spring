package com.simple.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.Quiz02VO;
import com.simple.command.Quiz03VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {


	//quiz01 화면띄우기
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	//quiz01 요청 - sendBirth
	@RequestMapping(value="/sendBirth", method=RequestMethod.POST)
	public String sendBirth(@ModelAttribute("article") Quiz01VO vo) {
		
		System.out.println(vo.getYear()+vo.getMonth()+vo.getDay());
		
		return "quiz/quiz01_ok";
	}
	

	//quiz02 화면띄우기
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	//
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(HttpServletRequest request,
						@ModelAttribute("article2") Quiz02VO vo) {
		
		String id = vo.getId();
		String pw = vo.getPw();
		String name = vo.getName();
		String email = vo.getEmail();
		
		System.out.println(id + "/" + pw + "/" + name + "/" + email);
		
		return "quiz/quiz02_ok";
	}
	
	//quiz03 화면띄우기
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping(value="/join2", method=RequestMethod.POST)
	public String join2(HttpServletRequest request,
						@ModelAttribute("article3") Quiz03VO vo,
						RedirectAttributes ra) {
		
		String id = vo.getId();
		String pw = vo.getPw();
		String pw_check = vo.getPw_check();
		
		if(id.equals("")) {
			ra.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if(!pw.equals(pw_check)) {
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else {
			return "quiz/quiz03_ok";
			
		}
		
	}
	
}
