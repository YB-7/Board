package co.jelly.board.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.jelly.board.dao.DAO;
import co.jelly.board.service.BoardService;
import co.jelly.board.vo.BoardVO;

public class BoardServiceImpl extends DAO implements BoardService {
	private PreparedStatement stm; // sql명령을 보내고 실행하기 위한 객체
	private ResultSet rs; // select 결과를 받을 수 있는 객체

	@Override
	public void showAll() {
		// TODO 글 전체목록 보여주기
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = new BoardVO();

		String sql = "select * from board";
		try {
			stm = cnn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				vo.setBoardId(rs.getString("boardid"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setSubject(rs.getString("subject"));
				vo.setEnterDate(rs.getDate("enterdate"));
				vo.setHit(rs.getInt("hit"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (BoardVO board : list) {
			vo.toString();
		}
	}

	@Override
	public BoardVO inquiryPost(BoardVO vo) {
		// TODO 글 조회
		BoardVO board = new BoardVO();
		int n = 0;
		String sql = "select subject from board where boardid = ?";

		try {
			stm = cnn.prepareStatement(sql);
			stm.setString(1, vo.getBoardId());
			rs = stm.executeQuery();
			if (rs.next()) {
				board.setSubject(rs.getString("subject"));
				n = hitupdate(vo.getBoardId());
			} else {
				System.out.println("해당하는 글이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public int hitupdate(String id) {
		// TODO 조회수 증가
		int n = 0;
		String sql = "update board set hit = hit + 1 where boardid = ?";
		try {
			stm = cnn.prepareStatement(sql);
			stm.setString(1, id);
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public void writePost(BoardVO vo) {
		// TODO Auto-generated method stub
		BoardVO board = new BoardVO();

	}

	@Override
	public void deletePost(BoardVO vo) {
		// TODO Auto-generated method stub

	}

}
