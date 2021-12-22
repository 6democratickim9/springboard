package org.kosta.myproject.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.kosta.myproject.model.mapper.BoardMapper;
import org.kosta.myproject.model.mapper.CommentBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/list/{boardId}/{categoryId}")
	public String getAllLists(Model model, @PathVariable("boardId") int boardId,
			@PathVariable("categoryId") int categoryId) {

//		Page<BoardDTO> list = null;
//		
//		if (searchKeyword == null) {
//			list = boardMapper.boardList(pageable);
//		} else {
//			list = boardMapper.boardSearchList(searchKeyword, pageable);
//		}
//		int nowPage = list.getPageable().getPageNumber() + 1;
//		int startPage = Math.max(nowPage - 4, 1);
//		int endPage = Math.min(nowPage + 5, list.getTotalPages());
//		
//		model.addAttribute("list", list);
//		model.addAttribute("nowPage", nowPage);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
		model.addAttribute("board", boardMapper.getBoardName(boardId));
		model.addAttribute("category", boardMapper.getCatName(categoryId));
		model.addAttribute("list", boardMapper.getAllLists(boardId, categoryId));

		return "board-list";
	}

//	@RequestMapping("/second-list")
//	public String secondHandBoards(Model model) {
//		System.out.println("SpringBoot-Study1 home");
//		model.addAttribute("list", boardMapper.getCategoryList());
//		return "second-list";
//	}
//	@RequestMapping("/community-list")
//	public String CommunityBoards(Model model) {
//		model.addAttribute("list", boardMapper.getCategoryList());
//		return "community-list";
//	}

	@GetMapping(value = "/{postId}")
	public String getPostDetail(Model model, @PathVariable int postId) {
		boardMapper.hitsUpdate(postId);
		model.addAttribute("list", boardMapper.getpostDetail(postId));
		model.addAttribute("comment", commentBoardMapper.findByComment(postId));
		return "board-detail";
	}

	@RequestMapping("/delete/{postId}/{boardId}/{categoryId}")
	public String deletePost(Model model, HttpServletRequest request, @PathVariable("postId") int postId,
			@PathVariable("boardId") int boardId, @PathVariable("categoryId") int categoryId) {
		boardMapper.deletePost(postId);
		model.addAttribute("board", boardMapper.getBoardName(boardId));
		model.addAttribute("category", boardMapper.getCatName(categoryId));
		model.addAttribute("list", boardMapper.getAllLists(boardId, categoryId));

		return "redirect:/board/list/{boardId}/{categoryId}";
	}

}
