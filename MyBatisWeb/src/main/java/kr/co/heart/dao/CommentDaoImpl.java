package kr.co.heart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.heart.domain.CommentDto;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private SqlSession session;
	private static String namespace = "kr.co.heart.dao.CommentMapper.";
	
	@Override
	public int deleteAll(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.delete(namespace+"deleteAll");
	}

	@Override
	public List<CommentDto> selectAll(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectAll", bno);
	}

}
