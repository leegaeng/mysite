package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sds.icto.mysite.vo.Member;

public class MemberDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "webdb", "webdb");

		return conn;
	}

	public void insert(Member m) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		String sql = "insert into Member values(member_no_seq.NEXTVAL , ?, ?, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, m.getName());
		ps.setString(2, m.getEmail());
		ps.setString(3, m.getPassword());
		ps.setString(4, m.getGender());

		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("저장 성공");
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

	public void update(Member m) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		String sql = "update member set name= ?, email= ?, password= ?, gender=? where no= ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, m.getName());
		ps.setString(2, m.getEmail());
		ps.setString(3, m.getPassword());
		ps.setString(4, m.getGender());
		ps.setLong(5, m.getNo());

		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("수정 성공");
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

	public Member getMember(String email, String password) throws SQLException,
			ClassNotFoundException {
		Connection conn = getConnection();
		Member m = null;

		String sql = "Select * from member where email = ? and password= ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			m = new Member(rs.getLong(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5));

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

		return m;
	}
}
