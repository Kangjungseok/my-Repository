package com.fullstack2.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.fullstack2.guestbook.entity.GuestBook;
/*
 * Query DSL 사용하는 이유 : entity에 사용된 필드를 조회 시 조건문으로 편하게 이용할 수 있고,
 * 조건문이 많은 경우, 즉 and or = 등이 많이 사용될 때 기본 JPA 보다 편합니다. (사람마다 틀림)
 * 여튼 사용해봅니다.
 * 
 * 사용방식은 아래와 같음.
 * 
 * 1. QEntity 객체를 생성합니다. 생성방법은 build 를 거치면 Entity 명 앞에 Q가 붙은 QueryDSL
 * 클래스가 빌드되는데, 이 클래스.Entity 명으로 객체를 생성합니다. ex> QEntity q = QEntity.guestbook
 * 
 * 2. 조건절에 사용될 키워드 선언
 * 
 * 3. 실제 쿼리를 연동하고, 기존 JPA의 Pageable 객체와 협엽되는 객체는 
 * BooleanBuilder 라는 객체입니다. 이 객체를 이용해서 JPA의 find....() 라는 select 메서드를
 * 통해 Page 목표하는 목록이 담긴 Page를 리턴받습니다.
 * 이 객체는 기본 생성자를 통해 얻어냄
 * 
 * 4. 조건식을 정의하는 객체 : BooleanExpression 이 객체는 조건 Select 를 수행할 때
 * 위 지정된(2번) 찾으려는 키워드를 기준으로 어떤 컬럼에서 수행할 지를 결정하는 객체입니다.
 * 이 때 사용되는 DB 컬럼의 역할을 하는 기준은 entity의 필드명이 됩니다. (이게 편함)
 * 그리고 어떤 조건으로 찾을지는 해당 객체의 메서드를 통해 수행할 수 있음... 필요에 따라 조건을 중첩가능함
 * 
 * 
 */
public interface GuestBookRepository extends JpaRepository<GuestBook, Long>, QuerydslPredicateExecutor<GuestBook> {

}
