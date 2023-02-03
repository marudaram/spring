package com.simple.score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("yyy") //DAO영역에서는 @Repository사용 , 이름 붙이는건 생략 가능
public class ScoreDAOImpl implements ScoreDAO {

	@Autowired
	private DataSource dataSource;

	@Override
	public void regist(ScoreVO vo) {

		String sql = "insert into score(name, kor, eng) values (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getKor());
			pstmt.setString(3, vo.getEng());

			pstmt.executeUpdate(); //insert, update, delete

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<ScoreVO> getList() {

		ArrayList<ScoreVO> list = new ArrayList<>();

		String sql = "select * from score order by num desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select 구문은 써줘야한다


		try {
			conn = dataSource.getConnection(); //연결객체

			pstmt = conn.prepareStatement(sql); //sql 넣어주는 객체

			rs = pstmt.executeQuery(); //결과

			//ORM -> Object Relation Mapping -> 객체와 데이터베이스에서 실행된 결과를 붙여줌
			while(rs.next()) {

				ScoreVO vo = new ScoreVO();
				vo.setNum(rs.getInt("num")); //column명
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getString("kor"));
				vo.setEng(rs.getString("eng"));

				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}


		return list;
	}

	@Override
	public void delete(int num) {
		
		//삭제기능 -
		//num은 key가 아니라 index가 넘어온다 (화면에서 key를 넘기도록 변경)
		//delete기능 구현

		String sql = "delete from score where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			pstmt.executeUpdate(); //insert, update, delete

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	/*

	//데이터베이스
	ArrayList<ScoreVO> list = new ArrayList<>();


	@Override
	public void regist(ScoreVO vo) {

		//연결..
		//connect
//		Class.forName("드라이버클래스"); 


//		System.out.println("DAO영역" + vo.toString());
		list.add(vo); //insert임
		System.out.println(list.toString());
	}


	@Override
	public ArrayList<ScoreVO> getList() {


		return list;
	}


	@Override
	public void delete(int num) {

		//삭제작업
		list.remove(num);
	}

	 */

}
