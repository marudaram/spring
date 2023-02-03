package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.score.service.ScoreService;
import com.simple.score.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ServiceController {

	//1.
//		ScoreServiceImpl service = new ScoreServiceImpl();
	
	//2 - service를 bean으로 생성한다 -> 의존객체 자동주입 @Autowired
	
	//3 - @Service로 빈 생성, 의존객체 자동주입 -> 가장 편해서 자주쓰인다
	
	@Autowired
	@Qualifier("이름")
	private ScoreService service; //인터페이스 타입 선언 - 구현체가 실행되므로 결과는 같다
	
	//화면띄우기
	@RequestMapping("/scoreRegist")
	public String registView() {
		return "service/scoreRegist";
	}
	
	//폼요청
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(ScoreVO vo) {
//		System.out.println(vo.toString());
		
		service.regist(vo);
		
		return "service/scoreResult";
	}
	
	//목록화면
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		//data 조회
		
		ArrayList<ScoreVO> list = service.getList();
		model.addAttribute("list", list);
		
		return "service/scoreList";
	}
	
	
	//삭제요청
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) { //단일값이기 때문에 @RequestParam 사용해주면 좋다
		
//		System.out.println(num);
		
		service.delete(num);
		
		return "redirect:/service/scoreList"; //삭제 후에 목록으로
	}
	
	
}
