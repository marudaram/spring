package com.simple.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.basic.mapper.TestMapper;
import com.simple.command.ScoreVO;

@RunWith(SpringJUnit4ClassRunner.class)         //JUnit으로 테스트환경을 구성
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class JDBCMybatis {

	@Autowired
	SqlSessionFactoryBean sqlSessionFactory;

	@Autowired
	TestMapper testMapper;


	//	@Test
	//	public void testCode01() {
	//		//마이바티스 핵심 객체
	//		System.out.println(sqlSessionFactory);
	//		
	//	}
	//	
	//	@Test
	//	public void testCode02() {
	//		String time = testMapper.getTime();
	//		System.out.println(time);
	//	}


	//select 태그의 resultType
//		@Test
//		public void testCode03() {
//			ArrayList<ScoreVO> list = testMapper.getScore();
//			System.out.println(list.toString());
//		}

	//매개변수 - 단일값
//		@Test
//		public void testCode04() {
//			ScoreVO vo = testMapper.getOne(6);
//			System.out.println(vo.toString());
//		}


	//insert - 단일값
//		@Test
//		public void testCode05() {
//			
//			int result = testMapper.insertOne("쪼니");
//			System.out.println("성공실패: " + result);
//		}

	//insert - 다중값(setter명) - setter가 파라미터가 된다
//		@Test
//		public void testCode06() {
//			ScoreVO vo = new ScoreVO(0, "테스트" , "100", "100");
//			
//			int result = testMapper.insertTwo(vo);
//			System.out.println("성공실패: " + result);
//		}

	//insert - 다중값(Map): key값이 파라미터가 된다
//		@Test
//		public void testCode07() {
//			
//			Map<String, String> map = new HashMap<>();
//			map.put("name", "조으녕");
//			map.put("kor", "90");
//			map.put("eng", "100");
//			
//			int result = testMapper.insertThree(map);
//			System.out.println("성공실패: " + result);
//		}

	//select - map타입의 반환
//		@Test
//		public void testCode08() {
//			
//			Map<String, Object> map = testMapper.selectMap(6);
//			
//			System.out.println(map.toString());
//		}

	//select - map타입의 반환: map타입을 사용하는 것을 부득이한 경우에만 사용한다
//		@Test
//		public void testCode09() {
//			
//			ArrayList<Map<String, Object>> list = testMapper.selectTwo();
//			
//			System.out.println(list.toString());
//			
//		}

	//update구문
//	@Test
//	public void testCode10() {
//		ScoreVO vo = new ScoreVO(7, "또또치", "100", "100");
//		boolean result = testMapper.updateOne(vo);
//		System.out.println(result);
//	}
//	
	//insert구문 @Param - 매개변수가 2개 이상일 때 매개변수에 이름붙
//	@Test
//	public void testCode11() {
//		testMapper.insertFour("파람테스트", 100);
//	}


}
