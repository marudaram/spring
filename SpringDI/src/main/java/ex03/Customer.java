package ex03;

import java.util.List;
import java.util.Map;

public class Customer {
	
	//list or map의 의존성 주입
	private List<String> lists;
	private List<Person> persons;
	private Map<String, Object> maps;
	
	//getter
	public List<String> getLists() {
		return lists;
	}
	//setter
	public void setLists(List<String> lists) {
		this.lists = lists;
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	

}
