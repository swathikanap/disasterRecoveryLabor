package com.training.recovery.labor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.recovery.labor.model.Machine;
import com.training.recovery.labor.repo.MachineRepo;

@Service
public class MachineService {
	
	@Autowired
	MachineRepo maRepo;
	
	public List<Machine> getMachineList()
	{
		return maRepo.findAll();
	}
	public void deleteMachine(int id)
	{
		maRepo.deleteById(id);
	}
	public Machine getMachine(int id)
	{
		return maRepo.findById(id).get();
	}
	public Machine saveMachine(Machine m)
	{
		return maRepo.save(m);
	}
}