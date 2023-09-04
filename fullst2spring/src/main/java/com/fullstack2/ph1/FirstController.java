package com.fullstack2.ph1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 처음으로 만드는 컨트롤러입니다.
 * 컨트롤러는 web 의 모든 요청을 처리하는 애입니다,
 * 그러기 위해서는 요청이 어떤 방식으로 왔는지(메서드)를 구분해야 합니다.
 * 그리고, 처리된 결과 데이터를 어떤 View 를 통해 전달할지, 어떻게 전달할지(Rest or Normal)
 * 를 선언하고, 선언 형식에 맞춰서 viewer 를 통해(Rest 는 그렇지 않음, Data 만 전달하는 형식이 Rest임)
 * 응답을 합니다.
 */
//컨트롤러 선언은 반드시 클래스 위에 위치해야 함.
@RestController
public class FirstController {

	//특정 요청(메서드)이 오면 어떻게 응답할지를 메서드를 통해 정의합니다.
	//이 때도 요청 URL Patter 을 해당 메서드에 mapping 할지를 @ 을 이용해 선언합니다.
	@GetMapping("/welcome")
	public String[] sayHello() {
		return new String[] {"Hello","SpringBoot","World!"};
	}
}
