package com.sopra.banking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.banking.Service.Services;
import com.sopra.banking.model.Bank;

@RestController
@RequestMapping("/soprabanking")
public class Controller {
	
	@Autowired
	private Services  serv;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Bank b){
		serv.createCust(b);
		return new ResponseEntity<>("Customer added",HttpStatus.CREATED);
	}
	
	@GetMapping("getbyAccNo/{acc_no}")
	public ResponseEntity<Bank> getByAccno(@PathVariable("acc_no") long acc_no ){
		Bank b=serv.getByAccNo(acc_no);
		return  new ResponseEntity<>(b,HttpStatus.OK);
		
	}
	
	@PutMapping("/deposit")
	public ResponseEntity<String> deposit(@RequestBody double amount , long acc_no){
		Bank b=serv.getByAccNo(acc_no);
		b.setBalance(b.getBalance()+amount);
		serv.update(b);
		return new ResponseEntity<String>("Amount deposited", HttpStatus.CREATED);
		
	}
	
	@PutMapping("/withdraw")
	public ResponseEntity<String> withdraw(@RequestBody double amount , long acc_no )
	{
		Bank b=serv.getByAccNo(acc_no);
		
		if(b.getBalance()>=amount) {
			b.setBalance(b.getBalance()-amount);
			serv.update(b);
			return new ResponseEntity<String>("Amount withdrawn", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Can't perform action", HttpStatus.NOT_ACCEPTABLE);

		
	}
	
}
