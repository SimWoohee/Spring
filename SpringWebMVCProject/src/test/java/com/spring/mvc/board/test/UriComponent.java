package com.spring.mvc.board.test;

import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UriComponent {
		
		@Test
		public void testUriComp() {
			
			//Uri를 쉽게 작성할 수 있도록 도와주는 유틸 클래스 UriComponentBuilder 사용하기
		UriComponents ucp = UriComponentsBuilder.newInstance()
			.path("/board/list")
			.queryParam("page", 3)
			.queryParam("countPerPage", 20)
			.queryParam("keyword", "메롱")
			.queryParam("condition", "titie")
			.build();
			
		
		System.out.println(ucp.toString());
			
		}

}
