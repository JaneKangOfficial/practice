package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam5 {

	// UPDATE 
	public static void main(String[] args) {
		int roldId = 500;
		String description = "CEO";
		
		Role role = new Role(roldId, description);
		
		RoleDao dao = new RoleDao();
		int updateCount = dao.updateRole(role);
		
		System.out.println(updateCount);
	}
}
