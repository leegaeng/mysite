package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.mysite.vo.Board;

public class BoardDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "webdb", "webdb");

		return conn;
	}

	public void insertBoard(Board b) throws ClassNotFoundException,
			SQLException {

		Connection conn = getConnection();

		String sql = "insert into board values(board_no_seq.nextval, ?, ?, ?, ?, 0, sysdate)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, b.getTitle());
		ps.setString(2, b.getContent());
		ps.setLong(3, b.getMember_no());
		ps.setString(4, b.getMember_name());

		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("저장성공");
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}

	}

	public void deleteBoard(long no) throws ClassNotFoundException,
			SQLException {
		Connection conn = getConnection();

		String sql = "delete from board where no = ? ";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, no);

		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("삭제성공");
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

	public void updateCount(Board b) throws ClassNotFoundException,
			SQLException {

		Connection conn = getConnection();
		String sql = "update board set view_cnt = view_cnt +1 where no = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, b.getNo());

		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("조회수 증가");
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}

	}

	public void updateBoard(Board b) throws ClassNotFoundException,
			SQLException {

		Connection conn = getConnection();
		String sql = "update board set title= ?, content= ?, reg_date=sysdate where no = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, b.getTitle());
		ps.setString(2, b.getContent());
		ps.setLong(3, b.getNo());

		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("게시판 수정");
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}

	}

	public List<Board> fetchList() throws ClassNotFoundException, SQLException {
		List<Board> list = new ArrayList<Board>();

		Connection conn = getConnection();

		String sql = "select * from board";

		Statement s = conn.prepareStatement(sql);

		ResultSet rs = s.executeQuery(sql);

		while (rs.next()) {
			Board b = new Board(rs.getLong(1), rs.getString(2),
					rs.getString(3), rs.getLong(4), rs.getString(5),
					rs.getLong(6), rs.getString(7));
			list.add(b);
		}

		if (rs != null) {
			rs.close();
		}

		if (s != null) {
			s.close();
		}

		if (conn != null) {
			conn.close();
		}
		return list;
	}

	public Board fetchBoard(Long i) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();
		String sql = "select * from board where no = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, i);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Board b = new Board(rs.getLong(1), rs.getString(2),
					rs.getString(3), rs.getLong(4), rs.getString(5),
					rs.getLong(6), rs.getString(7));
			return b;
		}

		if (rs != null) {
			rs.close();
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}
		return null;
	}

	public List<Board> fetchBoard(String searchfield)
			throws ClassNotFoundException, SQLException {

		List<Board> list = new ArrayList<Board>();

		Connection conn = getConnection();
		String sql = "select * from board where title like ? or member_name like ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%"+searchfield+"%");
		ps.setString(2, "%"+searchfield+"%");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Board b = new Board(rs.getLong(1), rs.getString(2),
					rs.getString(3), rs.getLong(4), rs.getString(5),
					rs.getLong(6), rs.getString(7));
			list.add(b);
		}

		if (rs != null) {
			rs.close();
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}

		return list;
	}

}
