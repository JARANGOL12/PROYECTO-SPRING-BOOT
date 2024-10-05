package com.sise.restaurant_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.restaurant_api.payload.request.ReporteMaestroRequest;
import com.sise.restaurant_api.services.IReporteService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired 
    IReporteService reporteService;
    
    @PostMapping("/maestro")
    public ResponseEntity<byte[]> reporteMaestro(@RequestBody  ReporteMaestroRequest reporteMaestroRequest) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.inline().filename("reporte-maestro.pdf").build());
            return new ResponseEntity<byte[]>(reporteService.reporteMaestro(reporteMaestroRequest), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<byte[]>((new byte[]{}), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
