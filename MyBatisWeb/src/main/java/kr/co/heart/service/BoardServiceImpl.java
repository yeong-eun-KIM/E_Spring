package kr.co.heart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.heart.dao.BoardDao;
import kr.co.heart.domain.BoardDto;
import kr.co.heart.domain.SearchItem;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public List<BoardDto> getPage(Map map) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectPage(map);
	}

	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.count();
	}

	@Override
	public BoardDto read(Integer bno) throws Exception {
		BoardDto boardDto = boardDao.select(bno);
		//비즈니스 로직 추가(조회수 증가)
		boardDao.increaseViewCnt(bno);
		
		return boardDto;
	}

	@Override
	public int remove(Integer bno, String writer) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.delete(bno,writer);
	}

	@Override
	public int write(BoardDto boardDto) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.insert(boardDto);
	}

	@Override
	public int modify(BoardDto boardDto) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.update(boardDto);
	}

	@Override
	public int getSearchResultCnt(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.searchResultCnt(sc);
	}

	@Override
	public List<BoardDto> getSearchResultPage(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.searchResultPage(sc);
	}
}
