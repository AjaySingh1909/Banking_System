package com.sopra.banking.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.banking.Repository.Repo;
import com.sopra.banking.model.Bank;

@Service
public class ServicesImpl implements Services{

	@Autowired
	private Repo repo;
	
	
	@Override
	public Bank createCust(Bank b) {
		return repo.save(b);
	}

	@Override
	public Bank getByAccNo(long acc_no) {
		Optional<Bank> prod=repo.findById((int) acc_no);
		return prod.get();
	}

	@Override
	public void update(Bank b) {
		// TODO Auto-generated method stub
		repo.save(b);
		
	}

}
