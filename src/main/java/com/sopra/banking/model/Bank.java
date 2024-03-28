package com.sopra.banking.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MyBanking")
public class Bank {
	
	@Nonnull
	String cust_id;
	
	@Id
	long acc_no;
	
	@Nonnull
	String ifsc;
	
	@Nonnull
	String cust_name;
	
	@Nonnull
	String  phone_no;
	
	@Nonnull
	String address;
	
	@Nonnull
	String acc_type;
	
	@Nonnull
	double balance;
	
	
	

}
