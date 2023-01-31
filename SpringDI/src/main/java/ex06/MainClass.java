package ex06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("hello-context.xml");

		Controller cont = ctx.getBean("cont", Controller.class);
		
//		ServiceImpl serv = ctx.getBean("serv", ServiceImpl.class);
		
		cont.hello();
		
//		System.out.println(cont.getServ().hello());
//		System.out.println(serv.getDao().hello());
//		
	}
}
