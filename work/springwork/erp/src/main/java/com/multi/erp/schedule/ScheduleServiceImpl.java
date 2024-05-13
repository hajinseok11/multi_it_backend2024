package com.multi.erp.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ScheduleServiceImpl implements ScheduleService {

	private ScheduleDAO dao;
	@Autowired
	public ScheduleServiceImpl(ScheduleDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public int addSchedule(ScheduleDTO schedule) {
		return dao.addSchedule(schedule);
	}

	@Override
	public int modifySchedule(ScheduleDTO schedule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSchedule(String scheduleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ScheduleDTO readSchedule(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduleDTO> printSchedule(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
