package com.eunyoung.myweb.trip.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.eunyoung.myweb.command.TripVO;
import com.eunyoung.myweb.util.Criteria;

@Mapper
public interface TripMapper {

	public int noticeRegist(TripVO vo); //등록
//	public ArrayList<TripVO> getList(); //조회
	
	public ArrayList<TripVO> getList(Criteria cri); //페이지 처리
	public int getTotal(Criteria cri); //전체게시글 수
	
	public TripVO getContent(int tno); //상세조회
	public int noticeModify(TripVO vo); //수정
	public int noticeDelete(int tno); //삭제
	public void upHit(int tno); //조회수
	public  ArrayList<TripVO> getPrevNext(int tno); //이전글, 다음글
}
