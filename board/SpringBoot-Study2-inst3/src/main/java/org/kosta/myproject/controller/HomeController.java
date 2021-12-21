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
		model.addAttribute("list",boardMapper.getCategoryList());
		return "index";
	}

}
