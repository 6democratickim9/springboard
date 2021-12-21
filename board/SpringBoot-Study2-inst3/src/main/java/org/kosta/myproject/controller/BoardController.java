package org.kosta.myproject.controller;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.kosta.myproject.model.domain.BoardDTO;
import org.kosta.myproject.model.mapper.BoardMapper;
import org.kosta.myproject.model.mapper.CommentBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Resource
	private BoardMapper boardMapper;
	@Resource
	private CommentBoardMapper commentBoardMapper;
	
	
	@Autowired
	public BoardController(BoardMapper boardMapper, CommentBoardMapper commentBoardMapper) {
		super();
		this.boardMapper = boardMapper;
		this.commentBoardMapper = commentBoardMapper;
	}

	@RequestMapping("/list")
	public String getAllLists(Model model, int boardId, int categoryId) {
		
		model.addAttribute("board", boardMapper.getBoardName(boardId));
		model.addAttribute("category", boardMapper.getCatName(categoryId));
		model.addAttribute("list", boardMapper.getAllLists(boardId, categoryId));
		

		return "board-list";
	}

	@RequestMapping("/second-list")
	public String secondHandBoards(Model model) {
		System.out.println("SpringBoot-Study1 home");
		model.addAttribute("list", boardMapper.getCategoryList());
		return "second-list";
	}
	@RequestMapping("/community-list")
	public String CommunityBoards(Model model) {
		model.addAttribute("list", boardMapper.getCategoryList());
		return "community-list";
	}

	@RequestMapping("/{postId}")
	public String getPostDetail(Model model, @PathVariable int postId) {
		boardMapper.hitsUpdate(postId);
		model.addAttribute("list", boardMapper.getpostDetail(postId));
		model.addAttribute("comment",commentBoardMapper.findByComment(postId));
		return "board-detail";
	}

	@RequestMapping("/delete")
	public String deletePost(Model model, int postId) {
		boardMapper.deletePost(postId);

		return "redirect:/board/list";
	}

}
