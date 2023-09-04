package com.fullstack2.guestbook.service;

import org.springframework.stereotype.Service;

import com.fullstack2.guestbook.dto.GuestBookDTO;
import com.fullstack2.guestbook.dto.PageRequestDTO;
import com.fullstack2.guestbook.dto.PageResultDTO;
import com.fullstack2.guestbook.entity.GuestBook;

/*
 * Service Interface 가 하는 일
 * 
 * 1. DTO --> Entity 변환(모든 Service 구현 객체가 이 기능은 필요하기 때문에 상속 목적으로
 * 	default로 정의함)
 * 2. 변환된 Entity를 JPA 로 처리하는 메서드 선언 및 필요 시 결과 리턴
 * 3. Super Service 인터페이스가 모든 CRUD 처리를 직접 구현할 필요가 없고, 그래서도 안 됨.
 * 따라서 이 super는 처리해야 할 메서드만 선언하고, 이를 직접 수행하는 구현객체를 자식으로 
 * 파생시켜서 Boot 에서 Bean 으로 처리하도록 해야 합니다.
 * 때문에, CRUD 목적에 맞는 각각의 구현체(Service implements Object) 클래스를 모두 정의해서
 * 다형성으로 Boot에서 처리하도록 하는게 spec 입니다. 
 */
@Service
public interface GuestBookService {

	Long register(GuestBookDTO guestBookDTO);
	
	
	PageResultDTO<GuestBookDTO,GuestBook> getList(PageRequestDTO pageRequestDTO);
	
	
	//방명록의 상세 내용을 조회하는 메서드 등록합니다.
	GuestBookDTO read(Long gno);
	
	//방명록의 내용을 수정하는 메서드 정의합니다.
	void modify(GuestBookDTO guestBookDTO);
	
	
	//DTO --> Entity로 변화하는 메서드를 default로 정의해서
	//하위 구현객체들이 사용할 수 있도록 합니다.
	
	default GuestBook dtoToEntity(GuestBookDTO guestBookDTO) {
		GuestBook guestBook = GuestBook.builder()
								.gno(guestBookDTO.getGno())
								.subject(guestBookDTO.getSubject())
								.content(guestBookDTO.getContent())
								.writer(guestBookDTO.getWriter())
								.build();
		return guestBook;
	}
	
	//Entity 를 DTO 로 변형하는 메서드 정의합니다.
	default GuestBookDTO entityToDto(GuestBook guestBook) {
		GuestBookDTO guestBookDTO = GuestBookDTO.builder()
								.gno(guestBook.getGno())
								.subject(guestBook.getSubject())
								.content(guestBook.getContent())
								.writer(guestBook.getWriter())
								.regDate(guestBook.getRegdate())
								.modDate(guestBook.getModDate())
								.build();
		return guestBookDTO;
	}
	
	
	
	
	
	
}
