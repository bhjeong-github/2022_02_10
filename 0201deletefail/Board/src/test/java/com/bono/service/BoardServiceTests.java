package com.bono.service;

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
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testGetList() {
		
		List<BoardVO> list = service.getList(new Criteria(3,10));
		for ( int i=0; i<list.size(); i++ ) {
			log.info(list.get(i));
		}
		// list.forEach(board -> log.info(board));
	}
	
	
	/*@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);  // 해당되는 파라미터가 null이면 안된다.
	}*/
	
	/*@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("Test로 작성하는 글");
		board.setContent("Test로 만들고 있는 내용....");
		board.setWriter("writer33333");
		service.register(board);
		log.info("bno : " + board);
	}*/
	
	/*@Test
	public void testGetList() {
		List<BoardVO> list = service.getList();
		for (int i=0; i<list.size(); i++) {
			log.info(list.get(i));
		}
	}*/
	
	
	/*@Test
	public void testModify() {
		BoardVO board = new BoardVO();
		board.setBno(7L);
		board.setTitle("제목을 수정했어요.");
		board.setContent("test222");
		board.setWriter("writer7777");
	    service.modify(board);
		log.info("Update data : " + board);
	}*/
	
	/*@Test
	public void testUpdate() {
		BoardVO board = service.get(7L);
		if (board == null) {
			return;
		}
		
		board.setTitle("제목을 수정했어요.");
		log.info("Modify result : " 
					+ service.modify(board));
	}*/
	
	/*@Test
	public void testRemove() {
		boolean remove = service.remove(7L);
		if (remove == false) {
			return;
		}
		
		log.info("remove result : " + remove );
	}*/
	
	/*@Test
	public void testRemove() {
		BoardVO board = service.get(7L);
		if (board == null) {
			return;
		}
		
		log.info("Remove result : " + service.remove(board.getBno()));
	}*/
}
