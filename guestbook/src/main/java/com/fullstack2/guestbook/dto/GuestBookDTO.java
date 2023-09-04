package com.fullstack2.guestbook.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * service layer 를 통해 Entity 로 변환되어지기 때문에
 * 기본적으로 Entity의 구성을 모두 가져야합니다.
 * 이 말은 곧, 하나의 사이트가 구성되어질 때 목적에 따라서 테이블 수 만큼, DTO와 Entity가 생성되어야 하고
 * 필요하다면, Entity 로 변환없이 date 전달목적으로만 사용되는 DTO 도 생성되어야 합니다.    
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestBookDTO {

	private Long gno;
	private String subject;
	private String content;
	private String writer;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	
}
