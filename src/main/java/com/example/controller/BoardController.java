package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Board;
import com.example.service.BoardService;

@Controller
public class BoardController {
	
	final Logger logger = LogManager.getLogger(getClass());

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(ModelMap model,
			@RequestParam(required = false) String query) 
			throws Exception {
		logger.info("BoardController list 실행...");
		// 검색조건 파라메터

		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("query", query);
		
		// 서비스를 호출해서 게시물 목록을 리턴 받
		List<Board> boardList = boardService.selectBoardList(paramMap);
		
		model.addAttribute("boardList", boardList);
		return "/board/list";
	}

}
