package com.spring.mvc.board.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class UserMapperTest {
	
	@Autowired
	private IUserMapper mapper;

	@Test
	public void registerTest() {
		UserVO user = new UserVO();
		user.setAccount("simw456");
		user.setPassword("1234");
		user.setName("박영희");
		
		mapper.regsiter(user);
	}
	
	@Test
	public void deleteTest() {
		mapper.delete("test1234");
		System.out.println("탈퇴성공");
	}
	
	@Test
	public void selectTest() {
		UserVO user = mapper.select("simw456");
		System.out.println("조회 성공 param " + user.toString());
	}
	
	@Test
	public void loginTest() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String inputId = "simw456";
		String inputPw = "test1234!";
		
		UserVO dbData = mapper.selectOne(inputId);
		String dbpw = dbData.getPassword();
		
		System.out.println("입력된 비밀번호" + inputPw);
		System.out.println("db에등록된 비밀번호" + dbpw);
		
		System.out.println("비밀번호 일지 ??" + encoder.matches(inputPw, dbpw));
	}

}
