package com.training.recovery.labor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "job_code_mgmt")
public class JobCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String jobname;
	private String description;
	private int hourlyrate;
	private int maxhrsperday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHourlyrate() {
		return hourlyrate;
	}
	public void setHourlyrate(int hourlyrate) {
		this.hourlyrate = hourlyrate;
	}
	public int getMaxhrsperday() {
		return maxhrsperday;
	}
	public void setMaxhrsperday(int maxhrsperday) {
		this.maxhrsperday = maxhrsperday;
	}
}
