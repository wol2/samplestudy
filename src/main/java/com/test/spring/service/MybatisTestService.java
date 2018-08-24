package com.test.spring.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.model.MybatisTestDAO;
import com.test.spring.model.MybatisTestVO;

/* #10. 서비스단 클래스 설정하기*/
@Service
public class MybatisTestService {
	
	// 의존객체 주입(DI : Dependency Injection)
	@Autowired
	private MybatisTestDAO dao;

	
	public void mybatisTest1(String name) {
		
		dao.mybatisTest1(name);
		
	}


	public void formtest1End(MybatisTestVO vo) {
		
		dao.formtest1End(vo);
		
	}


	public void formtest2End(MybatisTestVO vo) {
		
		dao.formtest2End(vo);
		
	}


	public void formtest3End(HashMap<String, String> map) {
		
		dao.formtest3End(map);
		
	}


	public String selectTest1End(String no) {
		
		String name = dao.selectTest1End(no);
		
		return name;
		
	}


	public MybatisTestVO selectTest2End(String no) {
		
		MybatisTestVO vo = dao.selectTest2End(no);
		
		return vo;
		
	}


	public List<MybatisTestVO> selectTest3End() {
		
		List<MybatisTestVO> list = dao.selectTest3End();
		
		return list;
	}


	public List<HashMap<String, String>> selectTest4End() {
		
		List<HashMap<String, String>> list = dao.selectTest4End();
		
		return list;
		
	}


	public List<MybatisTestVO> selectTest5End(HashMap<String, String> map) {
		
		List<MybatisTestVO> list = dao.selectTest5End(map);
		
		return list;
		
	}


	public List<MybatisTestVO> selectTest6End(HashMap<String, String> map) {
		
		List<MybatisTestVO> list = dao.selectTest6End(map);
		
		return list;
	}


	public void formtestquizEnd(HashMap<String, String> map) {
		
		dao.formtestquizEnd(map);
		
	}


	public List<HashMap<String, String>> selectQuizEnd(HashMap<String, String> map) {
		
		List<HashMap<String, String>> list = dao.selectQuizEnd(map);
		
		return list;
	}


	public List<HashMap<String, Object>> searchforeachEnd(HashMap<String, Object> map) {
		
		List<HashMap<String, Object>> list = dao.searchforeachEnd(map);
		
		return list;
	}
	
	
	
	
	
	
	

}
