package com.training.recovery.labor.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.recovery.labor.model.Machine;
import com.training.recovery.labor.service.MachineService;

@RestController
@RequestMapping("/machines")
public class MachineController {
	
	@Autowired
	private MachineService machineService;
	
	@GetMapping("/machine/{id}")
	public ResponseEntity<Machine> get(@PathVariable int id) {
	    try {
	    	Machine machine = machineService.getMachine(id);
	        return new ResponseEntity<Machine>(machine, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Machine>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PutMapping("/machine/{id}")
	public ResponseEntity<?> update(@RequestBody Machine machine, @PathVariable Integer id) {
	    try {
	      machine.setId(id);
	      machineService.saveMachine(machine);
	      return new ResponseEntity<>(HttpStatus.OK);	
	    }catch (NoSuchElementException e) {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@RequestMapping(value="/machine", method = RequestMethod.GET)
    public List<Machine> listMachine(){
        return machineService.getMachineList();
    }
	
	@RequestMapping(value = "/machine", method = RequestMethod.POST)
    public Machine create(@RequestBody Machine machine){
        return machineService.saveMachine(machine);
    }
	
	@RequestMapping(value = "/machine/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Integer id){
		machineService.deleteMachine(id);
        return "success";
    }
}
