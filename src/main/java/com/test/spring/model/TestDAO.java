package com.test.spring.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/* #11. DAO 설정하기*/
@Repository
public class TestDAO {

	// 의존객체 주입(DI : Dependency Injection)
	@Autowired
	private SqlSessionTemplate sqlsession;
	
}
