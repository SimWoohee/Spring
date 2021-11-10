package com.spring.database.jdbc.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.database.jdbc.board.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	//내부 클래스 선언
	class BoardMapper implements RowMapper<BoardVO>{
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO board = new BoardVO();
			board.setBoardNo(rs.getInt("board_no"));
			board.setWriter(rs.getString("writer"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			return board;
		}
	}

	
	@Override
	public List<BoardVO> getBoardList() {
		System.out.println("BoardDAO.getBoardList 실행 ");
		String sql = "SELECT * FROM jdbc_board ORDER BY board_no DESC";
		return template.query(sql, new BoardMapper());
		
	}

	@Override
	public void insertBoard(BoardVO board) {
		String sql = "INSERT INTO jdbc_board (writer, title, content) "
				+ "VALUES (?,?,?)";
		template.update(sql, board.getWriter()
				, board.getTitle(), board.getContent());
		
		System.out.println(board.toString());
	}

	@Override
	public void deleteBoard(int index) {
		String sql = "delete from jdbc_board where board_no=?";
		template.update(sql, index);
	}

	@Override
	public BoardVO getContent(int index) {
		String sql = "SELECT * FROM jdbc_board where board_no=?";
		//리스트는 query vs queryForObject 객체 1개
		return template.queryForObject(sql, new BoardMapper(), index);
	}

	@Override
	public void updateBoard(BoardVO board) {
		String sql = "UPDATE jdbc_board SET "
				+ "writer=?, title=?, content=? "
				+ "WHERE board_no=?";
		template.update(sql, board.getWriter(), 
				board.getTitle(), board.getContent(),
				board.getBoardNo());
		
	}

	@Override
	public List<BoardVO> getSearchList(String keyword) {
		String sql = "SELECT * FROM jdbc_board"
				+ "WHERE writer LIKE ?"
				+ "ORDER BY board_no DESC";
		return template.query(sql, new BoardMapper(), keyword);
	}

}
