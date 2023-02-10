package com.bono.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bono.domain.BoardVO;
import com.bono.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	/*@Test
	public void testDelete() {
		
		int result = mapper.delete(8L);
		log.info("result : " + result);
	}*/
	
	
	/*@Test
	public void testRead() {
		long bno = 4L;
		
		log.info("" + mapper.read(bno));
	}*/
	
	/*@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getList();
		for (int i=0; i<list.size(); i++) {
			log.info(list.get(i));
		}
	}*/
	/*@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새글");
		board.setContent("새글의 내용");
		board.setWriter("writer1234");
		mapper.insert(board);
		log.info(board);
	}*/
	
	/*@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(4L);
		board.setTitle("이거로 수정22");
		board.setContent("이건 222");
		board.setWriter("writer1234");
		
		int count = mapper.update(board);
	    mapper.update(board);
		log.info("UPDATE COUNT : " + count);
	
	}*/
	
	/*@Test
	public void testPaging() {
		Criteria criteria = new Criteria();
		criteria.setPageNum(3);
		criteria.setAmount(10);
		criteria.calOffset();
		List<BoardVO> list = mapper.getListWithPaging(criteria);
		
		for ( int i=0; i<list.size(); i++ ) {
			log.info(list.get(i));
		}
		// list.forEach(board -> log.info(board));
	}*/
	
	@Test
	public void testSearch() {
		Criteria criteria = new Criteria();
		criteria.setKeyword("짱짱");
		criteria.setType("TCW");
		criteria.calOffset();
		List<BoardVO> list = mapper.getListWithPaging(criteria);
		for (int i=0; i<list.size(); i++) {
			log.info(list.get(i));
		}
		//list.forEach(board -> log.info(board));
	}
	

}
