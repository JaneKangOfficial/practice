package kr.or.connect.daoexam.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;
import static kr.or.connect.daoexam.dao.RoleDaoSqls.*;

@Repository
public class RoleDao {

	// NamedParameterJdbcTemplate : 이름을 이용해서 바인딩하거나 결과 값을 가져올 때 사용 
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	
	// DBConfig.java 의 @Bean인 dataSource를 받아온다  
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	// static import 사용으로 클래스 이름 선언없이 SELECT_ALL 바로 사용 
	public List<Role> selectAll() {
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}

}
