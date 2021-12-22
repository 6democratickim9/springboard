package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.domain.BoardDTO;
import org.kosta.myproject.model.domain.BoardTypeDTO;
import org.kosta.myproject.model.domain.CategoryDTO;
import org.kosta.myproject.model.domain.MemberDTO;

@Mapper
public interface BoardMapper {
	List<BoardDTO> getBoardList();

	int hitsUpdate(int postId);
	
	BoardTypeDTO getSecId();
	
	BoardTypeDTO getComId();
	
	MemberDTO findTestById(int memberId);

	List<BoardDTO> getAllLists(int boardId, int categoryId);

	BoardDTO getpostDetail(int postId);

	void deletePost(int postId);

	List<CategoryDTO> getCategoryList();

	List<BoardTypeDTO> getBoardType();
	
	BoardTypeDTO getBoardName(int boardId);
	
	CategoryDTO getCatName(int categoryId);

	int getCategoryCount(int boardId,int categoryId);
}
