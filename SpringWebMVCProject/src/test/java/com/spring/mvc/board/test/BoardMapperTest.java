package com.spring.mvc.board.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IBoardMapper;
import com.spring.mvc.commons.PageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class BoardMapperTest {
	
	@Autowired
	private IBoardMapper mapper;
	
	@Test
	public void insertTest() {
		
		for(int i=0; i < 100; i++) {
			BoardVO article = new BoardVO();
			article.setTitle("Test" + i);
			article.setWriter("TEST" + i);
			article.setContent("Test" + i);
			mapper.insert(article);
			System.out.println("게시물 등록 성공");
			
		}
		
	}
	
	@Test
	public void selectTest() {
		
		/*
		 * List<BoardVO> list = mapper.getArticleList(); for(BoardVO article : list) {
		 * System.out.println(article.toString()); }
		 */
		
		//mapper.getArticleList().forEach(article1 -> System.out.println(article1));
	}
	
	/*
	 * @Test public void select() { //44번 게시물 조회
	 * mapper.getArticle(44).forEach(article2 -> System.out.println(article2)); }
	 */
	
	
	@Test
	public void update() {
		BoardVO board = new BoardVO();
		board.setBoardNo(1);
		board.setTitle("그렇다고 합니다");
		board.setContent("그렇냐");
		
		mapper.update(board);
	}
	
	@Test
	public void delete() {
		mapper.delete(1);
	}
	
	@Test
	public void paginList() {
		System.out.println("=========================================");
		
		PageVO paging = new PageVO();
		paging.setPage(0);
		paging.setCountPerPage(20);
		//mapper.getArticleListPaging(paging).forEach(vo -> System.out.println(vo));
		System.out.println("=========================================");
		
	}

}
