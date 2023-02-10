package com.bono.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import com.bono.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"
					 ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
@WebAppConfiguration
public class BoardControllerTests {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	/*@Test // 게시판 조회
	public void testList() throws Exception {
		log.info (mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
															.andReturn().getModelAndView().getModelMap());
	}*/
	
	/*@Test // 게시글 추가
	public void testRegister() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
		.param("title" , "test...새글")
		.param("content" , "새컨텐트는 새글에...")
		.param("writer" , "new writer")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}*/
	
	/*@Test // 게시글 조회
	public void testGet() throws Exception {
		log.info (mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "9"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}*/
	
	/*@Test	// 게시글 수정1
	public void testModify() throws Exception {
		log.info (mockMvc.perform(MockMvcRequestBuilders
				.get("/board/modify")
				.param("title", "한국16강")
				.param("content", "우루과이ㅅㄱ")
				.param("writer", "찢베르데")
				.param("bno", "6"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}*/
	
	/*@Test	// 게시글 수정2 이게맞음
	public void testModify() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
				.post("/board/modify")
				.param("bno", "6")
				.param("title", "한국16강")
				.param("content", "우루과이ㅅㄱ")
				.param("writer", "찢베르데"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		
			log.info(resultPage);
	}*/
	
	/*@Test	// 게시글 삭제
	public void testRemove() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
				.post("/board/remove")
				.param("bno", "11"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		
			log.info(resultPage);
				
	}*/
	
	@SuppressWarnings("unchecked")
	@Test
	public void testListPaging() throws Exception {
		ModelMap mm = mockMvc.perform(
		MockMvcRequestBuilders.get("/board/list")
		.param("pageNum", "3")
		.param("amount", "10"))
		.andReturn()
		.getModelAndView()
		.getModelMap();
	
		Object obj = mm.get("list");
		if (obj instanceof List) {
			List<BoardVO> list = (List<BoardVO>)obj;
			list.forEach(board->log.info(board));
		}
		// ((List<BoardVO>)mm.get("list")).forEach(board->log.info(board);
	}
}
