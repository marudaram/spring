package com.simple.score.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreDAO;
import com.simple.score.mapper.ScoreMapper;

//@Controller //@Component//@Repository //@Service 다 동일하다
@Service("이름") //빈의 이름명시
public class ScoreServiceImpl implements ScoreService {

//	@Autowired
//	@Qualifier("yyy")
//	private ScoreDAO scoreDAO;
	
	//마이바티스의 매퍼
	@Autowired
	private ScoreMapper scoreMapper;
	
	
	public void regist(ScoreVO vo) {
		scoreMapper.regist(vo);
	}


	@Override
	public ArrayList<ScoreVO> getList() {
		return scoreMapper.getList();
	}


	@Override
	public void delete(int num) {
		scoreMapper.delete(num);
	}
	
}
