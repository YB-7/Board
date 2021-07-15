package co.jelly.board.service;

import java.util.List;

import co.jelly.board.vo.BoardVO;

public interface BoardService {

	public void showAll();

	public BoardVO inquiryPost(BoardVO vo);
	
	public int hitupdate(String id);

	public void writePost(BoardVO vo);

	public void deletePost(BoardVO vo);
}
