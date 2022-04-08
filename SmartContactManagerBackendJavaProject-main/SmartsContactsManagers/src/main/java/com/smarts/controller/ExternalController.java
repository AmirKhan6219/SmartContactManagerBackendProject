package com.smarts.controller;

import com.smarts.dto.ContactDto;
import com.smarts.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.smarts.service.impl.ContactServiceImpl;

@RestController
public class ExternalController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private ContactServiceImpl contactService;

	@Autowired
	private ExternalService externalService;

	@GetMapping("/fetchAllContacts/{isRemote}")
	public ResponseEntity<String> fetchAll(@PathVariable("isRemote") String isRemote) {

		return externalService.fetchAllContacts(isRemote);
	}


	@GetMapping("/fetchContactsByFirstName/{isRemote}/{firstName}")
	public ResponseEntity<ContactDto> fetchByFirstName(@PathVariable("isRemote") String isRemote,
													   @PathVariable("firstName") String firstName) {
		return externalService.findByName(isRemote, firstName);
	}

	@PostMapping("/postContacts/{isRemote}")
	public ResponseEntity<String> postContacts(@PathVariable("isRemote") String isRemote, @RequestBody ContactDto contactDto) {

		return externalService.postContacts(isRemote, contactDto);

	}

	@DeleteMapping("/deleteContact/{isRemote}/{contactId}")
	public ResponseEntity<ContactDto> deleteContacts(@PathVariable("isRemote") String isRemote,
												 @PathVariable(value = "contactId", required = false) Integer contactId) {
		return externalService.deleteContacts(isRemote, contactId);
	}
}


