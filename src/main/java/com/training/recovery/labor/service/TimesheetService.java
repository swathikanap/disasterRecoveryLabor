package com.training.recovery.labor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.recovery.labor.model.Timesheet;
import com.training.recovery.labor.repo.TimesheetRepo;

@Service
@Transactional
public class TimesheetService {
	
	@Autowired
	TimesheetRepo tiRepo;
	
	public List<Timesheet> getTimesheetList()
	{
		return tiRepo.findAll();
	}
	public void deleteTimesheet(int id)
	{
		tiRepo.deleteById(id);
	}
	public Timesheet getTimesheet(int id)
	{
		return tiRepo.findById(id).get();
	}
	public Timesheet saveTimesheet(Timesheet t)
	{
		return tiRepo.save(t);
	}
}
