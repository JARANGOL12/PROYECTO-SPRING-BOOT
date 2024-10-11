package com.sise.restaurant_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.restaurant_api.payload.request.EmailRequest;
import com.sise.restaurant_api.services.IEmailService;
import com.sise.restaurant_api.shared.BaseResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/email")
public class EmailController {

      @Autowired
      private IEmailService emailService;
  
      @PostMapping("/send-welcome")
      public ResponseEntity<BaseResponse> sendWelcome(@RequestBody EmailRequest emailRequest) {
          try {
              emailService.sendWelcome(emailRequest);
              return new ResponseEntity<>(BaseResponse.success(), HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(BaseResponse.error(e.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }
      @PostMapping("/send-notice")
      public ResponseEntity<BaseResponse> sendNotice(@RequestBody EmailRequest emailRequest) {
          try {
              emailService.sendNotice(emailRequest);
              return new ResponseEntity<>(BaseResponse.success(),HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(BaseResponse.error(e.toString()),HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }

}
