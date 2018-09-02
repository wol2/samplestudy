package com.test.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.spring.model.TestDAO;

/* #10. 서비스단 클래스 설정하기*/
@Service
public class TestService {
	
	// 의존객체 주입(DI : Dependency Injection)
	@Autowired
	private TestDAO dao;

}
