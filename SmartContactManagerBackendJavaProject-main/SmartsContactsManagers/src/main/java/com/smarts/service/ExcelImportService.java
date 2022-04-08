package com.smarts.service;

import com.smarts.entity.Contact;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ExcelImportService {

    public void exportData(ResponseEntity responseEntity) throws IOException;

    List<Contact> listAll(HttpServletResponse response);

    public List<Contact> uploadAll();
}
