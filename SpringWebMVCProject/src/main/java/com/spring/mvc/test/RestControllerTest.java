package com.spring.mvc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController //스프링 4이상부터 사용가능
@RequestMapping("/rest")
public class RestControllerTest {
	
	/*
	 * @ResponseBody
	 * 리턴 데이터를 ViewResolver에게 전달하지 않고
	 클라이언트에게 해당 데이터를 바로 응답하게 한다!
	 */
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping("/hobbys")
	@ResponseBody
	public List<String> hobbys(){
		List<String> hobbys = Arrays.asList("축구","수영","음악감상");
		return hobbys;
	}
	
	
	@GetMapping("/study")
	@ResponseBody
	public Map<String, Object> study(){
		Map<String, Object> subject = new HashMap<String, Object>();
		subject.put("자바", "java");
		subject.put("JSP", "JAVA SERVER PAGES");
		subject.put("SPRING", "SPRING FRAMEWORK5");
		return subject;
	}
	
	@GetMapping("/person")
	@ResponseBody
	public Person person(){
		
		Person person = new Person();
		person.setName("김철수");
		person.setAge(30);
		person.setHobbys(Arrays.asList("수영","축구","요리"));
		
		return person;
	}
	
	
}
