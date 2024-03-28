package com.sopra.banking.Service;

import com.sopra.banking.model.Bank;

public interface Services {
	
	public Bank createCust(Bank b);
	
	public Bank getByAccNo(long acc_no);
	
	void update(Bank b);
}
