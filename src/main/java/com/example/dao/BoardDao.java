package com.example.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Board;

/**
 * 게시판 Dao
 * @author youtube
 *
 */
@Repository
public class BoardDao {
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	/**
	 * 게시물 목록 조회 리턴
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<Board> selectBoardList(Map<String, Object> paramMap) 
			throws SQLException {
		return sqlMapClientTemplate.
			queryForList("selectBoardList", paramMap);
	}

	/**
	 * 게시물 조회
	 * @param boardSeq
	 * @return
	 * @throws SQLException
	 */
	public Board selectBoard(String boardSeq) throws SQLException  {
		return (Board) sqlMapClientTemplate
			.queryForObject("selectBoard", boardSeq);
	}
	
	/**
	 * 게시물 등록
	 * @param board
	 * @throws SQLException
	 */
	public void insertBoard(Board board) throws SQLException  {
		sqlMapClientTemplate
			.insert("insertBoard", board);
	}
	
	/**
	 * 게시물 업데이트
	 * @param board
	 * @throws SQLException
	 */
	public void updateBoard(Board board) throws SQLException  {
		sqlMapClientTemplate
			.update("updateBoard", board);
	}
	
	/**
	 * 게시물 삭제
	 * @param board
	 * @throws SQLException
	 */
	public void deleteBoard(int boardSeq) throws SQLException  {
		sqlMapClientTemplate
			.update("deleteBoard", boardSeq);
	}
	
}
