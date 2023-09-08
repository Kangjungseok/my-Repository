package com.fullstack2.guestbook.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fullstack2.guestbook.dto.GuestBookDTO;
import com.fullstack2.guestbook.dto.PageRequestDTO;
import com.fullstack2.guestbook.entity.GuestBook;
import com.fullstack2.guestbook.service.GuestBookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class GuestBookController {

	
	//서비스 객체를 선언 및 어노테이션으로 주입시키기/
	private final GuestBookService guestBookService;
	
	// "/" 로 요청시 list로 리다이렉트 시키기
	@GetMapping("/")
	public String index() {
		return "redirect:/guestbook/list";
	}
	
	
	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		//viewer 에게 요청된 페이지의 목록을 담은 리스트를 파라미터로 넘깁니다
		model.addAttribute("result", guestBookService.getList(pageRequestDTO));
		
	}
	
	
	@GetMapping("/register")//get으로 등록 요청이 오면 Viewer만 리턴시킵니다.
	public void register() {
		System.err.println("신규 방명록 폼 요청이 옴 ");
	}
	
	@PostMapping("/register")//사용자가 방명록 작성 후 submit 시 action 요청 처리합니다
	public String registerPost(GuestBookDTO guestBookDTO, RedirectAttributes attributes) {
		Long gno = guestBookService.register(guestBookDTO);
		
		System.err.println("신규 방명록이 등록됨...등록번호 : " + gno);
		
		attributes.addFlashAttribute("msg", gno);
		return "redirect:/guestbook/list";
	}
		
	//방명록의 상세 내용을 처리하는 메서드 
	@GetMapping({"/read","/modify"})
	//파라미터 값으로 DTO의 값 전체가 오는게 아니고, 글번호 하나만 오게 됩니다.
	//이 때 이 값을 처리할 모델에 연결을 해야 하는데, 사용하는 @이 ModelAttribute("dtoName") 입니다.
	//이 @을 선언 후 반드시 DTO의 이름값을 갈도록 매핑 해줘야 합니다.
	public void read(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {
		GuestBookDTO guestBookDTO = guestBookService.read(gno);
		model.addAttribute("dto", guestBookDTO);
	}
	
	
	@PostMapping("/modify")
	public String modify(GuestBookDTO guestBookDTO, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, 
			RedirectAttributes redirectAttributes) {
		
		guestBookService.modify(guestBookDTO);
		
		redirectAttributes.addAttribute("page", requestDTO.getPage());
		redirectAttributes.addAttribute("gno", guestBookDTO.getGno());
		
		return "redirect:/guestbook/read";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
