package com.fullstack2.guestbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GuestBook extends BaseEntity {

	//방명록 테이블에 추가 사용될 컬럼 정의, 글번호, 제목, 내용, 작성자 컬럼을 생성하고 관리하도록 합니다.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gno;
	
	@Column(length = 200,nullable = false)
	private String subject;
	
	@Column(length = 2000,nullable = false)
	private String content;
	
	@Column(length = 50, nullable = false)
	private String writer;
	
	public void changeSubject(String subject) {
		this.subject = subject;
	}
	
	public void changeContent(String content) {
		this.content = content;
	}
}
