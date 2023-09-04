package com.fullstack2.ph1;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack2.ph1.entity.Memo;

@SpringBootTest
class Fullst2springDbApplicationTests {

/*
 * @Autowired**** : 속성(field), setter, constructor 에게 사용될 수 있는 어노테이션이다.(위치 기억할 것)
 * 이 하위에 선언된 타입에 따라서 알아서 Bean 생성해서 실행 시에 주입(Injection)을 해주는 기능
 * 이걸 사용하면 스프링이 알아서 자동 값 할당함....
 * 주로 사용하는 곳은 Controller 에서 DAO, Service(나중에 배움, 모델 영역계층이라 생각하세요)
 * 에 관한 객체를 주입할 때 사용됩니다.
 * 	
 */
	@Autowired
	MemoRepository memoRepository;
	

	
	@Test
	void queryAnnotation() {
		
		
		System.out.println(memoRepository.updateMemoText(100L, "오늘 수업 끝~~"));
		
		//@Query("string query") 를 이용해서 수행될 메서드를 직접 정의하는 방법입니다.
		/*
		 * 형식은 다음과 같음
		 * @Query("Select m(alias) from Memo(table명) m(alias) order by m.mno desc"
		 * List<Memo> getListDesceing();
		 * 
		 * 위 쿼리에는 우리가 DB에서 배운 함수 등도 그대로 사용가능합니다.
		 * 
		 * 만약 조건절에 들어갈 파라미터가 존재한다면, PreparedStatement 처럼
		 * 위치 홀더같은 키워드를 이용해서 파라미터 데이터를 바인딩 시킬 수 있습니다.
		 * 
		 * 홀더 타입
		 * ? : 자바의 그것과 같음
		 * ':xxx' -> 파라미터 이름을 매핑
		 * :#{} : 자바빈즈의 action 태그처럼 빈즈의 프러퍼티를 매핑하는 형태입니다.
		 * 
		 * 주의!! 한 번에 Select 와 Insert, Update 등이 동시에 수행될 때는 
		 * @Transaction 을 이용해서 commit, rollback 등을 처리해야 하고,
		 * 때에 따라서는 @Modifying 등을 이용해야 합니다.
		 * 
		 * @Query("update Entity alias alias.컬럼명 = :parameter where m.mno = :mno")
		 * 위에서 선언된 쿼리에 파라미터를 매핑하도록 메서드에서 선언해야 합니다.
		 * 아래는 위 쿼리가 update 구문이니 리턴이 1인 경우 해당 값을 리턴하도록 int 리턴하고 메서드명
		 * 선언합니다. @Param 을 이용해서 쿼리에 파라미터를 매핑합니다.
		 * int updateMemoText(@Param("mno") Long mno, @Param("memoText") String memoText)
		 * 
		 */
	}
	
	//@Test
	void queryMethodEx() {
		
		
		
		
		/*
		 * spring 에서는 다양한 형태의 쿼리를 진행할 수 있도록 ORM 을 두고있습니다.
		 * 지금 볼 내용은 Spring JPA 에서 제공하는 쿼리메서드입니다.
		 * 즉, 메서드 자체가 뭐리로 구성되어진다는 말입니다.
		 * 이 쿼리 메서드는 다양하게 구성되어지는데, 문서를 참조해서 활용 시 이용하세요.
		 * 대표인 예만 보고 넘어갈게요.
		 * 
		 * 원리 : Repository 에 쿼리 메서드를 선언합니다.
		 * 이 때 쿼리 메서드가 리턴하는 리턴 타입도 같이 명기합니다.
		 * 쿼리 메서드는 규칙이 존재하기 때문에 해당 규칙을 문서에서 확인해야 합니다.
		 * 
		 * 쉽게 생각하면 이렇게 됩니다.
		 * 리턴타입 쿼리메서드 : 쿼리메서드에는 엔티티를 대상으로 쿼리 시 사용하는 다양한 조건문 등을
		 * 구성하는 원리입니다.
		 * 
		 * ex>List<Entity> 엔티티를 대상으로 글넘버 기준으로 start ~ end 까지를 조회하도록 할 경우
		 * List<Entity> findByPKName 조회조건키워드(문서참조) 정렬기준 (p1(start row), p2(end row))
		 */
		
		//List<Memo> result = memoRepository.findByMnoBetween(50L, 100L);
		Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
		Page<Memo> result = memoRepository.findByMnoBetween(50L, 100L, pageable);
		
		result.get().forEach(System.out::println);
		
		/*
		result.forEach(System.out::println);
		
		result = memoRepository.findByMemoTextLike("%dd%");
		result.forEach(System.out::println);
		*/
		
		
	}
	
	
	//@Test
	void pageTest() {
		/*
		 * Pageable, Page, PageRequest 객체에 대해서 알아볼게요.
		 * 
		 * 엔티티의 갯수에 따른 페이징 처리를 해주는 세 개의 객체입니다.
		 * 제일 중요한 애가 Pageable 입니다. 이 놈은 PageRequest 의  static of() 를 통해서 얻어낼 수 있는데,
		 * 이 때 얻어낼 글 목록수를 파라미터로 넘깁니다.
		 * 그럼 해당 글들을 담은 Pageable 객체를 리턴합니다. 또한 of() 는 정렬을 지정할 수 있도록 오버로딩 되어 있는데,
		 * 이 때 정렬을 담당하는 Sort 객체를 파람으로 넘기면 정렬 적용된 Pageable 을 리턴합니다.(나중에 볼게요)
		 * 
		 * 
		 * Sort 객체에 대해서...정렬을 담당하는 객체이고 Pageable 생성시 파람으로 주게되면 됨
		 * Sort 객체 역시 Sort.of() 를 통해서 얻어낼 수 있습니다.
		 * by()의 파람으로는 정렬될 타겟 컬럼명이 들어오고, 정렬 기준 메서드를 바로 호출해서
		 * 객체를 얻어냅니다. 메서드 체인을 이용하면 편함.
		 * and(), or() 등을 이용해서 하나 이상의 정렬을 시킬 수 있습니다.
		 * 
		 * 
		 * 
		 * 이렇게 리턴 받은 Pageable 을 통해서 Page 객체를 얻어낼 수 있습니다. 페이지는 제네릭으로
		 * 목록을 구성하는 타입을(일반적으로 Entity)를 지정해서 이 때 사용되는 메서드는
		 * repository 의 findxxxxx(pageable 객체) 메서드입니다.
		 * 
		 * 이렇게 얻어낸 Page 객체는 리턴될 때 전체 글 목록수를 count 하는 쿼리를 자동 수행하도록
		 * 정의되었기 때문에, 이를 이용해서 또다른 작업을 수행할 수 있습니다.
		 */
		
			//순서 정의합니다.
			//1.Pageable을 얻어낸다...이건 PageRequest.of(페이지 번호(0부터 시작) , 글목록 카운터) 를 통해 얻어냄
			//2.얻어낸 Pageable 객체를 repository의 findAll()에 파라미터로 넘기면 
			//위 글 목록수를 담은 Page<Entity> 객체가 리턴됩니다.
			//3.얻어낸 Page 객체에 담긴 entity 를 통해 데이터를 처리하고, 또한
			//4.Page 내부에는 다양한 메서드가 있기 때문에, 해당 메서드를 이용해서
			//필요한 작업을 수행할 수 있습니다.
		
			//PageRequest 은 Pageable 의 하위 타입입니다.
			Sort sort1 = Sort.by("mno").descending();
			Sort sort2 = Sort.by("memo_text").ascending();
			sort1.and(sort2);
			Pageable pageable = PageRequest.of(0, 10,sort1);
			Page<Memo> page = memoRepository.findAll(pageable);

			//System.out.println(page);
			
			System.out.println("------------------------얻어낸 글목록들 및 Page 객체의 메서드 이용---------------------------------");
			for(Memo memo : page ) {
				System.out.println(memo);
			}
			
			//이번엔 page 객체가 생성될 때 수행되는 count(*) 을 이용, 내부적으로 처리되는
			//메서드를 확인해볼게요.
			System.out.println(page.getTotalPages());
			System.out.println(page.getNumber());
			System.out.println(page.getSize());//페이지 당 글 갯수
			System.out.println(page.isFirst());//첫 번째 페이지 여부
			System.out.println(page.hasNext());//다음페이지 존재 여부
			
			
	}
	
	//@Test
	void contextLoads() {
		//System.out.println(memoRepository.getClass().getName());
		
		
		/*
		//save(Entity를 이용해서 데이터를 밀어넣을게요..)
		
		//100개의 데이터를 밀어넣을게요.
		IntStream.rangeClosed(1, 100).forEach(i -> {
			//Memo 객체를 100개 생성해서 각 객체의 컬럼값을 설정후, save() 호출합니다.
			Memo memo = Memo.builder().memoText("이건 Sample 데이터 " + i).build();
			memoRepository.save(memo);
		});
		*/
		
		//Repository 의 Select 를 해볼게요.. find...() 를 이용해 볼게요.
		
		Long id = 99L;
		Optional<Memo> result = memoRepository.findById(id);
		
		//Optional 객체는 요소를 관리하는 애입니다. 당연히 요소는 컬렉션의 요소이기 때문에
		//타입이 정해져 있습니다. 즉 객체라는 뜻...따라서 getter를 쓸 때 리턴 타입을 잘 확인하세요.
		if(result.isPresent()) {
			Memo memo = result.get();
			System.out.println(memo);
		}
		
		//repository에 보면 getOne 이라는 메서드가 있습니다.
		//이용해서 1번 목록을 출력해보세요.
		Memo memo = Memo.builder().mno(100L).memoText("ddddd").build();
		memoRepository.save(memo);
		
		//Update 해볼게요...save(entity)를 이용하는데, PK를 기준으로 기존
		//엔티티와의 값을 비교해서 변경된 내용이면 update, 신규인 경우엔 insert 를 자동으로 처리합니다.
		/*
		
		memo = Memo.builder().mno(id).memoText("이건 수정(업데이트)된 내용입니다").build();
		memoRepository.save(memo);
		
		System.out.println("수정된 1번 글 내용 ---------------------------");
		memo = memoRepository.getReferenceById(id);
		System.out.println(memo);
		
		
		memoRepository.delete(memo);
		*/
		
		
		
		
		
		
		
	}

}
































