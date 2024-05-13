package com.multi.erp.schedule;

import java.util.List;

public interface ScheduleService {
	//스케쥴등록하기
	int addSchedule(ScheduleDTO schedule);
	//스케쥴수정하기 
	int modifySchedule(ScheduleDTO schedule);
	//스케쥴삭제하기
	int deleteSchedule(String scheduleId);
	//스케쥴상세조회
	ScheduleDTO readSchedule(String scheduleId);
	//스케쥴조회 - 모든 스케쥴을 조회하지 않고 로그인한 사용자의 스케쥴만 조회
	List<ScheduleDTO> printSchedule(String id);
	
}
