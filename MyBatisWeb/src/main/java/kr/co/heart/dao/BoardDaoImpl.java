package kr.co.heart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.heart.domain.BoardDto;
import kr.co.heart.domain.SearchItem;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace ="kr.co.heart.dao.BoardMapper.";
	
	@Override
	public BoardDto select(Integer bno) throws Exception {
		return session.selectOne(namespace + "select",bno);
	}

	@Override
	public int insert(BoardDto dto) throws Exception {
		// TODO Auto-generated method stub
		return session.insert(namespace + "insert",dto);
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"count");
	}

	@Override
	public int deleteAll() throws Exception {
		// TODO Auto-generated method stub
		return session.delete(namespace+"deleteAll");
	}

	@Override
	public List<BoardDto> selectPage(Map map) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectPage", map);
	}

	@Override
	public int increaseViewCnt(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.update(namespace+"increaseViewCnt", bno);
	}

	@Override
	public int delete(Integer bno, String writer) throws Exception {
		Map map = new HashMap();
		map.put("bno", bno);
		map.put("writer", writer);
		return session.delete(namespace+"delete", map);
	}

	@Override
	public int update(BoardDto boardDto) throws Exception {
		// TODO Auto-generated method stub
		return session.update(namespace+"update", boardDto);
	}

	@Override
	public int searchResultCnt(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"searchResultCnt", sc);
	}

	@Override
	public List<BoardDto> searchResultPage(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"searchResultPage", sc);
	}

	@Override
	public int updateCommentCnt(Integer bno, int cnt) throws Exception {
		Map map = new HashMap();
		map.put("cnt", cnt);
		map.put("bno", bno);
		return session.update(namespace+"updateCommentCnt", map);
	}
	
}
