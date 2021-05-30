package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;
/*
 JDBC를 이용한 프로그래밍 방법
 pom.xml : dependency mysql 작성 - Maven - Update Project - JDBC 적용 
 1단계 : import java.sql.*;
 2단계 : 드라이버를 로드한다.
 		Class.forName("com.mysql.jdbc.Driver");
 3단계 : Connection 객체를 생성한다. // 연결 
 		String dburl = "jdbc:mysql://localhost/dbName";
 		Connection conn = DriverManager.getConnection(dburl, ID, PWD); 
 4단계 : Statement 객체를 생성 및 질의 수행 // 명령 
 		Statement stmt = con.createStatement();						// 생성
 		ResultSet rs = stmt.executeQuery("select no from user");	// 질의수행
 		참고 
 		 stmt.execute("query");			// any SQL 
 		 stmt.executeQuery("query");	// select 
 		 stmt.executeUpdate("query");	// insert, update, delete 
 5단계 : SQL문에 결과물이 있다면 ResultSet 객체를 생성한다. // 결과 
 		ResultSet rs = stmt.executeQuery("select no from user");
 		whild(rs.next())		// 여러개의 레코드가 존재할 수도 있다. 한꺼번이 아니라 하나씩 가져온다. 
 			System.out.println("rs.getInt("no");
 6단계 : 모든 객체를 닫는다. close(); 
 		rs.close();
 		stmt.close();
 		conn.close();
 
 JDBC 클래스의 생성관계
 DriverManager를 이용해서 Connection 인스턴스를 얻는다.
 Connection을 통해서 Statement를 얻는다.
 Statement를 이용해 ResultSet을 얻는다.

 닫을 때는 반대로 ResultSet - Statement - Connection 순으로 닫는다.

 OracleDB일 경우
 String url = "jdbc:orcle:thin:@117.16.46.111:1521:xe";
 String user = "ID";
 String password = "PWD";
 Connection conn = null;
 Class.forName("oracle.jdbc.driver.OracleDriver");
 conn = DriverManager.getConnection(url, user, password);
 return conn;
*/

public class RoleDao {
	
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT description, role_id FROM role ORDER BY role_id DESC";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			try (ResultSet rs = ps.executeQuery()) {
				
				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					list.add(role); // list에 반복할 때마다 Role 인스턴스를 생성하여 list에 추가한다. 
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		// try-with resource 라는 문장을 이용하여 close 따로 작성 안한다. 알아서 close 해준다.  
		
		return list;
	}
	
	public int deleteRole(Integer roleId) {
		int deleteCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "DELETE FROM role WHERE role_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, roleId);
			
			deleteCount = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {
				}
			} // if
			
			if (conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {
				}
			} // if
		} // finally
		
		return deleteCount;
	}
	
	public int updateRole(Role role) {
		int updateCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "UPDATE role SET description = ? WHERE role_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());
			
			updateCount = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {
				}
			} // if
		
			if (conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {
				}
			} // if
		} // finally
		
		return updateCount;
	}
	
	// 몇건 입력 되었습니다. 
	public int addRole(Role role) {
		int insertCount = 0;
	
		Connection conn = null;
		PreparedStatement ps = null;
		// insert이기 때문에 결과값 ResultSet은 없다 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "INSERT INTO role (role_id, description) VALUES (?, ?)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			
			// insert에서는 executeUpdate()를 사용 
			insertCount = ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {
				}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {
				}
			} // if
 		} // finally
		return insertCount;
	}
	
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
			// select에서는 executeQuery()를 사용 
			rs = ps.executeQuery();
			
			if (rs.next()) {
//				String description = rs.getString("description");
				String description = rs.getString(1);
//				int id = rs.getInt("role_id");
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
