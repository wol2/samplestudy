package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.test.spring.service.TestService;

/*
사용자 웹브라우저 요청  ==> DispatcherServlet ==> @Controller 클래스 <==>> Service단(핵심업무로직단, business logic단) <==>> Model단(DAO, DTO) <==>> myBatis <==>> DB(오라클)           
(http://...  *.action)                                  |
          ↑                                             |
          |                                             ↓
          |                                          View단(.jsp)
          ----------------------------------------------| 
                                                          
서비스 객체는 데이터베이스 작업만 전문으로 하는 객체가 아니라 
해당업무(예: 게시판)에서 필요로 하는 작업을 전부 총 관리하는 객체이다.
여기서 관리라는 것은 업무에 필요한 작업의 흐름만 기술하는 것으로(즉, 메소드 호출임)
실제 업무 프로그래밍은 Model 단에서 기술해둔다.(즉, Model 단에서 메소드를 작성한다.)
이 서비스 객체는 업무 로직단(비지니스 로직단)이라고 부르며, 
실제 코딩은 없고 @Controller 에서 요청받은 것을 Model 단으로 넘겨주는 역할을 한다. 
*/ 

/* #9. 컨트롤러 설정하기 */
@Controller
public class TestController {

	// 의존객체 주입(DI : Dependency Injection)
	@Autowired
	private TestService service;
	
	@RequestMapping(value="/main", method={RequestMethod.GET})
	public ModelAndView webtest() {
		ModelAndView mav = new ModelAndView("webtest");
		System.out.println("webtest 입니다.");
		
		return mav;
	}	
	
}
