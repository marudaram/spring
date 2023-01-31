package ex06;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImpl {
	
	private DAO dao;

	//기본생성자
	public ServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public ServiceImpl(DAO dao) {
		this.dao = dao;
	}

	//사용할 메서드
	public String hello() {
		
		return dao.hello();
	}
	
}
