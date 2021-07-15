package co.jelly.board;

import co.jelly.board.serviceImpl.BoardServiceImpl;
import co.jelly.board.vo.BoardVO;

public class MainApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		BoardServiceImpl service = new BoardServiceImpl();
		service.showAll();
		BoardVO vo = new BoardVO();
		vo.setBoardId("1");
		vo = service.inquiryPost(vo);
		System.out.println(vo.getSubject());
	}
}
