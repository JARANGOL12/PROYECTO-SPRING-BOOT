package com.sise.restaurant_api.payload.request;

import java.util.List;

import lombok.Data;

@Data
public class ReporteMaestroRequest {
    private String tituloReporte;
    private List<ReporteCabeceraRequest> cabeceras;
    private ReporteTablaRequest tabla;
}
