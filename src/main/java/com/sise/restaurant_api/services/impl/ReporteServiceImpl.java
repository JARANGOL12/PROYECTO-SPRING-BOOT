package com.sise.restaurant_api.services.impl;

import java.io.ByteArrayOutputStream;
import com.itextpdf.html2pdf.HtmlConverter;

import org.springframework.stereotype.Service;

import com.sise.restaurant_api.payload.request.ReporteCabeceraRequest;
import com.sise.restaurant_api.payload.request.ReporteMaestroRequest;
import com.sise.restaurant_api.payload.request.ReporteTablaRequest;
import com.sise.restaurant_api.services.IReporteService;
import com.sise.restaurant_api.shared.constants;
import java.util.List;

@Service
public class ReporteServiceImpl implements IReporteService {

    @Override
    public byte[] reporteMaestro(ReporteMaestroRequest reporteMaestroRequest) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<style>")
                .append(buildCSS())
                .append("</style>")
                .append("</head>")
                .append("<body>")
                .append(buildHeaderPdf())
                .append(builTituloReporte(reporteMaestroRequest.getTituloReporte()))
                .append(buildCabeceraReporte(reporteMaestroRequest.getCabeceras()))
                .append(buildTablaReporte(reporteMaestroRequest.getTabla()))
                .append("</body>")
                .append("</html>");

        HtmlConverter.convertToPdf(htmlBuilder.toString(), byteArrayOutputStream);

        return byteArrayOutputStream.toByteArray();
    }

    private String buildHeaderPdf() {
        return new StringBuilder()
                .append("<div class=\"header-pdf\">")
                .append("<img src=\"data:image/png;base64, " + constants.LOGO_B64 + "\"></img>")
                .append("<div class =\"titulo\">")
                .append("<h1>Restaurante Tengo Hambre</h1>")
                .append("<h3>Dirección: Av. Luis Pardo</h3>")
                .append("</div>")
                .append("</div>")
                .toString();
    }

    private String builTituloReporte(String titulo) {
        return new StringBuilder()
                .append("<div class =\"titulo-reporte\">")
                .append("<h1>")
                .append(titulo)
                .append("</h1>")
                .append("</div>")
                .toString();

    }

    private String buildCabeceraReporte(List<ReporteCabeceraRequest> reporteCabeceraRequests) {

        if (reporteCabeceraRequests == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<div>");

        sb.append("<table class=\"cabecera-reporte\">");

        for (int i = 0; i < reporteCabeceraRequests.size(); i++) {

            if (i % 3 == 0) {
                if (i > 0) {
                    sb.append("</tr>");
                }
                sb.append("<tr>");
            }

            ReporteCabeceraRequest request = reporteCabeceraRequests.get(i);

            String campo = request.getCampo() != null ? request.getCampo() : "";
            String contenido = request.getContenido() != null ? request.getContenido() : "";

            sb.append("<td>")
                    .append(campo).append(": ").append(contenido)
                    .append("</td>");
        }

        sb.append("</tr>");
        sb.append("</table>");

        sb.append("</div>");

        return sb.toString();
    }

    private String buildTablaReporte(ReporteTablaRequest reporteTablaRequest) {
        if (reporteTablaRequest == null) {
            return "<p>No hay datos</p>";
        }
 
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"contenedor\">");
        sb.append("<table class=\"tabla-reporte\">") 
                .append("<thead class= \"tabla\">")
                .append("<tr>");
        if (reporteTablaRequest.getCabeceras() != null) {
            for (String cabecera : reporteTablaRequest.getCabeceras()) {
                sb.append("<th>") 
                        .append(cabecera)
                        .append("</th>");
            }
        }

        sb.append("</tr>")
                .append("</thead>")
                
                .append("<tbody class = \"datos\">");

        if (reporteTablaRequest.getData() != null) {
            for (List<String> datos : reporteTablaRequest.getData()) {
                sb.append("<tr>"); 
                for (String dato : datos) {
                    sb.append("<td>") 
                            .append(dato)
                            .append("</td>");
                }
                sb.append("</tr>"); 
            }
        }

        sb.append("</tbody>")
                .append("</table>");  
        sb.append("</div>");

        return sb.toString(); 
    }

    private String buildCSS() {
        return new StringBuilder()

                .append("body {")
                .append("font-family:helvetica")
                .append("}")
                .append(".header-pdf {")
                .append("background-color: #150909;")
                .append("border-radius: 10px;")
                .append("padding: 20px;")
                .append("display:flex;")
                .append("flex-direction:row;")
                .append("align-items:center")
                
                .append("}")

                .append(".header-pdf h1 {")
                .append("color: #fff;")
                .append("text-align: center;")
                .append("margin:0px")
                .append("margin-top:6px")
                .append("}")

                .append(" .header-pdf h3 {")
                .append("color: #fff;")
                .append("text-align: center;")
                .append("margin:0px")
                .append("font-weight:normal")
                .append("}")

                .append(".header-pdf .titulo {")
                .append("width:100%")

                .append("}")

                .append(".header-pdf img {")
                .append("width:150px;")
                .append("height:150px")
                .append("text-align: center;")
                .append("}")

                .append(".titulo-reporte {")
                .append("border: solid 5px #48e;")
                .append("border-radius:6px;")
                .append("text-align:center;")
                .append("color:000;")
                .append("width:685px;")
                .append("height:40px;")
                .append("line-height: 8px;")
                
               
                .append("margin-top:40px;")


                .append("}")

                

                .append(".tabla th,td {")
                   .append("text-align: center;")
                   .append(" padding: 20px;")
                   .append(" padding-bottom: 9px;")
                   .append("font-family: sans-serif;")
                   .append("border:none;")
                   .append("border-bottom: 2px solid #fff;")
                   .append("font-size:2rem;")
                   .append("color:fff;")
                   .append("margin-left: 20px;")
                   .append("margin-top:30px;")
                   .append("border-radius:8px;")
                   
                .append("}")

                
                .append(".datos th,td {")
                   .append("text-align: center")
                   .append(" padding: 6px;")
                   .append(" padding-bottom: 9px;")
                   .append("font-family: sans-serif;")
                   .append("border:none;")
                   .append("margin-left:5px;")
                   .append("border-bottom: 2px solid #fff;")
                   
                   
                .append("}")

                .append(".cabecera-reporte {")
                .append("background-color:#48e;")
                .append("width:695px;")
                .append("height:180px")
                .append("position:flex")
                .append("border:none")
                .append("margin-top:80px;")
                .append("border-radius:10px;")
                .append("border-bottom:10px;")

                
                .append("}")
                


                
             
                .append(".tabla-reporte {")
                .append("width: 100%;")
                .append("  max-width: 500px;")
                .append("margin: auto;")
                .append(" box-shadow:0px 0px 25px #000;")
 
                .append("}")

                .append(".contenedor {")
                .append("background-color:#000;")
                .append("border-radius:10px;")
                
                
 
                .append("}")


                .append(".tabla-data td {")
                .append("border:0px;")

                .append("}")

                .toString();
    }
}
