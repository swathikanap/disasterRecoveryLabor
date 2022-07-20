package com.training.recovery.labor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.recovery.labor.model.JobCode;
import com.training.recovery.labor.repo.JobCodeRepository;
import com.training.recovery.labor.service.JobCodeService;

@Service
public class JobCodeServiceImpl implements JobCodeService {

	@Autowired
	JobCodeRepository jobCodeRepo;

	public void createJobManagement(JobCode jobCode) {
		jobCodeRepo.save(jobCode);
	}

	@Override
	public List<JobCode> getJobCodeDetails() {
		List<JobCode> list=jobCodeRepo.findAllJobs();
		return list;
	}

	@Override
	public JobCode getJobCode(int id) {
		return jobCodeRepo.findById(id).get();
	}

	@Override
	public void delete(int id) {
		jobCodeRepo.deleteById(id);
	}

	@Override
	public JobCode update(JobCode jobCode) {
		return jobCodeRepo.save(jobCode);
	}

	

}
