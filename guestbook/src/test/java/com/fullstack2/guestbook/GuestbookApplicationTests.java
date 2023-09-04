package com.fullstack2.guestbook;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fullstack2.guestbook.entity.GuestBook;
import com.fullstack2.guestbook.entity.QGuestBook;
import com.fullstack2.guestbook.repository.GuestBookRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@SpringBootTest
class GuestbookApplicationTests {

	@Autowired
	GuestBookRepository guestBookRepository;
	
	//@Test
	void contextLoads() {
		IntStream.rangeClosed(1, 300).forEach(i -> {
			GuestBook guestBook = GuestBook.builder()
											.subject("이건 제목 " + i)
											.content("이건 내용 "+ i)
											.writer("회원 " + i)
											.build();
			System.out.println(guestBookRepository.save(guestBook));
		});
		
	}

	@Test//QueryDSL의 조건 Select unit test
	public void testDSL() {
		//우리 DB에 300개 이상의 목록이 존재하는 Pageable 을 통해 원하는 index 만 얻도록
		//Pageable 객체 생성 및 sort 기준 설정함
		Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
		
		//QEntity 객체 발생합니다.
		QGuestBook qGuestBook = QGuestBook.guestBook;
		
		String keyword = "1";
		
		//BooleanBuilder 객체 생성함
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		
		//조건 select를 지정하고 수행할 BooleanExpress 객체 생성.
		//객체 생성은 위의 QGuestBook 객체가 Entity를 Binding 하고 있기 때문에
		//해당 객체의 필드.검색메서드(검색키워드) 통해 얻습니다.
		
		BooleanExpression subjectExp = qGuestBook.subject.contains(keyword);
		BooleanExpression contentExp = qGuestBook.content.contains(keyword);
		
		BooleanExpression all = subjectExp.or(contentExp);
		
		//Select 수행 후 리턴된 booleanExpression 를 builder 객체에 추가
		booleanBuilder.and(all);
		
		//여기에 검색 조건을 또 추가 해볼게요..builder 내의 and, or, 기타 메서드를 통해
		//기존 조건에 추가할 수 있어요..방식은 qEntity 객체.필드.조회조건메서드를 사용합니다.
		booleanBuilder.and(qGuestBook.gno.gt(250));
		
		//위에서 QueryDSL 을 이용해서 조건을 통한 결과셋을 얻었으니
		//이를 JPA의 메서드인 findSomething() 을 통해 page와 함께 목록을 얻어냅니다.
		Page<GuestBook> result = guestBookRepository.findAll(booleanBuilder, pageable);
		
		result.forEach(guestbook -> {
			System.out.println(guestbook);
		});
		
		
	}
	
	
	
}
