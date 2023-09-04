package com.fullstack2.ph1.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fullstack2.ph1.dto.SampleDTO;

import lombok.extern.log4j.Log4j2;

/*
 * @Controller 를 이용하면 부트에서 컨트롤러로 인식되어집니다.
 * @RequestMapping 는 요청에 대한 컨텍스트 패스를 설정합니다.(ex> "/test" 는 
 * localhost:port/test 라는 요청이 오면 이 컨트롤러가 응답한다 라는 의미입니다.)
 * 값을 주지 않으면 기본적으로 root path가 설정됩니다.
 * Log4j2 : 여러분이 현업에 가면 가장 많이 보는 로거입니다.
 * 이 로거는 프로그래밍 시 서버로그, 쿼리로그 등을 콘솔에 모두 출력하는 라이브러리로
 * 가장 많이 쓰입니다. 부트는 기본적으로 이 로거를 사용하므로 의존성 추가는 하지 않고
 * 컨트롤러 상단에 @Log4j2 선언만 하면 됩니다. 보안 이슈로 인해, log4j는 더 이상 사용 안 합니다.
 */

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

	/*
	 * 요청메서드에 따른 응답 메서드 정의
	 * 여기서 기본적으로 요청 처리와, 응답을 메서드로 정의하는데,
	 * 이 때 부트는 컨트롤러의 requestmapping에서 사용한 패스명과
	 * 메서드 이름과 같은 Viewer 를 기본적으로 mapping 시킵니다.
	 * 지금 이 메서드의 경우 viewer의 내부 path 정보는 /sample/ex1.html으로 자동
	 * 만약 viewer 이름을 다르게 호출하고 싶을 때는 메서드 리턴을 String 으로 주고,
	 * viewer 경로를 주면 변경됩니다. (나중에 배웁니다.)
	 */
	@GetMapping("/ex1")//ex1 이라는 path 로 get 요청이 오면 응답하도록 선언
	public void ex1() {
		//로거 출력..
		log.info("ex1 메서드가 호출되었습니다");
	}
	
	@GetMapping({"/ex2","/exLink"}) //배열방식으로 요청패스를 , 기준으로 나열할 수 있음.
	public void ex2(Model model) {
		List<SampleDTO> list = IntStream.rangeClosed(1, 20)
								.asLongStream()
								.mapToObj(i -> {
									SampleDTO dto = SampleDTO.builder()
															.sno(i)
															.first("first" + i)
															.last("last" + i)
															.regTime(LocalDateTime.now())
															.build();
									return dto;
								}).collect(Collectors.toList());
		
		//Model 객체는 Business 로직을 처리하는 객체라고 했듯이, 처리된 결과를
		//Viewer에서 사용하게 됩니다.
		//이 때 Model 객체를 특정 영역속성을 이용해서 뷰어에게 넘겨주는데,
		//이 때 사용하는 메서드가 addAttribute(key,value) 입니다.
		//이렇게하면 Viewer 에서 key를 찾아서 Value를 보여주는 역할을 합니다.
		model.addAttribute("list", list);
	}
	
	//이번엔 viewer 이름을 특정 이름으로 매핑하는 예제와
	//Viewer 에서 inline 으로 데이터를 스크립트로 처리하는 방법 및
	//redirect 하는 방법까지 볼게요.
	
	//뷰어 이름을 다르게 주고 싶으면 메서드를 String으로 리턴하도록 정의하고
	//호출될 뷰어의 패스 경로를 주면 됩니다.(단 templates 는 미포함입니다.)
	@GetMapping("/ex5")
	public String otherV() {
		
		return "/viewers/ex3";
	}
	//리다이렉트 시 파람을 보낼 때는 메서드에 아래의 인스턴스를 주입해줘야 합니다.
	@GetMapping("exThinline")
	public String exThinline(RedirectAttributes redirectAttributes) {
		//SampleDTO 하나 생성해서 위 /ex 로 redirect 시킵니다.
		//이 때 파라미터로 DTO를 같이 보낼 거고, ex5 로 온 요청은 otherV() 가 응답하는데
		//이 때 여기서 보내는 파라미터를 받아서 ex3.html 이 inline 방식으로 데이터를 출력하도록 합니다.
		
		SampleDTO dto = SampleDTO.builder()
								.sno(1L)
								.first("강")
								.last("정석")
								.build();
								
		//redirect 시 파라미터 보내는 코드 아래..
		redirectAttributes.addFlashAttribute("result", "success");
		redirectAttributes.addFlashAttribute("dto", dto);
		
		return "redirect:/sample/ex5";
		
	}
	
	//타임리프의 레이아웃 예제 요청메서드 정의
	@GetMapping("/exLayout1")
	public void exLayout1() {
		
	}
	
	
	//layout 이 적용된 list 페이지를 요청하는 요청 메서드 정의
	@GetMapping({"/","/list"})
	public String list() {
		
		log.debug("list 페이지 요청 완료됨");
		return "/guestbook/list";
	}
	
	
	
	
	
	
	
	
	
	
	
}



























