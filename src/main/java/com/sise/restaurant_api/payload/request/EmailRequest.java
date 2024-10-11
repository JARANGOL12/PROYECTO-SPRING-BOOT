package com.sise.restaurant_api.payload.request;



import lombok.Data;
@Data

public class EmailRequest {
      
      private String [] emailsTo;
      private String [] emailsCC;
      private String [] emailsBCC;
}
