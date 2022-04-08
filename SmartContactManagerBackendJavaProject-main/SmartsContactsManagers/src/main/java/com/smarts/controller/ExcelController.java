package com.smarts.controller;

import com.smarts.entity.Contact;
import com.smarts.service.ContactExcelExporterService;
import com.smarts.repository.ContactRepository;
import com.smarts.service.ExcelImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
public class ExcelController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ExcelImportService excelImportService;

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=UploadContactExcelFile.xlsx";
        response.setHeader(headerKey, headerValue);

        List<Contact> listContacts = contactRepository.findAll();

        ContactExcelExporterService excelExporter = new ContactExcelExporterService(listContacts);

        excelExporter.export(response);
    }

    @PostMapping("/import/excel")
    public void uploadDataFromExcel() {

        excelImportService.uploadAll();

    }
}
