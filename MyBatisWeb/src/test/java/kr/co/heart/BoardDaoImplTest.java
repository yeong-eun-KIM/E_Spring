package kr.co.heart;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.heart.dao.BoardDao;
import kr.co.heart.domain.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest {
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void selectTest() throws Exception {
		assertTrue(boardDao != null);
		System.out.println("boardDao = " + boardDao);
		
		BoardDto boardDto = boardDao.select(1);
		System.out.println("boardDto = " + boardDto);
		assertTrue(boardDto.getBno().equals(1));
	}
}
