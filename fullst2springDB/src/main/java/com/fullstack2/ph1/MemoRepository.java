package com.fullstack2.ph1;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack2.ph1.entity.Memo;

/*
 * Repository : 스프링에서 제공하는 실제 CRUD 를 수행하는 인터페이스입니다.
 * 이 객체를 이용해서 Entity 객체를 대상으로 CRUD 를 진행하고, Entity 를 반영 결과를
 * 실제 Table 에 반영합니다.
 * 
 * 때문에 모든 작업은 이 객체를 이용하게 됩니다.
 * 
 * 이 인터페이스는 내부적으로 상속 관계를 갖게되는데, Super 로는 Repository 라는 애가 있고,
 * 하위로는 단계별로, DB 처리 시 필요한 기능을 추가로 정의한 애들로 구성되어 있습니다.
 * 
 * 이 중, JpaRepository 라는 최하위 인터페이스가 있는데, 얘는 위의 부모들이 정의한 CRUD의 기본 기능외에
 * 페이징 처리를 할 수 있는 기능까지 정의한 애입니다.
 * 
 * 때문에 기본적인 CRUD를 진행하는 경우, super 인터페이스를 사용하거나, 페이지 등의 처리까지 하는 경우엔
 * JpaRepository 를 사용하는게 일반적입니다.
 * 
 * 사용방법은 매우 간단합니다. Repository 를 수행하는 클래스를 선언하고 위 인터페이스 중 하나를 상속받으면
 * 끝납니다.
 * 
 * 이렇게 하면, 스프링이 수행되는 시점에 해당 인스턴스를 자동으로 생성해서 메모리에 올려주고,
 * 이렇게 올라간 Repository 의 메서드를 이용해서 CRUD 를 진행합니다.
 * 
 * 
 * JpaRepostiory 의 메서드
 * 
 * insert, update : save()
 * 
 * delete : deleteById(Key), delete(entity)
 * 
 * select : findById(key), getOne(key)
 * 
 * 
 */
//jpa Repository 제네릭 타입으로는 대상 Entity 객체명, 엔티티의 PK Type 을 줘야 함
public interface MemoRepository extends JpaRepository<Memo, Long>{
	
	List<Memo> findByMnoBetween(Long start, Long end);
	List<Memo> findByMemoTextLike(String key); //like 키워드로 memoText 내의 해당하는 문자열이 포함된 리스트 찾기
	Page<Memo> findByMnoBetween(Long start, Long end, Pageable pageable);
	
	
	//update Entity alias alias.컬럼명 = :parameter where m.mno = :mno
	
	@Transactional
	@Modifying//Select 쿼리가 아닌 쿼리 메서드에 선언하세요.
	@Query(value = "update Memo m SET m.memoText = :memoText where m.mno = :mno")
	int updateMemoText(@Param("mno") Long mno, @Param("memoText") String memotext);
	
}



