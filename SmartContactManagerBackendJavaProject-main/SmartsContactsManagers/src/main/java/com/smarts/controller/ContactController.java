package com.smarts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smarts.dto.ContactDto;
import com.smarts.service.impl.ContactServiceImpl;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceImpl contactService;

	@GetMapping("/findAllContacts")
	public List<ContactDto> getContacts(){

		return contactService.getContacts();
	}

	@GetMapping("/findByFirstName/{firstName}")
	public ContactDto findByName(@PathVariable("firstName") String firstName) {

        return contactService.findByName(firstName);
	}

	@PostMapping("/addContact")
	public ContactDto addContact(@RequestBody ContactDto contactDto) {
		return contactService.addContact(contactDto);
	}

    @DeleteMapping("/removeContact/{contactId}")
    public ContactDto removeContact(@PathVariable(value = "contactId", required = false) Integer contactId){
        return contactService.removeContact(contactId);
    }

}
