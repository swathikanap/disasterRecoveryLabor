package com.training.recovery.labor.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.recovery.labor.model.JobCode;

@Repository
public interface JobCodeRepository extends JpaRepository<JobCode, Integer> {

	@Query(value = "select * from job_code_mgmt", nativeQuery = true)
	public List<JobCode> findAllJobs();

}
