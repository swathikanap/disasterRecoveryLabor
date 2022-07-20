package com.training.recovery.labor.service;

import java.util.List;

import com.training.recovery.labor.model.JobCode;

public interface JobCodeService {
	
	public List<JobCode> getJobCodeDetails();
	public JobCode getJobCode(int id);
	public void createJobManagement(JobCode jobCode);
	public void delete(int id);
	public JobCode update(JobCode jobCode);
		
	
	}


