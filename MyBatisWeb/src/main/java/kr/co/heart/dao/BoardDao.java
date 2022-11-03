package kr.co.heart.dao;

import kr.co.heart.domain.BoardDto;

public interface BoardDao {

	BoardDto select(Integer bno) throws Exception;
	
}
