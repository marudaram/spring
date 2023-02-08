package com.eunyoung.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString

@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 맴버변수를 담은 생성자
@Data // getter, setter, toString
public class TestVO {

	private String name;
	private int age;
	private String address;
	
}
