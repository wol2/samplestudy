package com.test.spring.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/* #11. DAO 설정하기*/
@Repository
public class MybatisTestDAO {

	// 의존객체 주입(DI : Dependency Injection)
	@Autowired
	private SqlSessionTemplate sqlsession;

	
	public void mybatisTest1(String name) {
		
		sqlsession.insert("testdb.mybatisTest1", name);
		
	}


	public void formtest1End(MybatisTestVO vo) {
		
		sqlsession.insert("testdb.formtest1End", vo);
		
	}


	public void formtest2End(MybatisTestVO vo) {
		
		sqlsession.insert("testdb.formtest1End", vo);
		
	}


	public void formtest3End(HashMap<String, String> map) {
		
		sqlsession.insert("testdb.formtest3End", map);
		
	}


	public String selectTest1End(String no) {
		
		String name = (String)sqlsession.selectOne("testdb.selectTest1End", no);
		
		return name;
		
	}


	public MybatisTestVO selectTest2End(String no) {
		
		MybatisTestVO vo = (MybatisTestVO)sqlsession.selectOne("testdb.selectTest2End", no);
		
		return vo;
		
	}


	public List<MybatisTestVO> selectTest3End() {
		
		List<MybatisTestVO> list = sqlsession.selectList("testdb.selectTest3End"); 
		
		return list;
	}


	public List<HashMap<String, String>> selectTest4End() {
		
		List<HashMap<String, String>> list = sqlsession.selectList("testdb.selectTest4End");
		
		return list;
		
	}


	public List<MybatisTestVO> selectTest5End(HashMap<String, String> map) {
		
		List<MybatisTestVO> list = sqlsession.selectList("testdb.selectTest5End", map); 
		
		return list;
		
	}


	public List<MybatisTestVO> selectTest6End(HashMap<String, String> map) {
		
		List<MybatisTestVO> list = sqlsession.selectList("testdb.selectTest6End", map); 
		
		return list;
	}


	public void formtestquizEnd(HashMap<String, String> map) {
		
		sqlsession.insert("testdb.formtestquizEnd", map);
		
	}


	public List<HashMap<String, String>> selectQuizEnd(HashMap<String, String> map) {
		
		List<HashMap<String, String>> list = sqlsession.selectList("testdb.selectQuizEnd", map); 
		
		return list;
		
	}


	public List<HashMap<String, Object>> searchforeachEnd(HashMap<String, Object> map) {
		
		List<HashMap<String, Object>> list = sqlsession.selectList("testdb.searchforeachEnd", map);
		
		return list;
	}
	
	
	
	
	
	
}
