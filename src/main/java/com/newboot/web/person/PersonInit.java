package com.newboot.web.person;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.newboot.web.proxy.Proxy;



@Component
public class PersonInit extends Proxy implements ApplicationRunner  {
	@SuppressWarnings("unused")
	private PersonRepository personRepository;
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	public PersonInit(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	/*
	 * @Override public void run(ApplicationArguments args) throws Exception {
	 * 
	 * 
	 * }
	 */

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = personRepository.count();
		if (count == 0) {
			Person person = null;
			String[][] mtx = { 
					{ "hong", "1", "홍길동",  "1980-01-01", "true", "0" ,"0","0","teacher" },
	                  { "kim", "1", "김유신",  "1980-05-05", "true", "0" ,"0","0","manager" },
	                  { "park", "1", "박지성",  "1981-06-05", "true", "0" ,"0","0","manager" },
	                  { "you", "1", "유관순",  "1985-09-09", "false", "3" ,"2","96","student" },
	                  { "parkjs", "1", "박지성",  "1981-06-05", "true", "1" ,"2","50","student" },
	                  { "na", "1", "나도욱",  "1993-06-05", "true", "2" ,"3","100","student" },
	                  { "mo", "1", "모모",  "1994-06-05", "false", "3" ,"4","87","student" },
	                  { "sa", "1", "사나",  "1992-06-05", "false", "2" ,"1","42","student" },
	                  { "ji", "1", "지효",  "1992-06-05", "false", "1" ,"2","98","student" },
	                  { "da", "1", "다현",  "1994-06-05", "false", "3" ,"4","75","student" },
	                  { "jj", "1", "쯔위",  "1996-06-05", "false", "2" ,"3","67","student" },
	                  { "cy", "1", "채영",  "1999-06-05", "false", "1" ,"2","45","student" },
	                  { "na2", "1", "나연",  "1995-06-05", "false", "2" ,"1","82","student" },
	                  { "jung", "1", "정연",  "1995-06-05", "false", "3" ,"3","68","student" },
	                  { "mi", "1", "미나",  "1992-06-05", "false", "2" ,"2","47","student" },
	                  { "im", "1", "임꺽정",  "1992-06-05", "true", "1" ,"4","52","student" },
	                  { "iu", "1", "아이유",  "1994-06-05", "false", "2" ,"4","96","student" },
	                  { "youjs", "1", "유재석",  "1998-06-05", "true", "3" ,"1","37","student" },
	                  { "kimsr", "1", "김수로",  "1990-06-05", "true", "2" ,"3","83","student" },
	                  { "jo", "1", "조세호",  "1991-06-05", "true", "2" ,"2","72","student" },
	                  { "yang", "1", "양세찬",  "1999-06-04", "true", "3" ,"2","95","student"}};
			for (String[] arr : mtx) {
				person = new Person();
				person.setUserid(arr[0]);
				person.setPasswd(arr[1]);
				person.setName(arr[2]);
				person.setBirthday(df.parse(arr[3]));
				person.setMale(Boolean.parseBoolean(arr[4]));
				person.setHak(integer(arr[5]));
				person.setBan(integer(arr[6]));
				person.setScore(integer(arr[7]));
				person.setRole(arr[8]);
				personRepository.save(person);
			}
		}
	}

}


/*
 * @Component public class PersonInit implements ApplicationRunner { private
 * PersonRepository personRepository; private static final DateFormat df = new
 * SimpleDateFormat("yyyy-MM-dd");
 * 
 * @Autowired public PersonInit(PersonRepository repository) {
 * this.personRepository = repository; }
 * 
 * @Override public void run(ApplicationArguments args) throws Exception {
 * 
 * long count = personRepository.count(); if(count ==0) { Person person = null;
 * String[][] mtx = {{"hong" , "1", "홍길동" , "1980-01-01","teacher"}, {"kim" ,
 * "1" ,"김유신", "1980-05-05" , "manager"}, {"park" , "1" ,"박지성", "1981-06-05"
 * ,"student"}, {"you" , "1" ,"유라", "1989-09-09" , "student"}, {"go" , "1"
 * ,"고종수", "1989-09-09","student"}, {"oh" , "1" ,"오징어", "1989-09-09","student"},
 * {"ma" , "1" ,"마사라", "1989-09-09","student"}, {"choi" , "1" ,"최씨",
 * "1989-09-09","student"}, {"cho" , "1" ,"조조", "1989-09-09","student"}, {"lee"
 * , "1" ,"이도", "1989-09-09","student"}, {"no" , "1" ,"노올",
 * "1989-09-09","student"}, {"so" , "1" ,"소라", "1989-09-09","student"}, {"jung"
 * , "1" ,"정유라", "1989-09-09" , "teacher"}, {"bono" , "1" ,"보노보노",
 * "1989-09-09","student"}, {"hi" , "1" ,"히히", "1989-09-09", "student"}, {"na" ,
 * "1" ,"나나", "1989-09-09", "manager"}, {"ho" , "1" ,"호성", "1989-09-09",
 * "student"} };
 * 
 * for(String[] arr : mtx) {
 * 
 * person = new Person(); person.setUserid(arr[0]); person.setPasswd(arr[1]);
 * person.setName(arr[2]); person.setBirthday(df.parse(arr[3]));
 * person.setRole(arr[4]); int a = (int)Math.random() * 2; String result = "";
 * if(a==1) { result = "w"; }else { result = "m";
 * 
 * } person.setGender(result); person.setHak((int)(Math.random()* 4 )+1);
 * person.setBan((int)(Math.random()* 6 )+1);
 * 
 * person.setScore((int)(Math.random()*100) );
 * 
 * 
 * 
 * personRepository.save(person);
 * 
 * 
 * } }
 * 
 * 
 * 
 * }
 * 
 * }
 */