package com.sise.restaurant_api.shared;

import java.util.List;

import org.springframework.validation.FieldError;


public class Util {
    
    public static String getOneMessageFromErrors(List<FieldError> errors){
        String message = "";
        for (FieldError error : errors) {
            if(!message.isEmpty()){
                message += ", ";
            }
            message += "El campo " + error.getField() + " " + error.getDefaultMessage();
        }
        return message+".";
    }

}
