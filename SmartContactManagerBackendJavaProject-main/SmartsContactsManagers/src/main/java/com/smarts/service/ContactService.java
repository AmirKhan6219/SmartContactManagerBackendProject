package com.smarts.service;

import java.util.List;

import com.smarts.dto.ContactDto;

public interface ContactService {
	
	public List<ContactDto> getContacts();
	
	public ContactDto findByName(String firstName);
	
	public ContactDto addContact(ContactDto contactDto);

	public ContactDto removeContact(int contactId);


	
	

}
