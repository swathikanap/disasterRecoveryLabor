package com.training.recovery.labor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.recovery.labor.model.Timesheet;

@Repository
public interface TimesheetRepo extends JpaRepository<Timesheet, Integer>{

}