package com.multi.erp.schedule;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
	private String scheduleId;//스케쥴번호
	private String scheduleUserId;//스케쥴등록 사용자
	// Converter 직접 정의해서 사용하거나 요청파라미터들은 모두 문자열이므로 이를 java.util.Date로 변환해준다.
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date scheduleDay;//스케쥴날짜
	private String title;//스케쥴타이틀
	private String category;//스케쥴카테고리
	private String boss;//스케쥴참조할 상사
	private String place;//스케쥴장소
	private String content;//스케쥴간략내용
	private String state;//스케쥴진행상황
	
}
