package com.test.spring;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.spring.model.MybatisTestVO;
import com.test.spring.service.MybatisTestService;

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
public class MybatisTestController {

	// 의존객체 주입(DI : Dependency Injection)
	@Autowired
	private MybatisTestService service;
	
	@RequestMapping(value="/webtest.action", method={RequestMethod.GET})
	public ModelAndView webtest() {
		
		ModelAndView mav = new ModelAndView("webtest");
		System.out.println("webtest 입니다.");
		
		return mav;
	}	
	
	@RequestMapping(value="/mybatis/test1.action", method={RequestMethod.GET})
	public String mybatisTest1() {
		
		String name = "유원제";
		
		service.mybatisTest1(name);
		
		return "mybatisTest1";
	}
	
	
	@RequestMapping(value="/mybatis/formtest1.action", method={RequestMethod.GET})
	public String formtest1() {
		
		return "formtest1"; // 글쓰기 폼페이지 작성
	}
	
	
	@RequestMapping(value="/mybatis/formtest1End.action", method={RequestMethod.POST})
	public String formtest1End(HttpServletRequest req) {
		
		// 1. 폼에서 넘어온 값을 받기.
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");
		
		// 2. VO 에 넣어준다.
		MybatisTestVO vo = new MybatisTestVO();
		
		vo.setName(name);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setAddr(addr);
		
		// 3. Service 단으로 생성된 VO 보내기
		service.formtest1End(vo);
				
		return "formtest1End";
		
	}
	

	@RequestMapping(value="/mybatis/formtest2.action", method={RequestMethod.GET})
	public String formtest2() {
		
		return "formtest2"; // 글쓰기 폼페이지 작성
	}
	
	
	@RequestMapping(value="/mybatis/formtest2End.action", method={RequestMethod.POST})
	public String formtest2End(MybatisTestVO vo) {
		
		// 1. Service 단으로 생성된 VO 보내기
		service.formtest2End(vo);
				
		return "formtest2End";
		
	}	
	
	
	@RequestMapping(value="/mybatis/formtest3.action", method={RequestMethod.GET})
	public String formtest3() {
		
		return "formtest3"; // 글쓰기 폼페이지 작성
	}
	
	
	@RequestMapping(value="/mybatis/formtest3End.action", method={RequestMethod.POST})
	public String formtest3End(HttpServletRequest req) {
		
		// 1. 폼에서 넘어온 값을 받기.
		String irum = req.getParameter("irum");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		
		// 2. VO 클래스를 생성하지 않고, 그냥 HashMap 을 사용하는 경우 
		//    SQL구문이 JOIN 해서 나오는 SELECT 문일 경우
		//    JOIN 되어지는 테이블의 갯수가 많다라면
		//    VO 클래스를 만들지 않고 그냥 HashMap을 사용하는 것이 편하다.
		HashMap<String, String> map = new HashMap<String, String>(); 
		
		map.put("irum", irum);
		map.put("mobile", mobile);
		map.put("address", address);
		
		
		// 3. Service 단으로 생성된 HashMap 보내기
		service.formtest3End(map);
				
		return "formtest3End";
		
	}
	
	
	////////////////////////////////////////////
	////////////////////////////////////////////
	
	@RequestMapping(value="/mybatis/selectTest1.action", method={RequestMethod.GET})
	public String selectTest1() {
		
		return "search1"; // 회원조회 폼페이지 작성
	}
	
	
	@RequestMapping(value="/mybatis/selectTest1End.action", method={RequestMethod.GET}) 
	public String selectTest1End(HttpServletRequest req) {
		
		// 1. 폼에서 넘어온 값을 받기.
		String no = req.getParameter("no");
		
		// 2. Service 단으로 생성된 HashMap 보내기
		String name = service.selectTest1End(no);
		
		req.setAttribute("name", name);
				
		return "search1End";
		
	}
	
	
	@RequestMapping(value="/mybatis/selectTest2.action", method={RequestMethod.GET})
	public String selectTest2() {
		
		return "search2"; // 회원조회 폼페이지 작성
	}
	
	
	@RequestMapping(value="/mybatis/selectTest2End.action", method={RequestMethod.GET}) 
	public String selectTest2End(HttpServletRequest req) {
		
		// 1. 폼에서 넘어온 값을 받기.
		String no = req.getParameter("no");
		
		// 2. Service 단으로 보내기
		MybatisTestVO vo = service.selectTest2End(no);
		
		req.setAttribute("vo", vo);
				
		return "search2End";
		
	}
	

	@RequestMapping(value="/mybatis/selectTest3.action", method={RequestMethod.GET})
	public String selectTest3() {
		
		return "search3"; // 여러명의 회원을 조회 폼페이지 작성
	}
	
	
	@RequestMapping(value="/mybatis/selectTest3End.action", method={RequestMethod.GET}) 
	public String selectTest3End(HttpServletRequest req) {
		
		// 1. Service 단으로 보내기
		List<MybatisTestVO> list = service.selectTest3End();
		
		req.setAttribute("list", list);
				
		return "search3End";
		
	}	
	
	
	@RequestMapping(value="/mybatis/selectTest4.action", method={RequestMethod.GET})
	public String selectTest4() {
		
		return "search4"; // 여러명의 회원을 조회 폼페이지 작성
	}
	
	
	@RequestMapping(value="/mybatis/selectTest4End.action", method={RequestMethod.GET}) 
	public String selectTest4End(HttpServletRequest req) {
		
		// 1. Service 단으로 보내기
		List<HashMap<String, String>> list = service.selectTest4End();
		
		req.setAttribute("list", list);
				
		return "search4End";
		
	}
	
	
	@RequestMapping(value="/mybatis/selectTest5.action", method={RequestMethod.GET})
	public String selectTest5() {
		
		return "search5"; // 여러명의 회원을 조회 폼페이지 작성
		                  // 검색어 포함
	}
	
	
	@RequestMapping(value="/mybatis/selectTest5End.action", method={RequestMethod.GET}) 
	public String selectTest5End(HttpServletRequest req) {
		
		// 1. form 에서 넘어온 값을 받아오기
		String colName = req.getParameter("colName");
		String searchWord = req.getParameter("searchWord");
		
		if(searchWord != null) {
			searchWord = searchWord.trim();
		}
		
		// 2. 2개 이상의 파라미터를 Service 단으로 보내려면
		//    2개 이상의 파라미터를 HashMap 에 담아서 보낸다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("COLNAME", colName);
		map.put("SEARCHWORD", searchWord);
		
		
		// 3. Service 단으로 보내기
		List<MybatisTestVO> list = service.selectTest5End(map);
		
		req.setAttribute("list", list);
		
		if(colName != null && searchWord != null){
			req.setAttribute("colName", colName);
			req.setAttribute("searchWord", searchWord);
		}
				
		return "search5End";
		
	}	
	
	
	@RequestMapping(value="/mybatis/selectTest6.action", method={RequestMethod.GET})
	public String selectTest6() {
		
		return "search6"; // 여러명의 회원을 조회 폼페이지 작성
		                  // 검색어 및 날짜구간 포함
	}
	
	
	@RequestMapping(value="/mybatis/selectTest6End.action", method={RequestMethod.GET}) 
	public String selectTest6End(HttpServletRequest req) {
		
		// 1. form 에서 넘어온 값을 받아오기
		String colName = req.getParameter("colName");
		String searchWord = req.getParameter("searchWord");
		String dayDifference = req.getParameter("dayDifference");
		
		if(searchWord != null) {
			searchWord = searchWord.trim();
		}
		
		// 2. 2개 이상의 파라미터를 Service 단으로 보내려면
		//    2개 이상의 파라미터를 HashMap 에 담아서 보낸다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("COLNAME", colName);
		map.put("SEARCHWORD", searchWord);
		map.put("DAYDIFFERENCE", dayDifference);
		
		
		// 3. Service 단으로 보내기
		List<MybatisTestVO> list = service.selectTest6End(map);
		
		req.setAttribute("list", list);
		
		if(colName != null && searchWord != null){
			req.setAttribute("colName", colName);
			req.setAttribute("searchWord", searchWord);
		}
		
		if(dayDifference != null){
			req.setAttribute("dayDifference", dayDifference);
		}
				
		return "search6End";
		
	}	
	
	// ****** 퀴즈 ******* //
	@RequestMapping(value="/mybatis/formtestquiz.action", method={RequestMethod.GET})
	public String formtestquiz() {
		
		return "formtestquiz"; // 글쓰기 폼페이지 작성
	}
	
	
	@RequestMapping(value="/mybatis/formtestquizEnd.action", method={RequestMethod.POST})
	public String formtestquizEnd(HttpServletRequest req) {
		
		// 1. 폼에서 넘어온 값을 받기.
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");
		String schoolgrade = req.getParameter("schoolgrade");
		
		// 2. VO 클래스를 생성하지 않고, 그냥 HashMap 을 사용하는 경우 
		//    SQL구문이 JOIN 해서 나오는 SELECT 문일 경우
		//    JOIN 되어지는 테이블의 갯수가 많다라면
		//    VO 클래스를 만들지 않고 그냥 HashMap을 사용하는 것이 편하다.
		HashMap<String, String> map = new HashMap<String, String>(); 
		
		map.put("NAME", name);
		map.put("EMAIL", email);
		map.put("TEL", tel);
		map.put("ADDR", addr);
		map.put("SCHOOLGRADE", schoolgrade);
				
		// 3. Service 단으로 생성된 HashMap 보내기
		service.formtestquizEnd(map);
				
		return "formtestquizEnd";
		
	}
	
	
	@RequestMapping(value="/mybatis/selectQuizEnd.action", method={RequestMethod.GET}) 
	public String selectQuizEnd(HttpServletRequest req) {
		
		// 1. form 에서 넘어온 값을 받아오기
		String colName = req.getParameter("colName");
		String searchWord = req.getParameter("searchWord");
		String dayDifference = req.getParameter("dayDifference");
		
		if(searchWord != null) {
			searchWord = searchWord.trim();
		}
		
		// 2. 2개 이상의 파라미터를 Service 단으로 보내려면
		//    2개 이상의 파라미터를 HashMap 에 담아서 보낸다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("COLNAME", colName);
		map.put("SEARCHWORD", searchWord);
		map.put("DAYDIFFERENCE", dayDifference);
		
		
		// 3. Service 단으로 보내기
		List<HashMap<String, String>> list = service.selectQuizEnd(map);
		
		req.setAttribute("list", list);
		
		if(colName != null && searchWord != null){
			req.setAttribute("colName", colName);
			req.setAttribute("searchWord", searchWord);
		}
		
		if(dayDifference != null){
			req.setAttribute("dayDifference", dayDifference);
		}
				
		return "searchQuizEnd";
		
	}	
	
	
	// ==== XML 파일에 foreach 사용하는 예제 ==== //
	@RequestMapping(value="/mybatis/searchforeach.action", method={RequestMethod.GET})
	public String searchforeach() {
		
		return "searchforeach"; 
	}
	
	
	@RequestMapping(value="/mybatis/searchforeachEnd.action", method={RequestMethod.GET}) 
	public String searchforeachEnd(HttpServletRequest req) {
		
		// 리턴타입을 VO 를 사용하지 않고 HashMap을 사용하겠다.
		// -- employees 테이블과 departments 테이블을 left join 한
		//    결과를 view 로 만들어서 출력하겠다.
		
		// 1. form 에서 넘어온 값을 받아오기
//		    String[] department_id_Arr = {"10","20","30","40","50"};
		
			String[] department_id_Arr = req.getParameterValues("department_id");
			String gender = req.getParameter("gender");
			String ageline = req.getParameter("ageline");
		
		// 2. 2개 이상의 파라미터를 Service 단으로 보내려면
		//    2개 이상의 파라미터를 HashMap 에 담아서 보낸다.
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("department_id_Arr", department_id_Arr);
			map.put("gender", gender);
			map.put("ageline", ageline);
		
		// 3. Service 단으로 보내기
			List<HashMap<String, Object>> empDeptList = service.searchforeachEnd(map); 
			req.setAttribute("empDeptList", empDeptList);
			
		// 검색에 관련된 것을 viewPage 인 searchforeachEnd.jsp 에 넘겨주어야 한다.
			if(department_id_Arr != null) {
				req.setAttribute("department_id_Arr", department_id_Arr);
			}
			
			if(!"전체".equals(gender)) {
				req.setAttribute("gender", gender);
			}
			
			if(!"-10".equals(ageline)) {
				req.setAttribute("ageline", ageline);
			}
				
		return "searchforeachEnd";
		
	}
	
	
	
	
	
}
