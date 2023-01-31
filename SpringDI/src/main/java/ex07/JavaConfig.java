package ex07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex02.Chef;
import ex02.DatabaseDev;
import ex02.Hotel;
import ex02.MemberDAO;

//xml을 대신해서 설정파일로 사용할 때
@Configuration
public class JavaConfig {

	//@Bean이 붙은 메서드를 스프링 컨테이너가 호출시킴(빈으로 생성)
	@Bean
	public Chef chef() {
		return new Chef();
	}
	
	@Bean
	public Hotel hotel() {
		
//		Chef chef = new Chef();
//		return new Hotel(chef);
		
		return new Hotel(chef());
	}
	
	@Bean
	public DatabaseDev dev() {
		
		DatabaseDev dev = new DatabaseDev();
		dev.setUrl("주소...");
		dev.setUid("아이디...");
		dev.setUpw("비밀번호...");
		
		return dev;
	}
	@Bean
	public MemberDAO dao() {
		
		MemberDAO dao = new MemberDAO();
		dao.setDatabaseDev(dev());
		
		return dao;
	}
	
}
