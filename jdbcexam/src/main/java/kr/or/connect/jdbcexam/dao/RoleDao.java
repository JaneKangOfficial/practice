package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			System.out.println("conn 접속 성공");
			String sql = "SELECT description, role_id FROM role WHERE role_id = ?";
			ps = conn.prepareCall(sql);
			ps.setInt(1, roleId);
			rs = ps.executeQuery();
			
			if (rs.next()) {
//				rs.getString("description");
				String description = rs.getString(1);
//				rs.getInt("role_id");
				int id = rs.getInt(2);
				role = new Role(id, description);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return role;
	}
}
