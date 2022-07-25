package com.training.recovery.labor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.recovery.labor.model.Job;
import com.training.recovery.labor.repo.JobRepo;

@Service
@Transactional
public class JobService {
	
	@Autowired
	JobRepo jobRepo;
	
	public List<Job> getJobList()
	{
		return jobRepo.findAll();
	}
	public void deleteJob(int id)
	{
		jobRepo.deleteById(id);
	}
	public Job getJob(int id)
	{
		return jobRepo.findById(id).get();
	}
	public Job saveJob(Job j)
	{
		return jobRepo.save(j);
	}
}
