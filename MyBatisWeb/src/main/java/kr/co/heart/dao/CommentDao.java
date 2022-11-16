package kr.co.heart.dao;

import java.util.List;

import kr.co.heart.domain.CommentDto;

public interface CommentDao {
	int deleteAll(Integer bno) throws Exception;

	List<CommentDto> selectAll(Integer bno) throws Exception;
}
