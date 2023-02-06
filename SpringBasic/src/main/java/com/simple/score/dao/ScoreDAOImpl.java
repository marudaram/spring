package com.simple.score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("scoreDAO") //DAO영역에는 Repository를 사용한다.
public class ScoreDAOImpl implements ScoreDAO{
   
   @Autowired
   private DataSource dataSource;
   
   public ScoreDAOImpl() {
   }
   
   @Override
   public void regist(ScoreVO vo) {
      String sql = "insert into score(name, kor, eng) values(?, ?, ?)";
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
         // TODO: handle exception
      } finally {
         try {
            if(conn != null) conn.close();
            if(pstmt != null) pstmt.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
      
   }
   
   @Override
   public ArrayList<ScoreVO> getList() {
      
      ArrayList<ScoreVO> list = new ArrayList<>();
      String sql = "select * from score order by num";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null; //데이터를 저장하는 객체 ORM
      
      try {
         
         conn = dataSource.getConnection();
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            ScoreVO vo = new ScoreVO();
            vo.setNum(rs.getInt("num"));
            vo.setName(rs.getString("name"));
            vo.setKor(rs.getString("kor"));
            vo.setEng(rs.getString("eng"));
            
            list.add(vo);
         }
         
         //ORM -> Object Relation 
         
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(conn != null) conn.close();
            if(pstmt != null) pstmt.close();
            if(rs != null) rs.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
      return list;
   }
   
   @Override
   public void delete(int num) {
      
      //삭제기능 - num은 key가 아니라 index가 넘어온다. 화면에서 key를 넘기도록 변경
      String sql = "delete from score where num = ?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         conn = dataSource.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, num);
         
         pstmt.executeUpdate(); //insert, update, delete
         
      } catch (Exception e) {
         // TODO: handle exception
      } finally {
         try {
            if(conn != null) conn.close();
            if(pstmt != null) pstmt.close();
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
      
   }
   
   
   /*
   //데이터베이스
   ArrayList<ScoreVO> list = new ArrayList<>();
   
   @Override
   public void regist(ScoreVO vo) {
//      System.out.println("DAO영역:"+vo.toString());
      list.add(vo); //insert임.
      System.out.println(list.toString());
   }
   
   @Override
   public ArrayList<ScoreVO> getList() {
      //데이터 조회
      return list;
   }
   
   @Override
   public void delete(int num) {
      list.remove(num);
   }
   */
}