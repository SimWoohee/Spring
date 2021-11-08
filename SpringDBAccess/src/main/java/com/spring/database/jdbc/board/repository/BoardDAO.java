package com.spring.database.jdbc.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.database.jdbc.board.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {
	
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
	
	
	private JdbcTemplate template;
	
	@Override
	public List<BoardVO> getBoardList() {
		System.out.println("BoardDAO.getBoardList 실행 ");
		String sql = "SELECT * FROM jdbc_board";
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

}
