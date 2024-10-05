package com.sise.restaurant_api.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



import lombok.Data;

@Data
public class SucursalRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String direccion;
    private String imagenUrl;

    @Size(min =9, max=11)
    @Pattern(regexp = "[0-9]*",message = "debe se numerico")
    private String telefono;

   @Email
   private String correo;
   private String diasAtencion;
   private String horarioAtencion;

   @NotBlank
   private String latitud;

   @NotBlank

   private String longitud;
   

    
}
