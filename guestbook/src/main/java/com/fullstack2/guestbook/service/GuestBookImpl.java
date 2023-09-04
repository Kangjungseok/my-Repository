package com.fullstack2.guestbook.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fullstack2.guestbook.dto.GuestBookDTO;
import com.fullstack2.guestbook.dto.PageRequestDTO;
import com.fullstack2.guestbook.dto.PageResultDTO;
import com.fullstack2.guestbook.entity.GuestBook;
import com.fullstack2.guestbook.entity.QGuestBook;
import com.fullstack2.guestbook.repository.GuestBookRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //의존성을 주입해주는 어노테이션입니다.
//얘는 어노테이션인데, 주 목적은 final 처럼, 인스턴스 생성 시 반드시 초기화 되어야하는 애들
//final, not null 필드 등의 값을 자동으로 의존성 주입을 해주는 애입니다.
//우리가 할 일은 이 구현 객체에 JPA를 이용해서 신규로 insert 를 할건데,
//그 repository를 final로 선언해야 합니다. 그렇기 떄문에 얘는 반드시 처음에 값이 
//초기화 되어야 하는데, 그 일을 위 어노테이션이 주입을 해줌으로써 가능하게됩니다.
public class GuestBookImpl implements GuestBookService {

	private final GuestBookRepository guestBookRepository;
	
	@Override
	public Long register(GuestBookDTO guestBookDTO) {
		
		GuestBook entity = dtoToEntity(guestBookDTO);
		guestBookRepository.save(entity);
		return entity.getGno();
	}

	
	//사용자가 요청한 page에 해당하는 글목록을 가져오는 메서드 정의
	@Override
	public PageResultDTO<GuestBookDTO, GuestBook> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("gno").descending());
		
		BooleanBuilder booleanBuilder = getSearch(pageRequestDTO);
		
		//Page 객체를 얻어내는데, 이 떄 내부 요소는 전부 Entity로 구성되어있습니다.
		//조건과 같이 검색할 수 있도록 findAll에 booleanBuilder 추가하세요.
		Page<GuestBook> result = guestBookRepository.findAll(booleanBuilder, pageable);
		
		//Java의 function 객체 생성합니다.
		Function<GuestBook, GuestBookDTO> fn = (entity -> entityToDto(entity));
		
		return new PageResultDTO<>(result, fn);
	}
	
	
	@Override
	public GuestBookDTO read(Long gno) {
		
		Optional<GuestBook> result = guestBookRepository.findById(gno);

		return result.isPresent() ? entityToDto(result.get()) : null;
		
	}

	//업데이트와 인서트는 모두 같은 메서드를 통해서 합니다.
	//save() 입니다. --> 기존 Entity의 값과 데이터 변환이 존재하면 Update, Entity 자체가
	//없으면 Insert 로 자동 처리합니다.
	@Override
	public void modify(GuestBookDTO guestBookDTO) {
		//modify.html 은 제목과 내용만 수정. 
		//일단 수정하기 전에 해당 Entity 가 존재하는지 부터 파악할게요. 있다면 변경후 save();
		Optional<GuestBook> result =  guestBookRepository.findById(guestBookDTO.getGno());
		if(result.isPresent()) {
			GuestBook entity = result.get();
			
			entity.changeSubject(guestBookDTO.getSubject());
			entity.changeContent(guestBookDTO.getContent());
			
			guestBookRepository.save(entity);
			
		}
	}
	
	
	//QueryDSL 을 이용해서 검색 조회를 수행후 결과 객체를 담고 있는 BooleanBuilder 를 리턴합니다.
	//이를 이용해서 검색된 내용을 담은 PageRequestDTO 를 생성하고 이를 View 층에 리턴시킬게요.
	
	private BooleanBuilder getSearch(PageRequestDTO pageRequestDTO) {
		String type = pageRequestDTO.getType();
		
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		
		//QEntity 객체를 통한 조회 작성 시작
		QGuestBook qguestBook = QGuestBook.guestBook;
		
		String keyword = pageRequestDTO.getKeyword();
		
		//조회 처리할 Expression 객체 생성 및 조회 조건 나열
		BooleanExpression booleanExpression = qguestBook.gno.gt(0L);
		
		booleanBuilder.and(booleanExpression);
		
		//조건 타입이 null 여부인지 검증합니다.
		if(type == null || type.length() == 0) {
			return booleanBuilder;
		}
		
		//타입이 존재한다는 말은 검색이 하나 이상 존재한다는 의미입니다.
		//따라서 검색 조건을 type 값에 맞도록 나열합니다.
		
		BooleanBuilder conditionBuilder = new BooleanBuilder();
		
		if(type.equals("t")) {//제목으로 찾는 경우, list.html 에서 설정됨
			//제목 필드에서 해당 keyword 가 존재하는지 찾기
			conditionBuilder.or(qguestBook.subject.contains(keyword));
		}
		if(type.equals("c")) {
			//내용에서 찾기를 설정한 경우
			conditionBuilder.or(qguestBook.subject.contains(keyword));
		}
		if(type.equals("w")) {
			//작성자에서 찾기를 설정한 경우
			conditionBuilder.or(qguestBook.subject.contains(keyword));
		}
		
		//모든 조회 조건을 통합합니다.
		booleanBuilder.and(conditionBuilder);
		return booleanBuilder;
		
	}
	
	
	
	
	
}













