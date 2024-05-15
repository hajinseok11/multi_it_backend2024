package com.multi.erp.schedule;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
	private SqlSession sqlSessionTemplate;
	
	@Autowired
	public ScheduleDAOImpl(SqlSession sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int addSchedule(ScheduleDTO schedule) {
		return sqlSessionTemplate.insert("com.multi.erp.schedule.insert",schedule);
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
		return sqlSessionTemplate.selectList("com.multi.erp.schedule.select",id);
	}

}
