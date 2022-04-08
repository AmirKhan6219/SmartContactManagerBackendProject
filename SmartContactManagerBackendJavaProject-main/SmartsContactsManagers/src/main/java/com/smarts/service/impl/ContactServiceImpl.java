package com.smarts.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.smarts.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarts.dto.ContactDto;
import com.smarts.entity.Contact;
import com.smarts.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ContactDto> getContacts() {
		return contactRepository.findAll().stream().map(contact -> modelMapper.map(contact, ContactDto.class))
				.collect(Collectors.toList());
	}
	@Override
	public ContactDto findByName(String firstName) {

		Contact findByFirstName = contactRepository.findByFirstName(firstName);

		if (findByFirstName.getIsActive().equals("N")) {
			return null;
		} else {
			return modelMapper.map(findByFirstName, ContactDto.class);
		}
	}

	@Override
	public ContactDto addContact(ContactDto contactDto) {

		Contact contact = modelMapper.map(contactDto, Contact.class);
		Contact addContact = contactRepository.save(contact);
		return modelMapper.map(addContact, ContactDto.class);

	}
	@Override
    public ContactDto removeContact(int contactId) {
		Contact contact = contactRepository.findById(contactId).orElseThrow();
		contact.setIsActive("N");
		ModelMapper modelMapper = new ModelMapper();
		Contact contactSave = contactRepository.save(contact);
		return modelMapper.map(contactSave, ContactDto.class);
	}
}