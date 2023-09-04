package com.fullstack2.guestbook;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fullstack2.guestbook.dto.GuestBookDTO;
import com.fullstack2.guestbook.dto.PageRequestDTO;
import com.fullstack2.guestbook.dto.PageResultDTO;
import com.fullstack2.guestbook.entity.GuestBook;
import com.fullstack2.guestbook.service.GuestBookService;

@SpringBootTest
public class GuestBookServiceTests {
	
	@Autowired
	private GuestBookService guestBookService;
	
	
	@Test//방명록 list에서 요청받은 검색을 처리할 메서드를 테스트합니다.
	public void searchTest() {
		
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
														.page(1)
														.size(10)
														.type("c")
														.keyword("선물")
														.build();
		PageResultDTO<GuestBookDTO, GuestBook> resultDTO = 
				guestBookService.getList(pageRequestDTO);
		
		System.err.println("이전 : " + resultDTO.isPrev());
		System.err.println("다음 : " + resultDTO.isNext());
		System.err.println("총페이지수 : " + resultDTO.getTotalPage());
		
		for(GuestBookDTO guestBookDTO : resultDTO.getDtoList()) {
			System.err.println(guestBookDTO);
		}
		
	}
	
	
	

	
	
	
	//페이징 처리까지 완료된 Service 의 페이징 결과 확인하기
	//@Test
	public void pagingListTest() {
		PageRequestDTO dto = PageRequestDTO.builder().page(1).size(10).build();
		PageResultDTO<GuestBookDTO, GuestBook> pageResultDTO = 
				guestBookService.getList(dto);
		
		System.out.println("이전 : " + pageResultDTO.isPrev());
		System.out.println("다음 : " + pageResultDTO.isNext());
		System.out.println("전체페이지 수 : " + pageResultDTO.getTotalPage());
		
		System.out.println("-----------------------------------------------------------------------------");
		
		for(GuestBookDTO gdto : pageResultDTO.getDtoList()) {
			System.out.println(gdto);
		}
		
		System.out.println("============================&&&&&&&&&&&&&&&&&&&&&&&&==========================");
		pageResultDTO.getPageList().forEach(System.out::println);
		System.out.println("============================ 고생 많았습니다 ^_^ ==============================");
		
		
	}
	
	
	
	
	
	//@Test//요청하는 페이지에 해당하는 글목록 get 기능 테스트하기
	public void getListPage() {
		//요청값을 세팅하는 페이지요청DTO 에 값 세팅할게요.
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
		
		//요청된 페이지의 글목록을 Entity --> DTO로 변환 후 결과를 가지고 있는 PageResultDTO 객체를
		//생성해서 list 를 얻어냅니다. 
		PageResultDTO<GuestBookDTO, GuestBook> pageResultDTO =
				guestBookService.getList(pageRequestDTO);
		
		for(GuestBookDTO dto : pageResultDTO.getDtoList()) {
			System.out.println(dto);
		}
		
	}
	
	
	
	
	
	//@Test
	public void registerTest() {
		
		GuestBookDTO guestBookDTO = GuestBookDTO.builder()
										.subject("이건 service를 통한 insert 제목")
										.content("오늘 비가 많이 오네요")
										.writer("노쌤")
										.build();
		
		System.out.println(guestBookService.register(guestBookDTO));
	}
	
	
}
