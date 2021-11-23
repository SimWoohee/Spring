package com.spring.mvc.board.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IBoardMapper;
import com.spring.mvc.commons.SearchVO;

@Service
public class BoardService implements IBoardService {
	
	@Inject
	private IBoardMapper mapper;

	@Override
	public void insert(BoardVO article) {
		mapper.insert(article);
	}

	@Override
	public List<BoardVO> getArticlesList(SearchVO search) {
		List<BoardVO> list = mapper.getArticlesList(search);
		
		for(BoardVO article : list) {
			//현재시간 읽어오기
			long now = System.currentTimeMillis();
			long regTime = article.getRegDate().getTime();
			
									//1일을 밀리세컨드로 변경
			if(now - regTime < 60 * 60 * 24 * 10000) {
				article.setNewMark(true);
			}
		}
		return list;
	}


	@Override
	public Integer countArticles(SearchVO search) {
		return mapper.countArticles(search);
	}


	@Override
	public BoardVO getArticle(Integer boardNo) {
		mapper.updateViewCnt(boardNo);
		return mapper.getArticle(boardNo);
	}

	@Override
	public void update(BoardVO article) {
		mapper.update(article);
	}

	@Override
	public void delete(Integer boardNo) {
		mapper.delete(boardNo);
	}

}
