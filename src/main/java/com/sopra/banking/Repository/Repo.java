package com.sopra.banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.banking.model.Bank;

@Repository
public interface Repo extends JpaRepository<Bank, Integer> {

}
