package com.training.recovery.labor.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.recovery.labor.model.JobCode;
import com.training.recovery.labor.service.JobCodeService;

@RestController
@RequestMapping("/jobmanagement/")
public class JobCodeController {

	private final JobCodeService jobCodeService;

	@Autowired
	public JobCodeController(final JobCodeService jobCodeService) {
		this.jobCodeService = jobCodeService;
	}

	@PostMapping("create")
	public ResponseEntity<JobCode> createJobCodeManagement(@RequestBody JobCode jobCode) {
		try {
			this.jobCodeService.createJobManagement(jobCode);
			System.out.println("Created job management entry into DB");
		} catch (Exception exe) {
			return new ResponseEntity<JobCode>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<JobCode>(HttpStatus.CREATED);

	}

	@GetMapping("getAllJobs")
	public ResponseEntity<List<JobCode>> getAllJobCodes() {
		List<JobCode> jobCodeDetails = jobCodeService.getJobCodeDetails();
		System.out.println(" List Size " + jobCodeDetails.size());
		return new ResponseEntity<List<JobCode>>(jobCodeDetails, HttpStatus.ACCEPTED);
	}

	@GetMapping("/jobcode/{id}")
	public ResponseEntity<JobCode> get(@PathVariable int id) {
		try {
			JobCode obj = jobCodeService.getJobCode(id);
			return new ResponseEntity<JobCode>(obj, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<JobCode>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/editjobcode/{id}")
	public ResponseEntity<JobCode> update(@RequestBody JobCode jobCode, @PathVariable int id) {

		try {
			jobCode.setId(id);
			JobCode response = jobCodeService.update(jobCode);
			return new ResponseEntity<JobCode>(response, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<JobCode>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/deletejobcode/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		try {
		jobCodeService.delete(id);
		} catch (Exception exe) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
