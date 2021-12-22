package org.kosta.myproject.controller;

import javax.annotation.Resource;

import org.kosta.myproject.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Resource
	private BoardMapper boardMapper;

	@Autowired
	public HomeController(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@RequestMapping("/")
	public String home(Model model) {
		System.out.println("SpringBoot-Study1 home");
		model.addAttribute("board", boardMapper.getComId());
		model.addAttribute("list", boardMapper.getCategoryList());
		return "index";
	}

	@RequestMapping("/community-list")
	public String CommunityBoards(Model model) {
		model.addAttribute("board", boardMapper.getComId());
		model.addAttribute("list", boardMapper.getCategoryList());
		return "community-list";
	}

	@RequestMapping("/second-list")
	public String secondHandBoards(Model model) {
		model.addAttribute("board", boardMapper.getSecId());
		model.addAttribute("list", boardMapper.getCategoryList());
		return "second-list";
	}

}
