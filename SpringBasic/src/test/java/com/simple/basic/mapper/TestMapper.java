package com.simple.basic.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

public interface TestMapper {

	public String getTime(); //1
	public ArrayList<ScoreVO> getScore();
	public ScoreVO getOne(int a);
	
	public int insertOne(String name); //단일값
	public int insertTwo(ScoreVO vo); //다중값
	public int insertThree(Map<String, String> map);
	
	public Map<String, Object> selectMap(int num); //3번 키값 조회
	public ArrayList<Map<String, Object>> selectTwo(); //맵을 통한 다중행 조회
	
	
	public boolean updateOne(ScoreVO vo); //update
	
	
	public void insertFour(@Param("변수명1") String name, @Param("변수명2") int Kor);
	
}
