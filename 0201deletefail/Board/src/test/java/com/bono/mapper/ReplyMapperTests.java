package com.bono.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bono.domain.BoardVO;
import com.bono.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Autowired
	private ReplyMapper mapper;
	private Long[] bnoArr = {48L, 47L, 46L, 45L, 44L};
	
//	@Autowired
//	private BoardMapper bMapper;
	/*@Test
	public void testMapper() {
		log.info(mapper);
	}*/
	
	/*@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO reply = new ReplyVO();
			reply.setBno(bnoArr[i % 5]);
			reply.setReply("댓글 테스트" + i);
			reply.setReplyer("replyer" + i);
			mapper.insert(reply);
		});*/
		
		/*for(int i=1; i<=10; i++) {
			ReplyVO reply = new ReplyVO();
			reply.setBno(bnoArr[i % 5]);
			reply.setReply("댓글 테스트" + i);
			reply.setReplyer("replyer" + i);
			mapper.insert(reply);
		}
	}*/
	
	/*@Test
	public void testDelete() {
		int result = mapper.delete(21L);
		log.info("result : " + result);
	}*/
	
	/*@Test
	public void testRead() {
		Long rno = 20L;
		ReplyVO reply = mapper.read(rno);
		log.info(reply);
	}*/
	
	/*@Test
	public void testUpdate() {
		ReplyVO reply = mapper.read(8L);
		reply.setReply("수정테스트333333");		
		int count = mapper.update(reply);
		log.info("UPDATE COUNT : " + count);
	}*/
	
	/*@Test
	public void testList() {
		Criteria criteria = new Criteria();
		List<ReplyVO> list = mapper.getListWithPaging(criteria, 46L);
		list.forEach(reply->log.info(reply));
		
		// for (int i=0; i<list.size(); i++) {
		//	log.info(list.get(i));
		//	}
	}*/
	
	/*@Test
	public void testPaging() {
		Criteria criteria = new Criteria();
		criteria.setPageNum(2);
		criteria.setAmount(10);
		criteria.calOffset();
		List<ReplyVO> list = mapper.getListWithPaging(criteria, 44L);
		for (int i = 0; i < list.size(); i++) {
			log.info(list.get(i));
		}
		// list.forEach(reply -> log.info(reply));
	}*/
		
	  /*@Test    //댓글조작 레전드 ㅋㅋ 봉인 ㅋㅋ 
	   public void testReplyFactory() {
	         ReplyVO reply = new ReplyVO();
	         List<BoardVO> list = bMapper.getList();
	         for(long z= 1; z<= 20; z++) {
	            list.forEach(i -> {
	               reply.setBno(i.getBno());
	               reply.setReply("reply factory");
	               reply.setReplyer("replyerzz");
	               mapper.insert(reply);
	            });
	         }
	   } */
	
}
