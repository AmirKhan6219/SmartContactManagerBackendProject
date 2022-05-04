package com.smarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarts.dto.ContactDto;
import com.smarts.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	public Contact findByFirstName(String firstName);

	public Contact save(ContactDto contactDto);
	
}
