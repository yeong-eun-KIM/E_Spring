package kr.co.heart.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.heart.domain.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace ="kr.co.heart.dao.BoardMapper.";
	
	@Override
	public BoardDto select(Integer bno) throws Exception {
		return session.selectOne(namespace + "select",bno);
	}
	
}
