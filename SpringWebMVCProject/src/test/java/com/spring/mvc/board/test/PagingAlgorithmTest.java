package com.spring.mvc.board.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.repository.IBoardMapper;
import com.spring.mvc.commons.PageVO;
import com.spring.mvc.commons.SearchVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class PagingAlgorithmTest {
	
	/*
	 * 페이징 알고리즘 만들기
	 #1. 사용자가 보게  될 페이지 화면
		 - 한 화면에 페이지를 10개씩 끊어서 보여준다면?
		 ex) 1 2 3 4 5 ... 9 10 [다음] // [이전] 31 32 33 ..... 39 40 [다음]
		 
		 - 만약에 총 게시물의 수가 67개라면??
		 ex) 1 2 3 4 5 6 7 // 이전, 다음 비활성화
		 
		 - 총 게시물 수가 142개이고 현재 12페이지에 사용자가 머물러 있다면?
		 ex) [이전] 11 12 13 14 15 // 다음 비활성화
	 
	 
	 #2. 우선 총 게시물의 수를 조회해야 합니다.
		 - 총 게시물 수는 DB로부터 수를 조회하는 SQL을 작성
		 SELECT COUNT(*) FROM mvc_board
	 
	 #3. 사용자가 현재 위치한 페이지를 기준으로
	 	 끝페이지 번호를 계산하는 로직 작성
	 	-만약 현재 사용자가 보고있는 페이지가 3페이지고 한 화면에
	 	보여줄 페이지가 10페이지씩이라면??
	 	-> 끝페이지 번호는 ? 10페이지
	 	
	 	-만약 현재 사용자가 보고있는 페이지가 37페이지고 한 화면에
	 	보여줄 페이지가 20페이지씩이라면??
	 	-> 끝페이지 번호는 ? 40페이지
	 	
	 	-만약 현재 사용자가 보고있는 페이지가 63페이지고 한 화면에
	 	보여줄 페이지가 20페이지씩이라면??
	 	-> 끝페이지 번호는 ? 80페이지
	 	
	 	
	 	- 끝페이지 구하는 공식 : 올림(현재 위치한 페이지번호 / 한 화면당 보여질 페이지의 수) * 한 화명당 보여질 페이지의 수
	 				37/20 => 1.~~ 소수점 자릿수를 올림! => 2 * 20 => 40
	 	  자바로 표현 	: Math.ceil(현재 위치한 페이지번호 / 한 화면당 보여질 페이지의 수) * 한 화명당 보여질 페이지의 수
	 	  
	 #4. 시작페이지 번호 계산하기
	 	- 현재 위치한 페이지가 15페이지이고, 한 화면에 보여줄 페이지가 10페이지씩이라면?
	 	=> 시작페이지는? 11페이지
	 	
	 	- 현재 위치한 페이지가 73페이지이고, 한 화면에 보여줄 페이지가 20페이지씩이라면?
	 	=> 시작페이지는? 61페이지
	 	
	 	- 공식 : (끝 페이지 번호 - 한 화면에 보여줄 페이지의 수) + 1
	 	
	 #5. 끝페이지 보정
	  	- 총 게시물 수가 324개이고 한 페이지당 10개의 게시물을 보여준다.
	  	- 그리고 현재 이사람은 31페이지를 보고 있다.
	  	- 그리고 한 화면당 10개씩의 페이지를 로병주고 있다.
	  	- 그렇다면 위 공식에 의한 끝 페이지는 ? => 40페이지
	  	- 하지만 실제 페이지는 몇번이어야 하는가 ? => 33페이지
	  	
	  #5-1. 이전버튼 활성 여부 설정
	  - 언제 이전버튼을 비활성화 할 것인가? 시작페이지가 1인 부붙에서 비활성.
	  - 공식: 시작페이지번호가 1로 구해진 시점에서 비활성 처리
	  	  
	   #5-2. 끝 페이지 값 보정
	  - 다음 버튼이 비활성화 되었을 때 총 게시물 수에 맞춰 끝페이지 번호를 재보정 한다 
	  - 공식: Math.ceil(총 게시물의 수 / 한 페이지에 보여줄 게시물 수)
	  =>                 355/10 => 끝 36페이지, 45/10 => 끝 5페이지
	  
		#5-3. 다음버튼 활성 여부 설정
		- 언제 다음버튼을 비활성화 할 것인가? 
		- 공식: 보정전 끝헤이지 번호 * 한 페이지에 들어갈 게시물수 >= 총 게시물 -> 비활성화
	 */
	
	
	
	
	@Autowired
	private IBoardMapper mapper;
	
	@Test
	public void page() {
		
		//System.out.println("게시글의 총 갯수 : " + mapper.countArticles());
		
		//끝 페이지 번호 계산 테스트
		PageVO paging = new PageVO();
		paging.setPage(11);
		int displayPage = 10;
		
		//Math.ceil은 인자값으로 double을 요구해서 현재페이지나 카운트퍼페이지에 double 붙이기
		//Math.ceil의 리턴타임은 double => 6.7 올림 => 7.0 => 강제 형변환 int => 7  
		int endPage = (int)Math.ceil(paging.getPage() / (double)displayPage) * displayPage;
		System.out.println("끝페이지 번호 : " + endPage);
		
		//시작페이지 TEST
		int startPage = (endPage - displayPage) + 1;
		System.out.println("시작페이지 번호 : " + startPage);
		
		//시작페이지가 1이면 이전버튼 비활성화 처리!
		boolean isPrev = (startPage == 1) ? false : true;
		
		System.out.println("===============================================");
		System.out.println("이전 버튼 활성화 : " + isPrev);
		System.out.println("===============================================");
		
		//끝페이지 보정
		//getCountperPage 한화면에 보여줄 게시물수!
		//int temp = (int)Math.ceil(mapper.countArticles() / (double)paging.getCountPerPage());
		
		//재보정 여부 판단하기
		//if(endPage > temp) {
		//	endPage = temp;
		}
		//System.out.println("끝페이지 보정 페이지 : " + endPage);
		
		//boolean isNext = (mapper.countArticles() <= (endPage * paging.getCountPerPage())) ? false : true;
		//System.out.println("===============================================");
		//System.out.println("다음 버튼 활성화 : " + isNext);
		//System.out.println("===============================================");
		
	//}
	
	@Test
	public void searchTest(){
		SearchVO search = new SearchVO();
		search.setPage(2);
		search.setKeyword("7");
		
		System.out.println("===========================");
		//mapper.getArticleListByTitle(search)
		     // .forEach(vo -> System.out.println(vo));
		System.out.println("===========================");
	}

}
