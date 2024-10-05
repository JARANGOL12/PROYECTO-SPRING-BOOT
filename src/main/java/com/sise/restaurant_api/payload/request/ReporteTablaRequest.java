package com.sise.restaurant_api.payload.request;

import lombok.Data;
import java.util.List;

@Data
public class ReporteTablaRequest {
      private List<String> cabeceras;
      private List<List<String>> data;
}
