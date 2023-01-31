package ex07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex02.MemberDAO;

public class MainClass {

	public static void main(String[] args) {
		
		//자바설정으로 만들어진 bean파일은
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		System.out.println(ctx.getBeanDefinitionCount()); //정의되어있는 빈의 개수
		
		MemberDAO dao = ctx.getBean("dao", MemberDAO.class);
		
		System.out.println(dao.getDatabaseDev().getUid());
	}
}
