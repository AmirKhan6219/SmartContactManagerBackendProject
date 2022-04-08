package com.smarts.service;
import com.smarts.controller.ContactController;
import com.smarts.dto.ContactDto;
import com.smarts.entity.Contact;
import com.smarts.service.impl.ContactServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ExternalService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ContactController contactController;

    @Autowired
    private ContactServiceImpl contactService;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<String> fetchAllContacts(@PathVariable("isRemote") String isRemote) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            if (isRemote.equalsIgnoreCase("Y")) {
                return restTemplate.exchange("http://10.50.2.204:8080/contact/searchDataApi/0", HttpMethod.GET, entity, String.class);
            } else if (isRemote.equalsIgnoreCase("N")) {
                return new ResponseEntity(contactService.getContacts(), HttpStatus.OK);
            }
        } catch (Exception e){

            return new ResponseEntity("The Server is stop. Please Re-run the Server and try again!", HttpStatus.OK);
        }
        return new ResponseEntity("Please Enter either Y or N", HttpStatus.OK);
    }

    public ResponseEntity<String> postContacts(@PathVariable("isRemote") String isRemote, @RequestBody ContactDto contactDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Contact contact = modelMapper.map(contactDto, Contact.class);

        HttpEntity<Contact> entity = new HttpEntity<>(contact, headers);

        try {
            if (isRemote.equalsIgnoreCase("Y")) {
                return restTemplate.exchange("http://10.50.2.204:8080/contact/saveDataApi/0", HttpMethod.POST, entity, String.class);
            } else if (isRemote.equalsIgnoreCase("N")) {
                return new ResponseEntity(contactService.addContact(contactDto), HttpStatus.OK);
            }
        } catch (Exception e){

            return new ResponseEntity("The Server is stop. Please Re-run the Server and try again!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Please Enter either Y or N", HttpStatus.OK);
    }

    public ResponseEntity<ContactDto> findByName(String isRemote, String firstName) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        if (isRemote.equalsIgnoreCase("Y")) {
            return restTemplate.exchange("http://10.50.2.204:8080/contact/0" + firstName, HttpMethod.GET, entity,
                    ContactDto.class);
        } else if (isRemote.equalsIgnoreCase("N")) {
            return new ResponseEntity<ContactDto>(contactService.findByName(firstName), HttpStatus.OK);
        }

        return null;
    }

    public ResponseEntity<ContactDto> deleteContacts(String isRemote, Integer contactID) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        if (isRemote.equalsIgnoreCase("Y")) {
            return restTemplate.exchange("http://10.50.2.204:8080/contact/delete/0/" + contactID, HttpMethod.DELETE, entity,
                    ContactDto.class);
        } else if (isRemote.equalsIgnoreCase("N")) {
            return new ResponseEntity<ContactDto>(contactService.removeContact(contactID), HttpStatus.OK);
        }

        return null;
    }

}
